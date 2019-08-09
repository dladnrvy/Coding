package com.bitcamp.guest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.guest.Service.GetMessageListService;
import com.bitcamp.guest.domain.MessageListView;

@Controller
public class GuestListController {
	
	@Autowired
	private GetMessageListService listService;

	@RequestMapping("/guest/list")
	public String list(@RequestParam(value="page" , defaultValue= "1") int pageNumber, Model model) {
		
		MessageListView listview = listService.getMessageListView(pageNumber);
		model.addAttribute("viewData", listview);
		
		return "guest/list";
	}
	

	@RequestMapping("/guest/listJson")
	@ResponseBody
	//json 라이브러리 와 responseBodt를 함께 사용하면 - 들어오는 객체를 json 으로 변환해서 응답
	//반환하는 객체 형태를 응답으로 처리하겠다.	
	public MessageListView getListJson(
			@RequestParam(
					value = "page", 
					defaultValue = "1") int pageNumber,
			Model model
			) {
		
		MessageListView listView = 
				listService.getMessageListView(pageNumber);
		
		return listView;
	}
}

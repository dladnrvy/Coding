package com.bitcamp.guest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}

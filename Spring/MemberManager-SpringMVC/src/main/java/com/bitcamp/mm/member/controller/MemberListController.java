package com.bitcamp.mm.member.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.mm.member.domain.ListViewData;
import com.bitcamp.mm.member.domain.SearchParam;
import com.bitcamp.mm.member.service.MemberListService;

@Controller
public class MemberListController {

	
	@Autowired
	private MemberListService listService;
	
	@RequestMapping("/member/memberList")
	public String memberList(Model model, @RequestParam(value="p", defaultValue = "1") int pageNumber,
			//required 해당 파라미터가 필수인지 여부
			@RequestParam(value="stype", required = false) String stype,
			@RequestParam(value="keyword", required = false) String keyword){
		
		
		
		SearchParam searchParam = null ;
		
		if(stype !=null && keyword !=null && !stype.isEmpty() && !keyword.isEmpty()) {
			searchParam = new SearchParam();
			searchParam.setStype(stype);
			searchParam.setKeyword(keyword);
		}
		
		ListViewData listdata = listService.getListData(pageNumber , searchParam);
		
		/*
		 * for(MemberInfo m : listdata.getMemberList()) { System.out.println(m); }
		 */
		
		model.addAttribute("viewData", listdata);
		
		
		return "member/memberList";
	}
	
	//제이슨사용
	@RequestMapping("/member/json/memberListJson")
	public @ResponseBody ListViewData memberListJson(@RequestParam(value="p", defaultValue = "1") int pageNumber,
			//required 해당 파라미터가 필수인지 여부
			@RequestParam(value="stype", required = false) String stype,
			@RequestParam(value="keyword", required = false) String keyword,
			HttpServletResponse response
			){
		
		
		
		SearchParam searchParam = null ;
		
		if(stype !=null && keyword !=null && !stype.isEmpty() && !keyword.isEmpty()) {
			searchParam = new SearchParam();
			searchParam.setStype(stype);
			searchParam.setKeyword(keyword);
		}
		
		ListViewData listdata = listService.getListData(pageNumber , searchParam);
		
		//response.setStatus(HttpServletResponse.SC_OK);
		//response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		
		return listdata;
	}
	
	//반환타입이 ResponseEntity<T> : Spring 4.2이상
	//반환 하는 Body, statusCode, HttpHeader
		@RequestMapping("/member/json/memberListJson2")
		@ResponseBody
		public ResponseEntity<ListViewData> memberListJson2
				(@RequestParam(value="p", defaultValue = "1") int pageNumber,
				@RequestParam(value="stype", required = false) String stype,
				@RequestParam(value="keyword", required = false) String keyword
				){
						
			SearchParam searchParam = null ;
			
			if(stype !=null && keyword !=null && !stype.isEmpty() && !keyword.isEmpty()) {
				searchParam = new SearchParam();
				searchParam.setStype(stype);
				searchParam.setKeyword(keyword);
			}
			
			ListViewData listdata = listService.getListData(pageNumber , searchParam);
			
			//response.setStatus(HttpServletResponse.SC_OK);
			//response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			//response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			ResponseEntity<ListViewData> entity = new ResponseEntity<ListViewData>(listdata, HttpStatus.OK);
			
			return entity;
		}
}

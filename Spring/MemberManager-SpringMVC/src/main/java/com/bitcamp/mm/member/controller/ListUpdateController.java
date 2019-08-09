package com.bitcamp.mm.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.RequestMemberEdit;
import com.bitcamp.mm.member.service.MemberUpdateService;


@Controller
@RequestMapping("/member/update")
public class ListUpdateController {
	
	@Autowired
	private MemberUpdateService editService;
	
	//수정폼
	@RequestMapping(method = RequestMethod.GET)
	public String listupdateForm(@RequestParam("memberId") int id, Model model) {
		
		MemberInfo memberInfo = editService.getEditFormData(id);
		
		model.addAttribute("editData", memberInfo);
		
		return "member/listUpdateForm";
	}
	
	//수정
	@RequestMapping(method = RequestMethod.POST)
	public String listupdate(HttpServletRequest request, RequestMemberEdit edit) {
		
		int Cnt = 0;
		Cnt = editService.edit(edit, edit.getOldFile(), request);
		
		return "redirect:/member/memberList";
	}
}

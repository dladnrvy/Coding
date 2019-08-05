package com.mem.member;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mem.member.DAO.memberDAO;
import com.mem.member.Service.memberService;
import com.mem.member.model.MemberSave;

@Controller
public class MemberController {

	@Autowired
	private memberService memberservice;
	
	//로그인폼
	@RequestMapping(value="/member/LoginForm")
	public String loginForm() {	
		return "member/LoginForm";
	}
	
	//로그인
		@RequestMapping(value="/member/Login")
		public String login() {	
			return "member/Login";
		}
	
	//회원가입폼
	@RequestMapping("/member/memberRegform")
	public String memberRegform() {

		return "member/memberRegform";
	}
	
	//회원가입
	@RequestMapping(value = "/member/memberReg", method = RequestMethod.POST)
	public String memberReg(MemberSave membersave, Model model) {

		memberservice.MemberInsert(membersave);
		System.out.println("회원가입 완료 :" + membersave);
		model.addAttribute("reg", membersave);
		
		return "member/memberReg2";
	}
	
	
}

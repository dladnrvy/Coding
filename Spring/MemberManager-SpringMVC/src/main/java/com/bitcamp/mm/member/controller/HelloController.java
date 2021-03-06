package com.bitcamp.mm.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.mm.member.domain.MemberInfo;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String page() {
		
		MemberInfo info = null;
		
		System.out.println(info.getuId());
		
		return "main";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String handlerNullpointExeception(NullPointerException ex) {
		
		
		return "error/nullException";
	}
	
}

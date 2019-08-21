package com.bitcamp.mvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Login {

	private String uId;
	//사용하면 비공개처리
	@JsonIgnore
	private String uPw;
	
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	
	
}

package com.bitcamp.guest.domain;

public class Message {

	private int message_id;
	private String guest_Name;
	private String password;
	private String message;
	
	public int getId() {
		return message_id;
	}
	
	public Message() {}
	
	public Message(int message_id, String guest_Name, String password, String message) {		
		this.message_id = message_id;
		this.guest_Name = guest_Name;
		this.password = password;
		this.message = message;
	}
	
	
	public void setId(int message_id) {
		this.message_id = message_id;
	}
	public String getGuestName() {
		return guest_Name;
	}
	public void setGuestName(String guest_Name) {
		this.guest_Name = guest_Name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean hasPassword() {
		return password != null && !password.isEmpty();
	}
	
	// 삭제시에 비밀번호 비교
	public boolean matchPassword(String pw) {
		return hasPassword() && password.equals(pw);
	}
}

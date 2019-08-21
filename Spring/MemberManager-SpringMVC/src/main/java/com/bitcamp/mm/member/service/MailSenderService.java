package com.bitcamp.mm.member.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailSenderService")
public class MailSenderService {

	@Autowired
	private JavaMailSender sender;
	
	public int send(String email) {
		
		MimeMessage message = sender.createMimeMessage();
		
		try {
			message.setSubject("[욱표랜드]강다은님 회원가입을 축하합니다", "UTF-8");
			String htmlMsg = "<h1>축하합니다. 탈퇴는 없습니다.</h1>";
			message.setText(htmlMsg, "UTF-8", "html");
			message.setFrom(new InternetAddress("pyo0829@naver.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(email, "고객님", "UTF-8"));
			
			sender.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return 1;
	}
	
	public void send(String getuId, String code) {
		
		MimeMessage message = sender.createMimeMessage();
		
			try {
				message.setSubject("회원가입을 축하합니다","UTF-8");
				String htmlMsg = "<h1>회원가입을 축하해</h1>";
				htmlMsg += "<h3>인증을 위해 링크를 클릭해주세요</h3>";
				htmlMsg += "<h3><a href=\"http://localhost:8080/mm/member/verify?id="+getuId+"&code="+code+"\" >인증하기</a></h3>";
				
				message.setText(htmlMsg, "UTF-8","html");
				message.setFrom(new InternetAddress("dnrvy6719@gmail.com"));
				message.addRecipient(RecipientType.TO, new InternetAddress(getuId, "고객님","UTF-8"));
				
				sender.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		
	}
	
	public void resend(String getuId, String code) {
		
		MimeMessage message = sender.createMimeMessage();
		
		try {
			message.setSubject("인증처리 메일","UTF-8");
			String htmlMsg = "<h3>인증처리를 하시려면 하단의 링크를 클릭하세요.</h3>";
			htmlMsg += "<h3><a href=\"http://localhost:8080/mm/member/verify?id="+getuId+"&code="+code+"\" >인증하기</a></h3>";
			
			message.setText(htmlMsg, "UTF-8","html");
			message.setFrom(new InternetAddress("dnrvy6719@gmail.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(getuId, "고객님","UTF-8"));
			
			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
	
}

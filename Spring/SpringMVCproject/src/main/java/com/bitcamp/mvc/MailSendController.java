package com.bitcamp.mvc;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailSendController {

	@Autowired
	MailSender sender;
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@RequestMapping("/mail/send")
	public String sendMail() {
		
		//메일 내용 설정
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("pyo0829@naver.com");
		message.setSubject("강다은 바보");
		message.setText("다은이는 바보래요");
		message.setFrom("dnrvy6719@gmail.com");
		
		//재 사용
		SimpleMailMessage m = new SimpleMailMessage(message);
		
		sender.send(message);
		
		
		return "send OK";
	}
	
	/*
	 * @RequestMapping("/mail/send2") public String sendJavaMailSender(){
	 * 
	 * MimeMessage message = JavaMailSender.createMimeMessage();
	 * 
	 * try { //메일 제목 설정 message.setSubject("[안내]비트캠프 강모씨 알고보니 이중인격인걸로 알려져..",
	 * "UTF-8");
	 * 
	 * //html 메일 내용 String htmlStr = "<h1 style=\"color:blue\">다은씨 안녕하세요!</h1><br>"
	 * +"<a href=\"http://www.naver.com\">네이버에요!</a>";
	 * 
	 * //내용 설정 message.setText(htmlStr, "UTF-8","html");
	 * message.addRecipient(RecipientType.TO, new
	 * InternetAddress("pyo0829@naver.com","강다은씨","UTF-8"));
	 * 
	 * JavaMailSender.send(message);
	 * 
	 * } catch (MessagingException e) { e.printStackTrace(); } catch
	 * (UnsupportedEncodingException e) { e.printStackTrace(); }
	 * 
	 * return "send OK"; }
	 */
	
	@RequestMapping("/mail/send2")
	public String sendJavaMailSender() {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			// 메일 제목 설정
			message.setSubject("[안내] 처음 보내는 JavaMailSender", "UTF-8");
			
			// html 메일 내용
			String htmlStr = "<h1>안녕하세요</h1>";
			// 내용 설정
			message.setText(htmlStr, "UTF-8", "html");
			// To 설정
			message.addRecipient(
					RecipientType.TO, 
					new InternetAddress("pyo0829@naver.com"));
			message.setFrom(new InternetAddress("pyo0829@naver.com"));
			javaMailSender.send(message);
			
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "send ok";
	}
	
	@ResponseBody
	@RequestMapping("/mail/send3")
	public String sendFileAttach() {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			//제목
			messageHelper.setSubject("강다은.JPG");
			
			//내용 html
			String htmlStr = "<h1>파일을 다운받으세요!</h1>";
			
			//내용 설정
			messageHelper.setText(htmlStr, true);
			
			//To 설정
			messageHelper.setTo(new InternetAddress("kkang2309@gmail.com","욱표","UTF-8"));
			
			//첨부할 파일 객체 생성
			DataSource dataSource = new FileDataSource("C:\\Users\\Public\\Pictures\\다은이.jpg"); //절대경로설정
			message.setFrom(new InternetAddress("pyo0829@naver.com"));
			//MimeMessageHelper 파일 객체를 추가
			messageHelper.addAttachment(MimeUtility.encodeText("다은이.jpg", "UTF-8", "B"), dataSource);
			
			javaMailSender.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
				
		return "send ok";
	}
}

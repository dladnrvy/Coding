package com.bitcamp.mvc;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private AES256Util aesutil;
	
	@ResponseBody
	@RequestMapping("/encodepassword")
	public String bcript() {
		
		String str = "password";
		
		String encodingStr = encoder.encode(str);
		
		//두개의 비밀번호 비교 -> 데이터베이스와 사용자가 입력한 값
		boolean result = encoder.matches(str, encodingStr);
		
		return str + ":" + encodingStr + "<br>"
				+ "str = encodingStr ==> " + result;
	}
	//자바 암호화
	@ResponseBody
	@RequestMapping("/encodepassword1")
	public String bcript1() {
		
		String str = "password";
		
		String encodingStr = Sha256.encrypt(str);		
		
		String pw = "pass";
		
		boolean result = encodingStr.equals(Sha256.encrypt(pw));
		
		return str + ":" + encodingStr + "<br>"
				+ "encodingStr = pw ==>" + result ;
	}
	
	@ResponseBody
	@RequestMapping("/encodepassword2")
	public String bcript2() throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		
		String str = "password";
		
		String encodingStr = aesutil.encrypt(str);
		String decodingStr = aesutil.decrypt(encodingStr);
		
		return str + ":" + encodingStr + ":" + decodingStr;
	}
}

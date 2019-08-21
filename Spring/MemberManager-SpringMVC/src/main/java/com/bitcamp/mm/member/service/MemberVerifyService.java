package com.bitcamp.mm.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.member.dao.MemberSessionDao;
import com.bitcamp.mm.member.domain.MemberInfo;

@Service("verifyService")
public class MemberVerifyService {

	@Autowired
	MailSenderService mailservice;
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MemberSessionDao dao;
	
	public String verify(String id, String code) {
		
		dao = template.getMapper(MemberSessionDao.class);
		
		int rCnt = dao.verify(id, code);
		
		return rCnt>0?"Success":"Fail";
	}
	
	public int reMailSend(String email) {
		
		dao = template.getMapper(MemberSessionDao.class);
		
		MemberInfo memberinfo = dao.selectMemberById(email);
		
		mailservice.resend(memberinfo.getuId(), memberinfo.getCode());
		
		
		return 1;
	}
	
	
}

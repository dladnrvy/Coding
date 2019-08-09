package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberTemplateDao;
import com.bitcamp.mm.member.domain.MemberInfo;

@Service
public class MemberLoginService implements MemberService {
	
	/*
	 * @Autowired private MemberDao dao;
	 */
	@Autowired
	private MemberTemplateDao dao;
	
	public boolean login(String id, String pw, HttpServletRequest request) {
		
		boolean loginChk = false;
		
		MemberInfo memberInfo = null;
		
		//Connection conn = null;
		
		//try {
		//	conn = ConnectionProvider.getConnection();
		//	memberInfo = dao.selectMemberById(conn, id);
		memberInfo = dao.selectMemberById(id);
			if(memberInfo != null && memberInfo.pwChk(pw)) {
				//세션에 저장
				request.getSession(true).setAttribute("loginInfo", memberInfo.toLoginInfo());
				loginChk = true;
			}
		//} catch (SQLException e) {
		//	e.printStackTrace();
		//}
		
		
		return loginChk;
	}
}
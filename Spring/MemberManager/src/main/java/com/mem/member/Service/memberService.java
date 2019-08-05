package com.mem.member.Service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mem.member.DAO.memberDAO;
import com.mem.member.jdbc.ConnectionProvider;
import com.mem.member.model.MemberSave;

	
@Service("memberservice")
public class memberService implements MemberSaveService{
	
	@Autowired
	private memberDAO member;
	
	
	public int MemberInsert(MemberSave mbs) {
		
		Connection conn = null;
		int ms = 0;
		System.out.println("서비스" + ms);
		try {
			conn = ConnectionProvider.getConnection();
			ms = member.insert(conn, mbs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return ms;
	}




}

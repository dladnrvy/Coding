package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberTemplateDao;

@Service
public class MemberDeleteService implements MemberService{

	/*
	 * @Autowired private MemberDao dao;
	 */
	@Autowired
	private MemberTemplateDao dao;
	
	
		public int memberDelete(int id) {
		
			int rCnt = 0;
			
			//Connection conn = null;
			
			//try {
				//conn = ConnectionProvider.getConnection();
				//rCnt = dao.memberDelete(conn,id);
				rCnt = dao.memberDelete(id);
				
			/*} catch (SQLException e) {
				e.printStackTrace();
			}*/
			
			return rCnt;
		}
}

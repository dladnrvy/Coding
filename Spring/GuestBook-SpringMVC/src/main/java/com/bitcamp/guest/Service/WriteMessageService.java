package com.bitcamp.guest.Service;

import java.sql.Connection;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitcamp.guest.DAO.MessageDao;
import com.bitcamp.guest.domain.Message;
import com.bitcamp.guest.jdbc.ConnectionProvider;

@Service("writeService")
//같은 타입의 여러빈이 존재한다면 Qualifier 로 이름 지정해주거나 ""로 이름지정
public class WriteMessageService implements GuestBookService {
	
	@Autowired
	private MessageDao dao;
	
	public int write(Message message) {
		
		int rCnt = 0 ;
		
		// 1. Connection 생성
		// 2. dao 생성
		// 3. insert 메서드 실행
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			rCnt = dao.insert(conn, message);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return rCnt;	
		
	}

}

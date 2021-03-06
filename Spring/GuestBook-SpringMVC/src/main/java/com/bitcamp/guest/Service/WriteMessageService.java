package com.bitcamp.guest.Service;

import java.sql.Connection;
import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bitcamp.guest.DAO.MessageDao;
import com.bitcamp.guest.DAO.MessageSessionDao;
import com.bitcamp.guest.DAO.MessageSessionTemplateDao;
import com.bitcamp.guest.DAO.MessagejdbcTemplateDao;
import com.bitcamp.guest.domain.Message;
import com.bitcamp.guest.jdbc.ConnectionProvider;

@Service("writeService")
//같은 타입의 여러빈이 존재한다면 Qualifier 로 이름 지정해주거나 ""로 이름지정
public class WriteMessageService implements GuestBookService {
	
	//@Autowired
	//private MessageDao dao;
	
	/*
	 * @Autowired private MessagejdbcTemplateDao templateDao;
	 */
	/*
	 * @Autowired private MessageSessionTemplateDao templateDao;
	 */
	@Autowired
	private SqlSessionTemplate template;
	
	private MessageSessionDao dao;
	
	public int write(Message message) {
		
		dao = template.getMapper(MessageSessionDao.class);
		
		int rCnt = 0 ;
		rCnt = dao.insert(message);
		
		// 1. Connection 생성
		// 2. dao 생성
		// 3. insert 메서드 실행
		
		//Connection conn = null;
		
		//try {
			//conn = ConnectionProvider.getConnection();
			
			//rCnt = dao.insert(conn, message);
			
			
		//} catch (SQLException e) {
		//	e.printStackTrace();
		//}
				
		return rCnt;	
		
	}

}

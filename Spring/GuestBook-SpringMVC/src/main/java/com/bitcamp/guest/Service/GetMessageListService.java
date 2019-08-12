package com.bitcamp.guest.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.guest.DAO.MessageDao;
import com.bitcamp.guest.DAO.MessageSessionDao;
import com.bitcamp.guest.DAO.MessageSessionTemplateDao;
import com.bitcamp.guest.DAO.MessagejdbcTemplateDao;
import com.bitcamp.guest.domain.Message;
import com.bitcamp.guest.domain.MessageListView;
import com.bitcamp.guest.jdbc.ConnectionProvider;

@Service("listService")
public class GetMessageListService implements GuestBookService{
	
	//@Autowired
	//private MessageDao dao;
	/*
	 * @Autowired private MessagejdbcTemplateDao dao;
	 */
	/*
	 * @Autowired private MessageSessionTemplateDao dao;
	 */
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MessageSessionDao dao;
	
	// 1. 한페이지에 보여줄 게시글의 개수
	private static final int MESSAGE_COUNT_PER_PAGE = 3;
	
	public MessageListView getMessageListView(int pageNumber) {
		
		//dao 생성
		dao = template.getMapper(MessageSessionDao.class);
		
		
		// 2. 현재 페이지 번호
		int currentPageNumber = pageNumber;
		
		//Connection conn;
		
		MessageListView view = null;
		
		//try {
			// Connection 
		//conn = ConnectionProvider.getConnection();
			
			
			// 전체 게시물의 개수
		//	int messageTotalCount = dao.selectCount(conn);
		int messageTotalCount = dao.selectCount();
		
			// 게시물 내용 리스트, DB 검색에 사용할 start_row, end_row
			List<Message> messageList = null;
			int firstRow = 0;
			
			
			if(messageTotalCount > 0) {
				
				firstRow = (pageNumber-1)*MESSAGE_COUNT_PER_PAGE;
				/* endRow = fㅇㅇirstRow + MESSAGE_COUNT_PER_PAGE; */
				
				
				//messageList = dao.selectList(conn, firstRow, MESSAGE_COUNT_PER_PAGE);
				  
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("firstRow", firstRow);
				params.put("MESSAGE_COUNT_PER_PAGE", MESSAGE_COUNT_PER_PAGE);
				
				
				messageList = dao.selectList(params);
				
			} else {
				currentPageNumber = 0;
				messageList = Collections.emptyList();						
			}
			
			view  = new MessageListView(
					messageTotalCount, 
					currentPageNumber, 
					messageList, 
					MESSAGE_COUNT_PER_PAGE, 
					firstRow);
			
		//} catch (SQLException e) {s
		//	e.printStackTrace();
		//}
		
		return view;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
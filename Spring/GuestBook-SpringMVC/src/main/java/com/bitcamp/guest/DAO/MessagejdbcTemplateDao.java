package com.bitcamp.guest.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.guest.domain.Message;
import com.bitcamp.guest.jdbc.jdbcUtil;

@Repository("jdbcTemplateDao")
//빈 객체 등록해서 의존해서 사용
//이름 지정 해주지 않으면 messageDao 로 지정이 된다.
public class MessagejdbcTemplateDao {
	
	@Autowired
	JdbcTemplate template;
	
	public int insert(Message message) {
		
		String sql = "INSERT INTO GUESTBOOK_MESSAGE "
				+ " (GUEST_NAME, PASSWORD, MESSAGE) "
				+ " values (?,?,?)";
		
		return template.update(sql, message.getGuestName(), message.getPassword(), message.getMessage());
	}
	
	
	public int insert(Connection conn, Message message) {
		int rCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO GUESTBOOK_MESSAGE "
				+ " (GUEST_NAME, PASSWORD, MESSAGE) "
				+ " values (?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rCnt;
	}

	public Message select(int messageId) {
	
		String sql = "select * from guestbook_message where message_id=?";
		
		return template.queryForObject(sql, new MessageRowMapper(), messageId);
	}
	
	public Message select(Connection conn, int messageId) {
		
		Message message = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//조건에 맞는 질의에 따른 결과가 나오면 객체생성해주고 set해줌
		String sql = "select * from guestbook_message where message_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, messageId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				message = new Message();
				message.setId(rs.getInt(1));
				message.setGuestName(rs.getString(2));
				message.setPassword(rs.getString(3));
				message.setMessage(rs.getString(4));
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return message;
	}

	public int selectCount() {
		return template.queryForObject("select count(*) from guestbook_message", Integer.class);
	}
	
	
	public int selectCount(Connection conn) {
		
		Statement stmt = null;
		ResultSet rs = null;
		
		int totalCnt = 0;
		
		String sql = "select count(*) from guestbook_message";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				totalCnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalCnt;
	}

	public List<Message> selectList(int firstrow, int MESSAGE_COUNT_PER_PAGE) {
		String sql = "select * from GUESTBOOK_MESSAGE order by message_id desc limit ? , ?";
		
		//쿼리 리턴값이 list
		return template.query(sql, new MessageRowMapper(),firstrow, MESSAGE_COUNT_PER_PAGE);
	}
	
	
	
	public List<Message> selectList(Connection conn, int firstrow, int MESSAGE_COUNT_PER_PAGE) {
		
		List<Message> list = new ArrayList<Message>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from GUESTBOOK_MESSAGE order by message_id desc limit ? , ?";
			
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstrow);
			pstmt.setInt(2, MESSAGE_COUNT_PER_PAGE);
			// pstmt.setInt(2, firstrow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Message msg = new Message();
				msg.setId(rs.getInt(1));
				msg.setGuestName(rs.getString(2));
				msg.setPassword(rs.getString(3));
				msg.setMessage(rs.getString(4));
				
				list.add(msg);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	public int deleteMessage(int messageId){
		
		String sql = "delete from guestbook_message where message_id=?";
		return template.update(sql, messageId);
	}
	
	public int deleteMessage(Connection conn, int messageId) throws SQLException {
		//preparedStatement 객체 생성
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "delete from guestbook_message where message_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, messageId);
			
			resultCnt = pstmt.executeUpdate();
		
		}finally {
			jdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	};
	
	
}

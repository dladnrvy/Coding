package com.bitcamp.mm.member.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.jdbc.jdbcUtil;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.RequestMemberRegist;
import com.bitcamp.mm.member.domain.SearchParam;


@Repository("templateDao")
public class MemberTemplateDao {
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	public MemberInfo selectMemberById(String userId) {
		
		String sql = "select * from member where uid=?";
		
		List<MemberInfo> list = jdbctemplate.query(sql, new Object[] {userId}, new MemberRowMapper());
		
		return list.isEmpty()?null:list.get(0);
	}
	
	public MemberInfo selectMemberById2(String userId) {
		
		String sql = "select * from member where uid=?";
		
		MemberInfo memberInfo = null;
		try {
		memberInfo = jdbctemplate.queryForObject(sql, new Object[] {userId}, new MemberRowMapper());
		}catch(DataAccessException e) {
			e.printStackTrace();
		}
		return memberInfo;
	}


	public int insertMember(MemberInfo memberInfo) {
		
		String sql = "insert into member (uid, uname, upw, uphoto) values (?,?,?,?) ";
		
		return jdbctemplate.update(sql,memberInfo.getuId(),memberInfo.getuName(),memberInfo.getuPW(),memberInfo.getuPhoto());
	}
	

	public List<MemberInfo> selectList(int index, int count) {
		
		String sql = "SELECT * FROM member limit ?,?";
		
		return jdbctemplate.query(sql, new MemberRowMapper(),index, count);
	}

	public int selectTotalCount(SearchParam searchParam) {
		
		String sql = "select count(*) from member";
		
		if(searchParam != null) {
			sql = "select count(*) from member where ";
			if(searchParam.getStype().equals("both")) {
				sql += " uid like '%"+searchParam.getKeyword()+"%' or uname  like '%"+searchParam.getKeyword()+"%' ";
			}
			if(searchParam.getStype().equals("id")) {
				sql += " uid  like '%"+searchParam.getKeyword()+ "%'";
			}
			if(searchParam.getStype().equals("name")) {
				sql += " uname  like '%"+searchParam.getKeyword()+"%' ";
			}
		}
		
		return jdbctemplate.queryForObject(sql, Integer.class);
	}
	
	public List<MemberInfo> selectListById(int index, int count, SearchParam searchParam) {
		
		String sql = "SELECT * FROM member where uid like ?  limit ?, ?";
		
		return jdbctemplate.query(sql, new MemberRowMapper(), "%"+searchParam.getKeyword()+"%",index,count);
	}


	public List<MemberInfo> selectListByName(int index, int count, SearchParam searchParam) {
	
		String sql = "SELECT * FROM member where uname like ?  limit ?, ?";
		
		return jdbctemplate.query(sql, new MemberRowMapper(),"%"+searchParam.getKeyword()+"%",index,count);
	}
	

	public List<MemberInfo> selectListByBoth(int index, int count, SearchParam searchParam) {
		
		String sql = "SELECT * FROM member where uid like ? or  uname like ?  limit ?, ?";
		return jdbctemplate.query(sql, new MemberRowMapper(),"%"+searchParam.getKeyword()+"%","%"+searchParam.getKeyword()+"%",index,count);
	}
	
	public int update(MemberInfo memberInfo) {
		
		String sql = "Update member set UPW = ? ,UNAME = ? ,UPHOTO = ? where idx = ? ";
		
		return jdbctemplate.update(sql,memberInfo.getuPW(),memberInfo.getuName(),memberInfo.getuPhoto(),memberInfo.getIdx());
	}

	public MemberInfo selectMemberByIdx(int id) {
		
		String sql = "select * from member where idx = ?";
		
		MemberInfo memberInfo = null;
		
		try {
		memberInfo =  jdbctemplate.queryForObject(sql, new MemberRowMapper() ,id);
		}catch(DataAccessException e) {
			e.printStackTrace();
		}
		return memberInfo;
	}

	public int memberDelete(int id) {
		
		String sql = "delete from member where idx = ?";
		
		return jdbctemplate.update(sql, Integer.class);
	}
	
	public int memberDelete(Connection conn, int id) {
		
		int rCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "delete from member where idx = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return rCnt;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

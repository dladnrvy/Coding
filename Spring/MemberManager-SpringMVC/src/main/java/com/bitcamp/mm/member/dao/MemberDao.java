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

import org.springframework.stereotype.Repository;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.jdbc.jdbcUtil;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.RequestMemberRegist;
import com.bitcamp.mm.member.domain.SearchParam;


@Repository("dao")
public class MemberDao {
	

	public MemberInfo selectMemberById(Connection conn, String userId) {
		
		MemberInfo memberInfo = null;
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		System.out.println("dao : memberId -> " + userId);
		
		String sql = "select * from member where uid=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				System.out.println("check ::::::::::::::::::::::::");
				memberInfo = new MemberInfo(
					rs.getInt("idx"), 
					rs.getString("uid"), 
					rs.getString("upw"), 
					rs.getString("uname"), 
					rs.getString("uphoto"), 
					new Date(rs.getTimestamp("regdate").getTime()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
		
		
		return memberInfo;
	}

	public int insertMember(Connection conn, MemberInfo memberInfo) {
		
		PreparedStatement pstmt = null;
		
		int rCnt = 0;
		
		String sql = "insert into member (uid, uname, upw, uphoto) values (?,?,?,?) ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getuId());
			pstmt.setString(2, memberInfo.getuName());
			pstmt.setString(3, memberInfo.getuPW());
			pstmt.setString(4, memberInfo.getuPhoto());
			rCnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rCnt;
		
	}
	
	public List<RequestMemberRegist> memberlist(Connection conn, MemberInfo memberInfo){
		
		List<RequestMemberRegist> list = new ArrayList<RequestMemberRegist>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rs.getInt(memberInfo.getIdx());
				rs.getString(memberInfo.getuId());
				rs.getString(memberInfo.getuName());
				rs.getString(memberInfo.getuPhoto());
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}		
		
		return list;
	}

	public List<MemberInfo> selectList(Connection conn, int index, int count) {
		
		List<MemberInfo> memberList = new ArrayList<MemberInfo>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member limit ?,?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memberList.add(new MemberInfo(rs.getInt("IDX"), rs.getString("UID"), rs.getString("UPW"), rs.getString("UNAME"), rs.getString("UPHOTO"), new Date(rs.getDate("regdate").getTime())));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memberList;
	}

	
	public int selectTotalCount(
			Connection conn, 
			SearchParam searchParam) {
		
		int totalCnt = 0;
		
		Statement stmt = null;
		ResultSet rs = null;
		
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

	public List<MemberInfo> selectListById(Connection conn, int index, int count, SearchParam searchParam) {

		List<MemberInfo> memberList = new ArrayList<MemberInfo>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member where uid like ?  limit ?, ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchParam.getKeyword()+"%");
			pstmt.setInt(2, index);
			pstmt.setInt(3, count);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memberList.add(new MemberInfo(
						rs.getInt("idx"), 
						rs.getString("uid"), 
						rs.getString("upw"), 
						rs.getString("uname"), 
						rs.getString("uphoto"), 
						new Date(rs.getDate("regdate").getTime())));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memberList;
	}

	public List<MemberInfo> selectListByName(Connection conn, int index, int count, SearchParam searchParam) {

		List<MemberInfo> memberList = new ArrayList<MemberInfo>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member where uname like ?  limit ?, ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchParam.getKeyword()+"%");
			pstmt.setInt(2, index);
			pstmt.setInt(3, count);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memberList.add(new MemberInfo(
						rs.getInt("idx"), 
						rs.getString("uid"), 
						rs.getString("upw"), 
						rs.getString("uname"), 
						rs.getString("uphoto"), 
						new Date(rs.getDate("regdate").getTime())));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memberList;
	}

	public List<MemberInfo> selectListByBoth(Connection conn, int index, int count, SearchParam searchParam) {

		List<MemberInfo> memberList = new ArrayList<MemberInfo>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member where uid like ? or  uname like ?  limit ?, ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchParam.getKeyword()+"%");
			pstmt.setString(2, "%"+searchParam.getKeyword()+"%");
			pstmt.setInt(3, index);
			pstmt.setInt(4, count);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memberList.add(new MemberInfo(
						rs.getInt("idx"), 
						rs.getString("uid"), 
						rs.getString("upw"), 
						rs.getString("uname"), 
						rs.getString("uphoto"), 
						new Date(rs.getDate("regdate").getTime())));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memberList;
	}
	
	public int update(Connection conn, MemberInfo memberInfo) {
		
		PreparedStatement pstmt = null;
		int Cnt = 0;
		String sql = "Update member set UPW = ? ,UNAME = ? ,UPHOTO = ? where idx = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getuPW());
			pstmt.setString(2, memberInfo.getuName());
			pstmt.setString(3, memberInfo.getuPhoto());
			pstmt.setInt(4, memberInfo.getIdx());
			Cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Cnt;
	}

	public MemberInfo selectMemberByIdx(Connection conn, int id) {
		
		MemberInfo memberInfo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where idx = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
				memberInfo = new MemberInfo(
						rs.getInt("idx"),
						rs.getString("uid"), 
						rs.getString("upw"), 
						rs.getString("uname"), 
						rs.getString("uphoto"), 
						new Date(rs.getTimestamp("regdate").getTime()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
		}
		
		return memberInfo;
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

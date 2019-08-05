package com.mem.member.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.mem.member.model.MemberSave;

@Repository("member")
public class memberDAO {	
		

		public int insert(Connection conn, MemberSave ms) {

			int result = 0;
			PreparedStatement pstmt = null;

			String sql = "INSERT INTO project.MemberSave(UID,UPW,UNAME,UPHOTO) VALUES (?,?,?,?)";

			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ms.getuId());
				pstmt.setString(2, ms.getuPW());
				pstmt.setString(3, ms.getuName());
				pstmt.setString(4, ms.getuPhoto());
				pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		};

		public MemberSave select(Connection conn, String uId, String uPw) {

			MemberSave ms = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = "select * from project.MemberSave where UID = ? ";

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, uId);
				pstmt.setString(2, uPw);
				pstmt.executeQuery();

				if (rs.next()) {
					ms = new MemberSave();
					ms.setuId(rs.getString(1));
					ms.setuPW(rs.getString(2));
					ms.setuName(rs.getString(3));
					ms.setuPhoto(rs.getString(4));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return ms;
		};

		
		  public int update(Connection conn, String uId, String uPw, String uName) {
		  
			  MemberSave ms = null;
			  
			  int num = 0;
			  PreparedStatement pstmt = null;
			  
			  String sql = "update project.MemberSave set UID = ? , UPW = ?, UNAME = ? ";
			  
			  try {
				pstmt = conn.prepareStatement(sql);
				ms = new MemberSave();
				pstmt.setString(1, uId);
				pstmt.setString(2, uPw);
				pstmt.setString(3, uName);
				num = pstmt.executeUpdate();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			  	  
			  return num;
		  };
		  
		  public int delete(Connection conn, String uId) {
			  
			  int del = 0;
			  PreparedStatement pstmt = null;
			  
			  String sql= "delete from project.MemberSave where UNAME= ?";
			  
			  try {
				pstmt = conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			  
			  
			  return del;
		  }
		 

	}



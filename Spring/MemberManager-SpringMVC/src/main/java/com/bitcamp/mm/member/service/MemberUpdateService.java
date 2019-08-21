package com.bitcamp.mm.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberSessionDao;
import com.bitcamp.mm.member.dao.MemberTemplateDao;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.RequestMemberEdit;

@Service("editService")
public class MemberUpdateService implements MemberService{

	/*
	 * @Autowired private MemberDao dao;
	 */
	/*
	 * @Autowired private MemberTemplateDao dao;
	 */
	@Autowired
	private SqlSessionTemplate template;
	
	private MemberSessionDao dao;
	
	
	
	//id로 idx값 불러오기
	public MemberInfo getEditFormData(int id) {
		//Connection conn = null;
		MemberInfo memberInfo = null;
		
		dao = template.getMapper(MemberSessionDao.class);
		
		//try {
			//conn = ConnectionProvider.getConnection();
			//memberInfo = dao.selectMemberByIdx(conn, id);
			memberInfo = dao.selectMemberByIdx(id);
			
		/*}catch(SQLException e) {
			e.printStackTrace();
		}*/
		return memberInfo;
	}
	
	public int edit(RequestMemberEdit edit, String oldFileName, HttpServletRequest request) {
		
		dao = template.getMapper(MemberSessionDao.class);
		
		int rCnt = 0;
		
		MemberInfo memberInfo = edit.toMemberInfo();
		
		String path = "/uploadfile/userphoto";
		String dir = request.getSession().getServletContext().getRealPath(path);
		
		//Connection conn = null;
		
		//신규 파일 체크
		if(edit.getuPhoto() != null && !edit.getuPhoto().isEmpty() && edit.getuPhoto().getSize()>0) {
			
			String newFileName = edit.getuId()+"_"+edit.getuPhoto().getOriginalFilename();
			
			
			try {
				//신규파일저장
				edit.getuPhoto().transferTo(new File(dir,newFileName));
				//데이터 베이스 저장을 위한 새로운 파일 이름
				memberInfo.setuPhoto(newFileName);
				//이전 파일 삭제
				new File(dir, oldFileName).delete();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else {
			//신규 파일이 없으면 이전 파일 이름을 그대로 업데이트
			memberInfo.setuPhoto(oldFileName);
		}
		
	//	try {
		//	conn= ConnectionProvider.getConnection();
			//rCnt = dao.update(conn, memberInfo);
			rCnt = dao.update(memberInfo);
		/*} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		
		return rCnt;
	}
	
}

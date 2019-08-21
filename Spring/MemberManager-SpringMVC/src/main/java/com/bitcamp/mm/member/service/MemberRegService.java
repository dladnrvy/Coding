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
import com.bitcamp.mm.member.domain.RequestMemberRegist;

@Service("registService")
public class MemberRegService implements MemberService {

	/*
	 * @Autowired private MemberDao dao;
	 */
	@Autowired
	/* private MemberTemplateDao dao; */
	private SqlSessionTemplate template;
	
	private MemberSessionDao dao;
	
	@Autowired
	MailSenderService mailService;
	
	public int memberInsert(HttpServletRequest request, RequestMemberRegist regist) {
		
		dao = template.getMapper(MemberSessionDao.class);
		//서버경로
		String path = "/uploadfile/userphoto"; //리소스 매핑 필요
		//절대경로 
		String dir = request.getSession().getServletContext().getRealPath(path);
		
		MemberInfo memberInfo = regist.toMemberInfo();
			
		
		int resultCnt = 0;
		String newFileName = "";
		//Connection conn = null;
		
		//try {
			
			try {
		//		conn = ConnectionProvider.getConnection();
		//	} catch (SQLException e) {
		//		e.printStackTrace();
		//	}
					
				if(regist.getuPhoto() !=null){
					
					//새로운 파일 이름 생성
					//String newFileName = memberInfo.getuId()+System.nanoTime();
					newFileName = memberInfo.getuId() +"_"+ regist.getuPhoto().getOriginalFilename();
					//파일을 서버의 지정 경로에 저장
					regist.getuPhoto().transferTo(new File(dir,newFileName));
					//데이터베이스 저장을 하기위한 파일 이름 set
					memberInfo.setuPhoto(newFileName);
					}		
			//resultCnt = dao.insertMember(conn,memberInfo);
			resultCnt = dao.insertMember(memberInfo);
			
			//메일 발송
			mailService.send(memberInfo.getuId(),memberInfo.getCode());
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("오류!");
			if(regist.getuPhoto() !=null){
				
				new File(dir,newFileName).delete();
			}
			
		}
		
		return resultCnt;
	}
	
	
	  public char idCheck(String id) {
		  dao = template.getMapper(MemberSessionDao.class);
		  
	  char chk = dao.selectMemberById(id) == null ? 'Y':'N';
	  
	  return chk; 
	  }
	 
	
	public String idCheck1(String id) {
		dao = template.getMapper(MemberSessionDao.class);
		
		String chk = dao.selectMemberById2(id) == null ? "Y":"N";
		
		return chk;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

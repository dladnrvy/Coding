package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberSessionDao;
import com.bitcamp.mm.member.dao.MemberTemplateDao;
import com.bitcamp.mm.member.domain.MemberInfo;

@Service
public class MemberLoginService implements MemberService {
	/*
	 * 반환 값에 따른 로그인 인증처리 0 : 로그인 실패 1 : 인증 필요 2 : 인증완료
	 */

	// @Autowired
	// private MemberJdbcTemplateDao dao;

	// 자동 메퍼를 이용해서 생성할 dao
	private MemberSessionDao dao;

	// 자동 메퍼를 위한 sqlSessionTemplate 객체 주입
	// @Inject : 타입에 맞는 주입 ( java 에서 지원 : 특정 프레임워크에 의존하지 않음 )
	@Inject
	private SqlSessionTemplate template;

	public int login(String id, String pw, HttpServletRequest request) {

		// SqlSessionTemplate getMapper 를 이용해 dao 생성
		dao = template.getMapper(MemberSessionDao.class);

		int loginChk = 0;

		MemberInfo memberInfo = null;

		memberInfo = dao.selectMemberById(id);

		if (memberInfo != null && memberInfo.pwChk(pw)) {

			if (memberInfo.getVerify() == 'Y') {
				// 세션에 저장
				// loginChk 상태값을 변경
				request.getSession(true).setAttribute("loginInfo", memberInfo.toLoginInfo());
				loginChk = 2;
			} else {
				// 미인증 로그인
				request.getSession(true).setAttribute("reEmail", memberInfo.getuId());
				loginChk = 1;
			}
		}
			return loginChk;

		}
	}


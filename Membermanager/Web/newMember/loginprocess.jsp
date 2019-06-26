<%@page import="member.MemberSave"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	request.setCharacterEncoding("utf-8");
	
	String userId = request.getParameter("uId");
	String userPW = request.getParameter("uPW");
	
	/* boolean loginChk = false; */
	
	/* 1. 사용자가 입력한 id로 회원 정보 검색
	   2. 존재한다 : 해당 객체를 받는다.
	     해당 객체의 pw와 사용자가 입력한 pw 비교
	     같다면 - 로그인 처리 : 세션영역에 회원 정보를 저장
	     틀리다 - 오류 메시지 전달 -> 로그인 페이지로 이동
	   
	   3. 존재하지 않는다 : 오류 메시지전달 -> 로그인 페이지로 이동
	*/
	
	MemberSave memberInfo = (MemberSave)application.getAttribute(userId);
	
	if(memberInfo != null && memberInfo.getuPW().equals(userPW)){
		//회원 정보가 존재 && 비밀번호가 일치
		//세션에 회원 로그인 정보를 저장
		session.setAttribute("loginInfo", memberInfo.toLoginInfo());
		
		
		//로그인 처리 후 메인페이지로 이동
		response.sendRedirect(request.getContextPath());
	}else{
		//id검색 결과가 null 또는 pw 비교해서 같지 않은 경우
		
		%>
		<script>
			alert('아이디 혹은 비밀번호가 틀립니다. \n다시로그인 해주세요');
			history.go(-1);
		</script>
		
		<% 
	}
	   

%>
<%-- <!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href ="/mm/css/defult.css" rel="stylesheet" type="text/css">
	<style>
	
	</style>
</head>
<body>

<!-- 헤더시작 -->
	<%@ include file ="../frame/header.jsp" %>
<!-- 헤더끝 -->	

	
<!-- 네비게이션 시작 -->
	<%@ include file ="../frame/nav.jsp" %>
<!-- 네비게이션 끝 -->

<!-- 컨텐츠시작 -->
	<div id="contents">
	<h3>로그인 요청 처리 페이지</h3>
	<hr>
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="uId" value="<%= userId%>"> </td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="uPW" value="<%= userPW%>"> </td>
		</tr>
		<tr>
			<td></td>
			<td> </td>
		</tr>
	</table>
	</div>
<!-- 컨텐츠끝 -->

<!-- 푸터 시작 -->
	<%@ include file="../frame/footer.jsp" %>
<!-- 푸터 끝 -->

	
<jsp:useBean id="loginInfo" class="member.MemberSave" scope="session"/>
<jsp:setProperty property="uId" name="loginInfo" value="<%= userId %>"/>
	 loginInfo.setuPW(userPW);

</body>
</html> --%>
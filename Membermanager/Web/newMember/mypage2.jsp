<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="member.LoginInfo"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="LoginInfo" class="member.LoginInfo" scope="session"/>
<jsp:setProperty property="*" name="LoginInfo"/>
<%
	LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
	
	/* String uid = request.getParameter("uId");
	String upw = request.getParameter("uPw");
	String uname = request.getParameter("uName");
	String uPhoto = request.getParameter("uPhoto"); */
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	try{
		
		String jdbDriver = "jdbc:apache:commons:dbcp:pool";
		conn = DriverManager.getConnection(jdbDriver);
		
		
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link href="/mm/css/default.css" rel="stylesheet" type="text/css">
<style>
</style>
</head>
<body>

<!-- 해더 시작 -->
<%@ include file="../frame/header.jsp" %>
<!-- 해더 끝 -->

<!-- 네비게이션 시작 -->
<%@ include file="../frame/nav.jsp" %>
<!-- 네비게이션 끝 -->

<!-- 컨텐츠 시작 -->
<div id="contents">
	
	<h3>회원 정보 페이지</h3>
	<%-- <c:if test="${loginInfo ne null}">
	${sessionScope.loginInfo}
	<hr>
	
		<img src="../images/${loginInfo.uPhoto}">
		<h4>이름 : ${loginInfo.uName} </h4>
		<h4>아이디 : ${loginInfo.uId} </h4>
		<h4>가입일 : <fmt:formatDate value="${loginInfo.regDate}" pattern="yyyy.MM.dd"/></h4>
	</c:if> --%>
	<%--= loginInfo --%>
	
	<%-- <c:if test="${loginInfo eq null}">
	<script>
		alert('로그인 후 이용가능한 페이지 입니다.');
		location.href = 'login.jsp';
	</script>
	</c:if> --%>
<%
	String sql = "select * from memberinfo order by idx";

	stmt = conn.createStatement();
	
	rs = stmt.executeQuery(sql);
	
	if(rs.next()){
		do{%>
		<tr>
		</tr>
	}




%>
	
</div>
<!-- 컨텐츠 끝 -->


<!-- 푸터 시작 -->
<%@ include file="../frame/footer.jsp" %>
<!-- 푸터 끝 -->









</body>
</html>
	<%
	}catch(SQLException se){
		se.printStackTrace();
	}finally{
		if(rs != null){
			try{
				rs.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
				if(stmt != null){
					try{
						stmt.close();
					}catch(SQLException se){
					se.printStackTrace();
				}
		}
		
	}
	
	
	%>

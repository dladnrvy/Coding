<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//현재 세션을 삭제합니다.
	session.invalidate();

%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<h1>정상적으로 로그아웃 되었습니다.</h1>
	<a href="loginCheck.jsp">로그인확인</a>


</body>
</html>
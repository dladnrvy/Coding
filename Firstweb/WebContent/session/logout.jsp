<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<%
		//request.getSession(false).invalidate();
		session.invalidate();
	
	%>
	
	<h1>로그아웃되었습니다.</h1>
	
	<a href ="ViewSession.jsp">view1</a><br>
	<a href = "../response/ViewSession.jsp">responseSession</a><br>
	








</body>
</html>
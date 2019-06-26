<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키의 이름이 name 인 쿠키 데이터를 변경 
	//기존 이름의 쿠키 객체를 생성 : 새로운 데이터로 등록
	Cookie c = new Cookie("name","우아아");
	response.addCookie(c);
	
	Cookie c1 = new Cookie("code","흐어어");
	response.addCookie(c1);
	
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>쿠키변경</title>
<style>
</style>
</head>
<body>

	<h1>쿠키 정보가 변경되었습니다.</h1>
	<a href="viewCookie.jsp">view Cookie</a>
</body>
</html>
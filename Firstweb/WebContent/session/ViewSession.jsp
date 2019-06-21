<%@page import="web.Member"%>
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
		session = request.getSession(false);
	%>
	
	name = <%= session.getAttribute("name") %><br>
	id = <%= session.getAttribute("id") %><br>
	isLogin = <%= session.getAttribute("isLogin") %><br>
	age = <%= session.getAttribute("age") %><br>
	<%= session.getAttribute("user") %>
</body>
</html>
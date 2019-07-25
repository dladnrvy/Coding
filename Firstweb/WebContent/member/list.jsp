<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>회원 리스트</title>
<style>
	img{
	width : 100px;
	}
</style>
</head>
<body>


<% Calendar c = Calendar.getInstance(); %>
	<h1>회원 리스트
	<%= c.get(Calendar.YEAR)%>년
	<%= c.get(Calendar.MONTH)+1 %>월
	<%= c.get(Calendar.DATE)%>일
	</h1>
	<!-- 절대경로는 서버기준 -->
	<a href ="memberReg.jsp">회원가입</a><br>
	<img alt="이미지" src="../images/nori.png">
</body>
</html>
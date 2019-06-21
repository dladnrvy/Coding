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
<h1>
	<%-- <h1>page_b.jsp에서 만들어진 응답 결과</h1>
	<br> no 파라미터의 값 :
	<%=request.getParameter("num")%>
	<br> uname 파라미터의 값 :
	<%=request.getParameter("username")%> --%>
	
	<%
		Member member = (Member)request.getAttribute("result");
	%>
	
	<%= member %> <br>
		아이디 : <%= member.getId() %> <br>
		이름 : <%= member.getName() %> <br>
		번호 : <%= member.getpNum() %> <br>

	</h1>
</body>
</html>
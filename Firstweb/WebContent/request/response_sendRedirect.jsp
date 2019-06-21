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
응답처리가 진행됩니다.
<%
	request.setAttribute("code", "code-1");
%>
</body>
</html>
<%
	String name = request.getParameter("name");
	response.sendRedirect("form03_result.jsp?type=B-Type&name="+name);


%>
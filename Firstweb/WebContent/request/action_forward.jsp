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
응답페이지

<%
	request.setAttribute("code", "code-0");
	request.setAttribute("name", request.getParameter("name"));
	request.setAttribute("type", "A-type");
%>
</body>
</html>
<jsp:forward page="form03_result.jsp"/>

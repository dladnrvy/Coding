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
	String path = "/images/mini.png";
%>

<h1>자원의 실제 경로 : <% application.getRealPath(path) %></h1>

</body>
</html>
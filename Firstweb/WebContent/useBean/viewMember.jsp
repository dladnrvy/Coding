<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userData" class=web.UserInfo scope="request"/>
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
<h1>포워드된 페이지이고, userbean을 통한 데이터입니다.</h1>
	<h1>
	<%= userData %>
	</h1>
</body>
</html>
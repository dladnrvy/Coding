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
			<h1>page_a.jsp에서 만들어진 응답 결과
			<br>
			no 파라미터의 값 : <%= request.getParameter("num") %>
			<br>
			uname 파라미터의 값 : <%= request.getParameter("username") %>
			
			</h1>
</body>
</html>
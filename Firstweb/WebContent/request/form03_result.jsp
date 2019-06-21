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
		type = <%= request.getParameter("type") %><br>
		name = <%= request.getParameter("name") %><br>
		code = <%= request.getAttribute("code") %><br>
		name1 = <%= request.getAttribute("name") %><br>
		type1 = <%= request.getAttribute("type") %><br>
	</h1>








</body>
</html>
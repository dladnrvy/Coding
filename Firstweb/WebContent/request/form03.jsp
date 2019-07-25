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

		<h1>action_forward / response sendRedirect</h1>
		<form action="action_forward.jsp">
			forward action<input type="text" name="name">
			<input type="submit">
		</form>

		<form action="response_sendRedirect.jsp">
			response sendRedirect<input type="text" name="name">
			<input type="submit">
		</form>
</body>
</html>
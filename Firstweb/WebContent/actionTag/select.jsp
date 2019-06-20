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


		<form action ="page.jsp" mathod="get">
		
		no<input type="text" name="num" value="0">
		name<input type="text" name="username">
		
		Page Type
		<select name="type">
			<option>선택하세요</option>
			<option value="a">A</option>
			<option value="b">B</option>
			<option value="c">C</option>
		</select>
		<input type = "submit" value="보내기">
		
		</form>

</body>
</html>
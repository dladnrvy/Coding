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

	<h1>회원가입</h1>
	<form action = "viewparameter.jsp" method="get">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>좋아하는동물</td>
				<td>
				<input type="checkbox" name="pet" value="dog">강아지
				<br>
				<input type="checkbox" name="pet" value="cat">고양이
				<br>
				<input type="checkbox" name="pet" value="pig">돼지
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="전송"></td>
			</tr>	
		
		</table>
	
	</form>
</body>
</html>
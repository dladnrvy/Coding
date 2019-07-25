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
	<h1>사원 이름 추가</h1>
	<hr>
	<form action="editEmp2.jsp" method="post">
		사원번호<input type="number" name ="empno" required><br>
		사원이름<input type="text" name ="ename" required><br>
		사원업무<input type="text" name ="job" required><br>
		<input type="submit" value="수정"><br>
	</form>

</body>
</html>
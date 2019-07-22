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
	<h1>과제 제출</h1>
	<hr>
	<form action="FileUpload.jsp" method="post" enctype="multipart/form-data">
		이름 : <input type="text" name="uName"><br>
		학번 : <input type="text" name="sNumber"><br>
		과제 : <input type="file" name="report"><br>
		<input type="submit" value="업로드"> 
	</form>

</body>
</html>
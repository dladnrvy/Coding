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

	<h1>메시지 삭제 비밀번호 확인</h1>
	<form method ="post">
		
		${param.messageId}번 메시지를 삭제하시려면 비밀번호를 입력하세요<br>
		<input type="hidden" name="messageId" value="${messageId}">
		비밀번호<input type="password" name="password" required><br>
		<input type="submit" value="메시지삭제">
	
	</form>

</body>
</html>
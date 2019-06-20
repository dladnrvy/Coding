<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" erroerPage="list.jsp"%>
<% 
	String str = new String("회원가입 폼");

	int n = 1;

%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	img{
		width : 100px;
	}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<a href="/web/member/list.jsp">회원리스트</a><br>
	<img alt="이미지" src="/web/images/park.jpg">
	
</body>
<script>
	$(document).ready(function() {
		alert('회원 가입페이지 입니다.');
	});
</script>

</html>
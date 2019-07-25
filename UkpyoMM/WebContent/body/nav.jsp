<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>Insert title here</title>
</head>
<style>
	#ul li{
	display : inline;
	padding : 10px;
	}
	li a{
	display: inline-block;
	margin : 30px 0;
	}
	a{
	text-decoration: none;
	}
	
</style>
<body>
<div id="nav">
	<ul id="ul">
		<li><a href="main.jsp">홈</a></li>
		<li><a href="member/login.jsp">로그인</a></li>
		<li><a href="#">회원가입</a></li>
		<li><a href="#">마이페이지</a></li>
		<li><a href="#">회원목록</a></li>
		<li><a href="#">로그아웃</a></li>
	</ul>
</div>
</body>
</html>
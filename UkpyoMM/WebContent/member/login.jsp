<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link href="../body/css.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 헤더 -->
<%@ include file="../body/header.jsp" %>

<!-- 네비 -->
<%@ include file="../body/nav.jsp" %>
<hr>


<!-- 콘텐스 -->
<div id="contents">
	<h3>로그인페이지입니다.</h3>
	<br>
	<form action="logincheck.jsp" method="post">
	아이디<input type="text" name="uID"><br>
	비밀번호<input type="password" name="uPW"><br>
	<input type="submit" value="로그인"><br>
	</form>

</div>
<br>
<%@ include file="../body/footer.jsp" %>


</body>
</html>
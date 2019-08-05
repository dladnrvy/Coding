<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href ="/mm/css/defult.css" rel="stylesheet" type="text/css">
	<style>
	
	</style>
</head>
<body>
<!-- 헤더시작 -->
	<%@ include file ="../frame/header.jsp" %>
<!-- 헤더끝 -->	

	
<!-- 네비게이션 시작 -->
	<%@ include file ="../frame/nav.jsp" %>
<!-- 네비게이션 끝 -->

<!-- 컨텐츠시작 -->
	<div id="contents">
	<h3>회원가입페이지이오</h3>
	<hr>
	<form action = "memberReg" method ="post">
	<table>
		<tr>
			<td>아이디(이메일)</td>
			<td><input type="email" name="uId" required></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="uPW" required></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="uName" required></td>
		</tr>
		<tr>
			<td>사진</td>
			<td><input type="file" name="uPhoto"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="회원가입"></td>
		</tr>
	</table>
	</form>
	</div>
<!-- 컨텐츠끝 -->

<!-- 푸터 시작 -->
	<%@ include file="../frame/footer.jsp" %>
<!-- 푸터 끝 -->

</body>
</html>
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
	<h1>session을 이용한 데이터 저장</h1>
	<%
		session.setAttribute("name", "king");
		//name = class king = object 타입 특정객체를 저장
		session.setAttribute("id", "tiger");
		session.setAttribute("isLogin", true);
		session.setAttribute("age", 20);
	
	%>
	<h3>세션에 데이터를 저장했습니다.</h3>
	
	<a href ="ViewSession.jsp">view1</a><br>
	<a href = "../response/ViewSession.jsp">responseSession</a><br>
	<a href="logout.jsp">logout</a>

</body>
</html>
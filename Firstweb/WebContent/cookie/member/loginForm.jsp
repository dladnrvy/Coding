<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	
	CookieBox ck = new CookieBox(request);

	String id = "";
	String ckk = ck.getValue("chk");
	
	
	if(ckk != null){
		id = ckk;
	}
	


%>
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

	<h1>로그인</h1>
	<hr>
	<form action="login.jsp" method="post">
	아이디<input type="text" name="id" value="<%= id %>"><br>
	비밀번호<input type="text" name="pw"><br>
	아이디 저장해서 사용<input type="checkbox" name="chk"><br>
	<input type="submit" value="로그인">
	</form>
	
	<br>
	<a href="loginCheck.jsp">loginCheck</a>






</body>
</html>
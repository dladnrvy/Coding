<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userInfo" class="web.UserInfo"/>
<jsp:setProperty property="name" value="hot" name="userInfo"/>
<!-- 1. 해당 영역에 userInfo 이름의 web.UserInfo 타입 객체가 있는지 확인 
	 2. 있다면 현재 저장되어 있는 객체를 반환
	 3. 없다면 UserInfo ui = new web.UserInfo(); 새로운 객체를 생성
	 3-1. pageContext.setAttribute("userInfo", ui);
-->
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
<%
	userInfo.setId("cool");

%> 


	<%= userInfo.getId() %><br>
	<%= userInfo.getName() %>




</body>
</html>
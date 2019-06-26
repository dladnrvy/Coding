<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="8kb" %>
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
		for(int i=0; i<1000; i++){

%>

<h1>from 페이지에서 실행된 결과 페이지 입니다.</h1>
<%
		}
%>

<jsp:forward page="to.jsp"/>

</body>
</html>
<%@page import="util.CookieBox"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%	
	CookieBox cBox = new CookieBox(request);
	
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>쿠키 배열</title>
<style>
</style>
</head>
<body>
<h1>Cookie Data</h1>

	<h3>
	 name : <%= cBox.getValue("name") %><br>
	 nicname : <%= cBox.getValue("nicname") %><br>
	 password : <%= cBox.getValue("pw") %>
	</h3>
		
	<a href="aditCookie2.jsp">aditCookie</a>
	<a href="delCookie2.jsp">dalCookie</a>
		



</body>
</html>
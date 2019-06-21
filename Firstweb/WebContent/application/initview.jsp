<%@page import="java.util.Enumeration"%>
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
	<%= application.getInitParameter("logEnabled") %><br>
	<%= application.getInitParameter("debugLevel") %><br>
	<%
		Enumeration initParamNames = application.getInitParameterNames();
	
	while(initParamNames.hasMoreElements()){
		out.print(initParamNames.nextElement()+"<br>");
	}
		
	
	%>

</body>
</html>
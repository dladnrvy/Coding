<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%	
	//브라우저가 요청할때 모든 쿠키 정보를 함께 전송
	Cookie[] cookies = request.getCookies();
	
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

	<% 
		if(cookies != null && cookies.length >0){
			for(int i=0; i<cookies.length; i++){
				
				/* if(cookies[i].getName().equals("name")){ */
	%>
		<h3>
		<%=cookies[i].getName() %> :
		<%= cookies[i].getValue() %>
		</h3>
	<%
			/* } */
		}
	} 
	%>
	
	<a href="aditCookie.jsp">aditCookie</a>
	<a href="delCookie.jsp">dalCookie</a>
		
		



</body>
</html>
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
	<h1>
		<%
			HttpServletRequest req = (HttpServletRequest)pageContext.getRequest();
		
		
		%>
		<%= request == req %>
		
		<br>
		
		<%
			out.print(123+"<br>");
			pageContext.getOut().print("같은 객체를 사용합니다.");
			
		%>
	
	
	
	
	
	</h1>


</body>
</html>
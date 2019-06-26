<%@page import="member.MemberSave"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//반복시킬수있다
	Enumeration<String> e = application.getAttributeNames();

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

<%
	while(e.hasMoreElements()){
		
		String name = e.nextElement();
		
		Object obj = application.getAttribute(name);
		
		if(obj instanceof MemberSave){
			out.println(name+":"+obj);
		}
		
		/* out.println(e.nextElement()+"<br>"); */
	}

%>

</body>
</html>
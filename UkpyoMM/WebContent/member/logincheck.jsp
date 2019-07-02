<%@page import="mm.MemberSave"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uID = request.getParameter("uID");
	String uPW = request.getParameter("uPW");

	MemberSave ms = (MemberSave)application.getAttribute(uID);
	 
	 if(ms != null && ms.getuID().equals(uPW)){
	 	
		 session.setAttribute("Member", uID);
%>	
<script>
	alert('로그인되었습니다.');
</script>
<% 
		response.sendRedirect(request.getContextPath()); 
		 
	 }else{
%>
		 <script>
		alert('아이디 혹은 비밀번호가 틀립니다. \n 다시 확인해주세요.');
		history.go(-1);
		 
		 </script>
<%	 
		 
	 }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 

</body>
</html>
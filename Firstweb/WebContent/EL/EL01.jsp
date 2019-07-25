<%@page import="web.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setAttribute("member", new Member("tiger","ttt","010-0000-0000"));	

	request.setAttribute("name01", "requestData");
	session.setAttribute("name02", "sessionData");
	application.setAttribute("name03", "applicationData");
    
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
	<h3>
	<!-- 같은이름이면 생명주기가 작은거에서 큰쪽으로 생성 -->
		request 영역의 name01 : ${name01}<br>
		<%= request.getAttribute("name01") %><br>
		session 영역의 name02 : ${name02}<br>
		application 영역의 name 03 : ${name03}<br>
		code 파라미터 : ${param.code}<br>
		code 파라미터 : <%= request.getParameter("code") %><br>
		contextPath : ${pageContext.request.contextPath}<br>
		<a href="${pageContext.request.contextPath}/member/memberlist.jsp">경로1</a>
		<a href="<%= request.getContextPath() %>/member/memberlist.jsp">경로1</a><br>

										<!-- id는 변수가 아니다
										getId를 호출하는 것 -->
		member 객체 참조1 - id: ${requestScope.member.id}<br>
		member 객체 참조2 - name: ${requestScope.member.name}<br>
		member 객체 참조3 - pNum: ${requestScope.member.pNum}<br>
		member 객체 참조4 - num: ${requestScope.member.num}

	
	</h3>







</body>
</html>
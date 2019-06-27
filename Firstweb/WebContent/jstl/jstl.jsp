<%@page import="web.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<Member> list = new ArrayList<Member>();
	
	list.add(new Member("홍길동11","hong-11","010-1111-1111"));
	list.add(new Member("홍길동12","hong-12",null));
	list.add(new Member("홍길동13","hong-13","010-1111-1111"));
	list.add(new Member("홍길동14","hong-14","010-1111-1111"));
	list.add(new Member("홍길동15","hong-15",null));
	list.add(new Member("홍길동16","hong-16",null));
	list.add(new Member("홍길동17","hong-17","010-1111-1111"));
	list.add(new Member("홍길동18","hong-18","010-1111-1111"));
	
	application.setAttribute("members", list);
	
%>


<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	span.nopNum{
		color : green;
	}
</style>
</head>
<body>
	<c:set value="test" var="msg"/>
	msg : ${msg}<br>
	
	<c:if test="${msg eq 'test'}">
	msg의 문자열은 test와 같습니다.
	</c:if>
	
	<c:if test="${msg eq 'test'}" var="condition" />
	<br>
	결과값은 : ${condition}
	
	<hr>

	<h1>
	<c:out value="${param.code}" escapeXml="false">
		<span style="color:red">b</span>
	</c:out>
	</h1>
	<hr>
	<table>
		<tr>
			<td>index/count</td>
			<td>이름</td>
			<td>아이디</td>
			<td>전화번호</td>
		</tr>
		
		<c:forEach items="${members}" var="member" varStatus="status" begin="0" end="5"> 
		<tr>
			<td>${status.index}/${status.count}</td>
			<td>${member.name}</td>
			<td>${member.id}</td>
			<td>		
			<c:out value="${member.pNum}" escapeXml="false">
				<span class="nopNum">전화번호 없음</span>
			</c:out>
			</td>
		</tr>
		</c:forEach>
		
		<c:forTokens items="홍길동,010-8888-6666,서울" delims="," var="sel">
			${sel}<br>
		</c:forTokens>
		
		
	</table>
</body>
</html>
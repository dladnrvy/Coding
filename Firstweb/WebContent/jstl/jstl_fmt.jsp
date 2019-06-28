<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<fmt:timeZone value=""/>
		<c:set var="now" value="<%= new java.util.Date() %>"/>
		
		<fmt:formatDate value="${now}" type="date" dateStyle="full"/>
		/
		<fmt:formatDate value="${now}" type="date" dateStyle="short"/><br>
		
		<fmt:formatDate value="${now}" type="time" timeStyle="full"/>
		/
		<fmt:formatDate value="${now}" type="time" timeStyle="short"/><br>
		<br>
		<fmt:formatDate value="${now}" type="both"/><br>
		<fmt:formatDate value="${now}" type="both" timeStyle="full"/><br>
		<fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short"/><br>
		<fmt:formatDate value="${now}" pattern="yyyy.MM.dd hh:mm:ss"/><br>
		<fmt:formatDate value="${now}" pattern="yyyy년MM월dd일 hh시mm분ss초"/><br>
		
		<c:forEach var="id" items="<%= java.util.TimeZone.getAvailableIDs() %>">
		${id}<br>
		</c:forEach>
	</h3>

	<hr>
	<c:set var ="price" value="100000" />
	<c:set var="pi" value="3.141592"/>
	<fmt:formatNumber value="${price}" type="number" var="numberType" groupingUsed="true"/>
	현재 숫자 : ${numberType}<br>
	통화 : <fmt:formatNumber value="${price}" type="currency" currencySymbol="\\"/><br>
	% 표현 : <fmt:formatNumber value="${pi}" type="percent" groupingUsed="false"/>/
	<fmt:formatNumber value="${price}" type="percent" groupingUsed="false"/><br>
	
	패턴표현 : <fmt:formatNumber value="${price}" pattern="00,000,000.00"/>/
	<fmt:formatNumber value="${pi}" pattern="00,000,000.00"/>
</body>
</html>
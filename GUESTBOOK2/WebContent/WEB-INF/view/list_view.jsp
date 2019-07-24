<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<%-- <h1>${viewData.messageTotalCount}</h1><br>
	<h1>${viewData.currentPageNumber}</h1><br>
	<h1>${viewData.pageTotalCount}</h1><br>
	<h1>${viewData.messageCountPerPage}</h1><br>
	<h1>${viewData.firstRow}</h1><br>
	<h1>${viewData.endRow}</h1> --%>
	
	<c:if test="${messageTotalCount>0}">
	
	<c:forEach items="${viewData.messageList}" var="message">
		<div>
				메시지 번호 : ${message.id}<br>
				손님 이름 : ${message.guestName}<br>
				메시지 : ${message.message}<br>
				<a href="confirmDeletion.jsp?messageId=${message.id}">삭제하기</a>
		</div>
	</c:forEach>
	</c:if>
	
	
</body>
</html>
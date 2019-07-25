<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
	<c:if test="${chk}">
		${resultCnt}개 행이 삭제되었습니다.
	
	</c:if>

	<c:if test="${!chk}">
		${msg}
	</c:if>
	</h1>	
	<a href="<c:url value="/guestList"/>">리스트</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1{
			text-align : center;
	}
	div{
			padding : 10px;
			width: 45%;
			float : left;
	}
</style>
</head>
<body>
	<h1>include 지시어</h1>
	<hr>
	<!-- 메뉴 시작 -->
	<%@ include file="include/top.jsp" %>
	<!-- 메뉴 끝 -->
	
	<!-- 왼쪽 영역 시작 -->
	<%@ include file="include/left.jsp" %>
	<!-- 왼쪽 영역 끝 -->
	
	<!-- 오른쪽 영역 시작 -->
	<%@ include file="include/right.jsp" %>
	<!-- 오른쪽 영역 끝 -->
	
	<!-- footer시작 -->
	<jsp:include page="include/footer.jsp">
	<jsp:param value="010-0000-0008" name="tel"/>
	<jsp:param value="test@test.com" name="email"/>
	
	</jsp:include>
	<!-- footer 끝 -->







</body>
</html>
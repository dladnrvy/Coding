<%@page import="member.MemberSave"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	//반복시킬수있다
	Enumeration<String> e = application.getAttributeNames();
	application.setAttribute("mListName", e);
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href ="/mm/css/defult.css" rel="stylesheet" type="text/css">
	<style>
	.img{
		height: 25px;
		margin : 2px;
	}
	table{
		width: 80%;
		margin : 0 auto;
		border : 0;
		border-collapse: collapse;
	}
	
	table td{
	padding : 3px;
	border : 1px solid #AAA;
	}
	table tr:first-child>td{
	text-align : center;
	background-color: #EEE;
	font-weight: bold;
	}
	
	</style>
</head>
<body>
<!-- 헤더시작 -->
	<%@ include file ="../frame/header.jsp" %>
<!-- 헤더끝 -->	

	
<!-- 네비게이션 시작 -->
	<%@ include file ="../frame/nav.jsp" %>
<!-- 네비게이션 끝 -->

<!-- 컨텐츠시작 -->
	<div id="contents">
	<h3>회원 리스트</h3>
	<hr>
	<table>
		<tr>
			<td>순번</td>
			<td>아이디</td>
			<td>이름</td>
			<td>비밀번호</td>
			<td>가입일
			<td>이미지</td>
			<td>관리</td>
		</tr>
		
		<!-- 리스트 반복 시작 -->
		<c:forEach items="${mListName}" var="mId" varStatus="status">
		<c:if test="${fn:contains(mId,'@')}">
		
		<c:set var="mem" value="${applicationScope[mId]}"/>
		<tr>  
			<td>${status.count}</td>
			<td>${mem.uId}</td>
			<td>${mem.uName}</td>
			<td>${mem.uPW}</td>
			<td><fmt:formatDate value="${mem.regDate}" pattern="yyyy. MM. dd. H:mm"/></td>
			<td><img class="img" alt = "회원 사진" src="../images/${mem.uPhoto}">이미지</td>
			<td><a href="#">수정</a> | <a href="#">삭제</a></td>
		</tr>
		</c:if>
		</c:forEach>
		
		<!-- 리스트 반복 종료 -->
	</table>
	</div>
<!-- 컨텐츠끝 -->

<!-- 푸터 시작 -->
	<%@ include file="../frame/footer.jsp" %>
<!-- 푸터 끝 -->

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="memberData" class="member.MemberSave" scope="session"/>
<!-- scope="request" 라면, request.getAttribute("userdata")를 통해 데이터를 받아오고 있다. 
하지만 a page의 scope이 session으로 바뀐다면 현재 페이지에서는 request 영역에 있는 데이터가 없기 때문에 null로 표시될 것
- 이 페이지도 session으로 scope을 바꾼다면 다시 데이터를 받을 수 있다.  -->
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href ="/mm/css/defult.css" rel="stylesheet" type="text/css">
	<style>
	
	</style>
</head>
<body>
<%-- <%
	String userId = request.getParameter("uId");
	String userPW = request.getParameter("uPW");
	



%> --%>
<!-- 헤더시작 -->
	<%@ include file ="../frame/header.jsp" %>
<!-- 헤더끝 -->	

	
<!-- 네비게이션 시작 -->
	<%@ include file ="../frame/nav.jsp" %>
<!-- 네비게이션 끝 -->

<!-- 컨텐츠시작 -->
	<div id="contents">
	<h3>마이페이지입니다.</h3>
	<hr>
	<table>
		<tr>
			<td>아이디   </td>
			<td><%= memberData.getuId() %></td>
		</tr>
		<tr>
			<td>비밀번호   </td>
			<td><%= memberData.getuPW() %></td>	
		</tr>
		<tr>
		<td><%= memberData %></td>
		</tr>
	</table>
	</div>
<!-- 컨텐츠끝 -->

<!-- 푸터 시작 -->
	<%@ include file="../frame/footer.jsp" %>
<!-- 푸터 끝 -->

</body>
</html>
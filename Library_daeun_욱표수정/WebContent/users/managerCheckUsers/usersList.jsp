<%@page import="java.text.SimpleDateFormat"%>
<%@page import="users.model.MemberInfo"%>
<%@page import="users.model.MemberListView"%>
<%@page import="users.service.UsersListService"%>
<%@page import="users.model.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<%
	String pgNumStr = request.getParameter("page");
	// 디폴트 페이지 = 1페이지
	int pgNum = 1;
	
	if (pgNumStr != null){
		pgNum = Integer.parseInt(pgNumStr);
	}
	
	UsersListService service = UsersListService.getInstance();
	MemberListView mListView = service.getUsersListView(pgNum);
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width-device-width, initial-scale=1">
<title>Library Homepage</title>
<!-- boostrap연결 -->

<link rel="stylesheet" href="/lib/css/bootstrap.css">
<!-- css연결 -->
<link rel="stylesheet" href="/lib/cssFiles/default.css" type="text/css">

<!-- 구글폰트 -->
<link
	href="https://fonts.googleapis.com/css?family=Yeseva+One&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap"
	rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/lib/js/bootstrap.js"></script>

<style>
	#user_photo{
		width: 25%;
	}
	
	img{
		max-width: 100%;
		height: auto;
	}
</style>


</head>
<body>

	<div id="main_wrap">
		<!-- header 시작 -->
		<%@include file="../../frame/header.jsp"%>
		<!-- header 끝 -->

		<!-- nav 시작 -->
		<%@include file="../../frame/nav.jsp"%>
		<!-- nav 끝 -->

		<!-- context 시작 -->
		<div id="context">
			<div id="ct">
			<!-- 회원정보 리스트 -->
			<%
			if(mListView.isEmpty()){
			%>
				<h1>등록된 회원이 없습니다</h1>
			<%	
			} else {
			%>
			<h2>(<%=mListView.getStartRow()%>)번 ~ (<%=mListView.getEndRow()%>)번</h2>
			<hr>
			
			<%	
				for (MemberInfo memberInfo : mListView.getMemberList()){
			%>
			
			<table>
			
				<tr>
					<td colspan="2">#0<%=memberInfo.getRownum() %></td>
				</tr>
				
				<tr>
					<td colspan="2">
					<div id="user_photo">
					<%if(memberInfo.getUser_photo().equals("none")){ %>
						<!-- 프로필 없을때 -->
						<img alt="사진" src="/lib/user_photo_upload/default.jpg"/>
						
					<% }else{ %>
						<!-- 프로필 있을때 -->
					<img alt="사진" src="/lib/user_photo_upload/<%=memberInfo.getUser_photo() %>"/>
					
					<%} %>
					</div>
					</td>
				</tr>
				
				<tr>
					<td>회원 아이디</td>
					<td><%=memberInfo.getUser_id() %></td>
				</tr>
				
				<tr>
					<td>회원 비밀번호</td>
					<td><%=memberInfo.getUser_pw() %></td>
				</tr>
				
				<tr>
					<td>회원 이름</td>
					<td><%=memberInfo.getUser_name() %></td>
				</tr>
				
				<tr>
					<td>가입 일자</td>
					<td><%=format.format( memberInfo.getUser_reg() ) %></td>
				</tr>
			</table>
			
			<%		
				}
			}
			
				// 페이지 번호 나누기
				for (int i = 1; i<= mListView.getPgTotalCnt(); i++){
			%>
				<!-- 해당 페이지로 이동 -->
				<a href="usersList.jsp?page=<%=i%>">[<%=i%>]</a>
				
			<%		
				}
			%>
			</div>
		</div>
		<!-- context 끝 -->

		<!-- footer 시작 -->
		<%@include file="../../frame/footer.jsp"%>
		<!-- footer 끝 -->
	</div>


</body>
</html>
<%@page import="StudyRoom.model.user"%>
<%@page import="StudyRoomService.RVservice"%>
<%@page import="StudyRoomService.RCService"%>
<%@page import="StudyRoom.model.Study_room"%>
<%@page import="org.apache.tomcat.jni.Stdlib"%>
<%@page import="StudyRoomService.SeatNum"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	int time = Integer.parseInt(request.getParameter("time"));
	int seat = Integer.parseInt(request.getParameter("seat"));
	int chk = 0;
	
	
	String user_id = (String)session.getAttribute("admin");
	
	
	RCService rcs = RCService.getInstance();
	chk = rcs.SeatRC(user_id,time,seat);
    
	RVservice service = RVservice.getInstance();
	user user = service.SeatRV(user_id);
	
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- boostrap연결 -->
<link rel="stylesheet" href="../css/bootstrap.css">
<!-- css연결 -->
<link rel="stylesheet" href="../cssFiles/default.css" type="text/css">

<!-- 구글폰트 -->
<link href="https://fonts.googleapis.com/css?family=Yeseva+One&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.js"></script>
</head>
<style>
	#a{
		background-color: black;	
		color: white;
		display: inline-block;
		width: 50px;
		margin-left: 3px;
		text-align: center;
		border-radius: 3px;
	}
</style>
<body>
	<div id="main_wrap">
		<!-- header 시작 -->
		<%@include file="../frame/header.jsp"%>
		<!-- header 끝 -->

		<!-- nav 시작 -->
		<%@include file="../frame/nav.jsp"%>
		<!-- nav 끝 -->
				
		<!-- context 시작 -->
		<div id="context">
		
		<h4>바뀐 자리입니다.</h4><br>
		좌석번호 : <%= user.getSeat_num() %><br>
		시간 : <% if(user.getStudy_time() == 1){%>
				09:00~12:00
			<%
			}else if(user.getStudy_time() == 2){
			%>
				12:00~15:00
			<%}else if(user.getStudy_time() == 3){ %>
				15:00~18:00
			<%}else if(user.getStudy_time() == 4){ %>
				18:00~21:00
				<%} %><br><br>
				
		<a href="/lib/StudyRoom/RC.jsp" id="a">수정</a> <a href="/lib/StudyRoom/RD.jsp" id="a">삭제</a>
		
		</div>
		<!-- footer 시작 -->
		<%@include file="../frame/footer.jsp"%>
		<!-- footer 끝 -->
		
	</div>

</body>
</html>
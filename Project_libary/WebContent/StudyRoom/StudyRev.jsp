<%@page import="StudyRoomService.StudyChkService"%>
<%@page import="StudyRoom.model.Study_room"%>
<%@page import="StudyRoomService.SeatNum"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	int time = Integer.parseInt(request.getParameter("time"));
	String user_id = (String)session.getAttribute("admin");
	int seat = Integer.parseInt(request.getParameter("seat"));
	
	Study_room studyroom = new Study_room(time, user_id, seat);
	System.out.println(user_id);

	
		SeatNum seatnum = SeatNum.getInstance();
		seatnum.SeatRev(studyroom);
	
	
 	
 	 
	
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
	/* 수정 */
	h4{
		font-size : 20px;
		font-weight: bold;
	}
	h3{
		font-size: 15px;
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
		<h4>선택하신 자리입니다.</h4>
		<br>
		좌석번호 : <%= studyroom.getSeat_num() %><br>
		시간 : <% if(studyroom.getStudy_time() == 1){%>
				09:00~12:00
			<%
			}else if(studyroom.getStudy_time() == 2){
			%>
				12:00~15:00
			<%}else if(studyroom.getStudy_time() == 3){ %>
				15:00~18:00
			<%}else if(studyroom.getStudy_time() == 4){ %>
				18:00~21:00
				<%} %>
				<!-- 수정 -->
				<br><br>
		<h3>좌석 확인및 수정은<br> 마이페이지 -> 열람실 예약현황으로 가시면<br>
		좌석(확인, 수정, 예약취소)가 가능합니다.</h3> 
				
		</div>
		<!-- footer 시작 -->
		<%@include file="../frame/footer.jsp"%>
		<!-- footer 끝 -->
		
	</div>

</body>
</html>
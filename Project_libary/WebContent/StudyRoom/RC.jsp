<%@page import="StudyRoom.model.Study_room"%>
<%@page import="org.apache.tomcat.jni.Stdlib"%>
<%@page import="StudyRoomService.SeatNum"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	

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
	#table{
	padding: 10px;
	width: 100%;
	height : 200px;
	font-weight : bold;
	text-align: center;
	}
	#table td{
	border : 1px solid gray;
	filter: Alpha(Opacity=50);
	}
	/* 수정 */
	#sub{
	width: 100px;
	height : 30px;
	background-color: black;
	border-color : black;
	border-radius : 5px;
	color: white;
	}
	#seat{
	font-size: 10px;
	padding: 3px;
	}
	#sub:hover {
	text-decoration: underline;
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
		<form action="RC_VIEW.jsp" method="post">
		<table id="table">
				<tr>
					<td>시간</td>
					<td><input type="radio" name="time" value="1">09:00~12:00<br>
						<input type="radio" name="time" value="2">12:00~15:00<br>
						<input type="radio" name="time" value="3">15:00~18:00<br>
						<input type="radio" name="time" value="4">18:00~21:00<br>
					</td>
				</tr>
				<tr>
				<td>좌석번호</td>
				<td>
					<select name="seat" id="seat">
						<option value="1">1번 자리</option>
						<option value="2">2번 자리</option>
						<option value="3">3번 자리</option>
						<option value="4">4번 자리</option>
						<option value="5">5번 자리</option>
					</select>
				</td>
				</tr>
				<tr>
				<td colspan="2"><input type="submit" value="수정" id="sub"></td>
				</tr>
			</table>
			</form>
		</div>
		<!-- footer 시작 -->
		<%@include file="../frame/footer.jsp"%>
		<!-- footer 끝 -->
		
	</div>

</body>
</html>
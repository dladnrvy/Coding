<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="studyroom" class="StudyRoom.model.Study_room"></jsp:useBean>
<jsp:setProperty property="*" name="studyroom"/>
<%
	

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
<!-- 열람실 css연결 -->
<link rel="stylesheet" href="../cssFiles/StudyCss.css" type="text/css">

<!-- 구글폰트 -->
<link href="https://fonts.googleapis.com/css?family=Yeseva+One&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap" rel="stylesheet">

<style>
		#SeatWrap{
           margin: 0 auto;
           text-align: center;
       }
       .btn{
           margin: 5px;
           display: inline-block;
           width: 70px;
           height: 70px;
           background-color: chocolate;
           color: beige;
           text-align: center;
           border: 1px solid #DDD;
           border-radius: 5px;
            display : none;
           font-size: 30px;
       }
       .btn:hover{
           background-color: saddlebrown;
           color: beige;
       }
       #h4{
       display : none;
       }

</style>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="js/bootstrap.js"></script>
<script>
	$(document).ready(function () {
		
		$('#first').on("click",function(){
			href.location
		
		});
		
		
		
		
	});



</script>



</head>
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
			<div id="ct">
			<h3 id="h3">예약시간을 선택해주세요</h3>
	<input type="button" id="first" class="time" value="09:00~12:00">
	<input type="button" id="second" class="time" value="12:00~15:00">
	<input type="button" id="third" class="time" value="15:00~18:00">
	<input type="button" id="fourth" class="time" value="18:00~21:00">
	</div>
	 <div id="SeatWrap">
	 <h4 id="h4">원하시는 좌석을 선택해주세요.</h4>
       <input type= "button" class="btn" value="1">
      <input type= "button" class="btn" value="2">
      <input type= "button" class="btn" value="3">
      <input type= "button" class="btn" value="4">
      <input type= "button" class="btn" value="5"><br>
      <input type= "button" class="btn" value="6">
      <input type= "button" class="btn" value="7">
      <input type= "button" class="btn" value="8">
      <input type= "button" class="btn" value="9">
      <input type= "button" class="btn" value="10"><br>
      <input type= "button" class="btn" value="11">
      <input type= "button" class="btn" value="12">
      <input type= "button" class="btn" value="13">
      <input type= "button" class="btn" value="14">
      <input type= "button" class="btn" value="15"><br>
      <input type= "button" class="btn" value="16">
      <input type= "button" class="btn" value="17">
      <input type= "button" class="btn" value="18">
      <input type= "button" class="btn" value="19">
      <input type= "button" class="btn" value="20">
     </div>
		</div>
		<!-- context 끝 -->

		<!-- footer 시작 -->
		<%@include file="../frame/footer.jsp"%>
		<!-- footer 끝 -->
	</div>
</body>
</html>
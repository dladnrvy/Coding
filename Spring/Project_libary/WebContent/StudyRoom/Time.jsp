<%@page import="StudyRoom.model.Study_room"%>
<%@page import="StudyRoomService.SeatNum"%>
<%@page import="StudyRoom.Dao.StudyRoomDAO"%>
<%@page import="jdbc.ConnectionProvider"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
	
	String time = request.getParameter("time");
	
	int num = 0;
	
	
	 if (time.equals("09:00~12:00")) {
		num = 1;
	}
	 if(time.equals("12:00~15:00")) {  
		num = 2;
	}
	  if(time.equals("15:00~18:00")) {  
		num = 3;
	}
	 if(time.equals("18:00~21:00")) {  
		num = 4;
	}
	 
	
	
	
		SeatNum seatnum = SeatNum.getInstance();
		Study_room sr = seatnum.Seatnum(num);

	 // DAO -> select SEAT where time = ? 을 가져옴 (리스트)
			 // ? -> time
	 // SEAT가 차있으면 id, 비어있으면 null
	 // !=null -> 색칠...!
	 
	

	out.print(num);
%>
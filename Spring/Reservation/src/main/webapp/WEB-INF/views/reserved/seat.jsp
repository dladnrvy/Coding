<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
${resultCnt}
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
	 
	

	out.print(num);
%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String id = request.getParameter("id");
    	String pw = request.getParameter("pw");
    	String ck = request.getParameter("chk");
    	
    	boolean chk = false;
    
    	if(id.equals(pw)){
    		//쿠키 생성 : 사용자 데이터를 저장
    		Cookie c1 = CookieBox.createCookie("LOGIN", "SUCCESS", -1);
    		response.addCookie(c1);
    		Cookie c2 = CookieBox.createCookie("ID", id, -1);
    		response.addCookie(c2);
    		
    		chk = true;
    	
    	
    	if(ck != null){
    		response.addCookie(CookieBox.createCookie("chk", id, 60*60));
    		
    		chk = true;
    	}
    }
    %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<%
		if(chk){
			out.println("<h1>로그인 되었습니다.</h1>");	
			out.println("<a href=\"loginCheck.jsp\">loginCheck!!</a>");
		}else{
			out.println("<script>alert(\'로그인 실패\') history.go(-1);</script>");
		}
		
%>

</body>
</html>
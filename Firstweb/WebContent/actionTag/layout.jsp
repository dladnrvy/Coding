<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	 String ctgy = request.getParameter("ctgy");

	if(ctgy==null){
		ctgy = "1";
	} 
	/* String ctgy = "1"; */

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		margin:0px;
		padding:0px;
	}
	
	#main_wrap{
		border : 1px solid #DDD;
		width : 800px;
		padding : 10px;	
		margin : 10px auto;
	}
	
	#wrap{
		overflow : hidden;
	}
	
	#wrap>div{
		float : left;
	}
	
	#aside{
		height : 200px;
		background-color: gray;
	}
	
	#footer{
		border : 1px solid #DDD;
		height: 50px;
	}
	#menu{
		width: 200px;
	}
</style>
</head>
<body>
	<div id="main_wrap">
		<div id="header">
			<h1>title</h1>
		</div>
		<div id="wrap">
			<div id="menu">
				<jsp:include page="menu.jsp">
					<jsp:param value='<%= ctgy %>' name="ctgy"/>
				</jsp:include>
			</div>
			<div id="aside"><p>dddd</p></div>
		</div>
		
		<div id="footer"></div>	
	</div>










</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>블로그만들기</title>

<link href = "../css/css.jsp" rel="stylesheet" type="text/css">
<style>
</style>
</head>
<body>
<div id="main_rwap">
	<div id ="header">
		<%@ include file = "header.jsp" %>
	</div>
		<div id="nav">
			<%@ include file = "nav.jsp"  %>
		</div>
	
			<div id="contents">
			
				<%@ include file = "aside.jsp"  %>
			</div>
	
				<div id="footer">
					<%@ include file = "footer.jsp"  %>
				</div>
				
				</div>


	

</body>
</html>
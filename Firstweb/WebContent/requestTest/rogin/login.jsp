<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>* {
	margin: 0;
	padding: 0;
}

#main {
	margin: 0 auto;
	width: 950px;
}

h1 {
	text-align: center;
}

table {
	width : 500px;
	margin: 0 auto;
	border : 0;
	border-collapse: callapse;
}

td {
	padding: 10px;
	border : 1px solid #DDD;
}


table tr > td {
	text-align: center;
}

table tr:first-child > td:first-child {
	width: 100px;
}
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");

	%>



	<div id="main">
		<div id="header">
			<%@include file="../header.jsp"%>
		</div>

		<div id="contents">
			<h1>로그인 페이지</h1>
			<br>
			<table>
				<tr>
					<td>이름:</td>
					<td><%= request.getParameter("uName") %></td>
				</tr>
				<tr>
					<td>직업:</td>
					<td><%= request.getParameter("job") %></td>
				</tr>
				<tr>
					<td>관심분야:</td>
					<td>
					<%
						String[] favors= request.getParameterValues("chek");
					
						if(favors != null){
							for(int i = 0; i<favors.length; i++){
								out.print(favors[i]+"<br>");
							}
						}
					
					%>
					
					</td>
				</tr>

			</table>


		</div>
	</div>


</body>
</html>
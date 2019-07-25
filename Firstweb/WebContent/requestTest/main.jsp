<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
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
select{
height: 25px;
}

table tr:last-child > td {
	text-align: center;
}

table tr:first-child > td:first-child {
	width: 100px;
}
</style>
</head>
<body>
	<div id="main">
		<div id="header">
			<%@ include file="header.jsp"%>
		</div>

		<div id="contents">
			<form action="rogin/login.jsp" method="post">
				<table>
					<tr>
						<td>이름</td>
						<td><input type="text" name="uName" required></td>
					</tr>
					<tr>
						<td>직업</td>
						<td>
						<select name="job">
						
						<!-- value 값을 넣지않으면 밑에 값들이 넘어간다!! -->
						
								<option>무직</option>
								<option>무직장</option>
								<option>백수</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>관심분야</td>
						<td><input type="checkbox" name="chek" value="정치">정치 
						<input type="checkbox" name="chek" value="사회">사회 
						<input type="checkbox" name="chek" value="정보통신">정보통신</td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="submit" name="sub" value="확인">
						 <input type="submit" name="cen" value="취소">
						</td>
					</tr>

				</table>
			</form>
		</div>

	</div>


</body>
</html>
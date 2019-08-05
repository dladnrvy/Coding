<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- login.do -> get  -> 화면에 form을 보여줌
			  -> post -> login 처리 
			  액션 생략하면 자기페이지로 이동
			  -->
	<form action = "Login" method ="post">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="uId"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="uPW"></td>
		</tr>
		<tr>
			<td>사진</td>
			<td><input type="file" name="uPhoto"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="로그인"></td>
		</tr>
	</table>
	</form>

</body>
</html>
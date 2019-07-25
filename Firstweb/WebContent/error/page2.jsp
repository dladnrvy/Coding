<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page errorPage = "../errorPage/NewErrorPage.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>오류 처리2</title>
<style>
</style>
</head>
<body>

	name 파라미터 값: <%= request.getParameter("name").toUpperCase() %>

</body>
</html>
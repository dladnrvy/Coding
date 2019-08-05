<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>${resultCnt}</h1>
   <h1>
      <!-- resultCnt가 1이면 결과값은 true -->
      <c:if test="${resultCnt == 1}">
         정상적으로 입력되었습니다.
      </c:if>
      <c:if test="${!(resultCnt == 1)}">
         입력실패!
      </c:if>
   </h1>
   <!-- 변수설정 ㄴㄴ 출력만하기위해 -->   
   <a href="<c:url value="/guest/list" />">리스트</a>
</body>
</html>
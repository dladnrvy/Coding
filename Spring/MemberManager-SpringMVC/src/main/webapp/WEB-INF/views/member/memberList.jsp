<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link href="<c:url value="/css/default.css"/>" rel="stylesheet" type="text/css">
<style>
 table{
 	border-collapse: collapse;
 	border : 0;
 	
 }
 td{
	padding: 3px 10px;
	border : 1px solid #999;
}
div #pagingBox{
	overflow: hidden;
	margin-top : 15px;
}
#pagingBox>div{
	float:left;
	width: 30px;
	height: 30px;
	line-height: 30px;
	text-align: center;
	border : 1px solid #DDD;
	margin: 0 5px;
}
div.searchBox{
	margin : 15px 0;
	width: 400px;
	padding: 15px;
	border: 1px solid #DDD;
}
</style>
</head>
<body>

<!-- 해더 시작 -->
<%@ include file="/WEB-INF/views/frame/header.jsp" %>
<!-- 해더 끝 -->

<!-- 네비게이션 시작 -->
<%@ include file="/WEB-INF/views/frame/nav.jsp" %>
<!-- 네비게이션 끝 -->

<!-- 컨텐츠 시작 -->
<div id="contents">
	<h3>회원리스트</h3>
	<hr>
	<div class = "searchBox">
		<form>
		 	검색<br>
		 	<select name="stype">
		 		<option value="both">아이디+이름</option>
		 		<option value="id">아이디</option>
		 		<option value="name">이름</option>
		 	</select>
		 	<input type="text" name="keyword">
		 	<input type="submit" value="검색">
		</form>
	</div>
		<table>
			<tr>
				<td>no</td>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>사진</td>
				<td>가입일</td>
				<td>관리</td>
			</tr>
			
			<c:forEach items="${viewData.memberList}" var="memberInfo" varStatus="stat">
			<tr>
				<td><%-- ${memberInfo.idx}/${stat.index}/${stat.count}/${viewData.totalCount}/ --%>${viewData.no-stat.index}</td>
				<td>${memberInfo.uId}</td>
				<td>${memberInfo.uPW}</td>
				<td>${memberInfo.uName}</td>
				<td><img src="<c:url value='/uploadfile/userphoto/${memberInfo.uPhoto}'/>" height="50"></td>
				<td>
					<fmt:formatDate value="${memberInfo.regDate}" pattern="yyyy.MM.dd"/>
				</td>
				<td><a href="<c:url value='update?memberId=${memberInfo.idx}'/>">수정</a>|
					<a href="#" onclick = "delMember(${memberInfo.idx})">삭제</a></td>
			</tr>
			</c:forEach>
		</table>
		<c:if test="${viewData.totalCount>0}">
		<div id="pagingBox">
		<div>
			<c:forEach begin="1" end="${viewData.pageTotalCount}" var="num">
				<a href="memberList?p=${num}">${num}</a>
			</c:forEach>
		</div>
		</div>
		</c:if>
</div>
<!-- 컨텐츠 끝 -->


<!-- 푸터 시작 -->
<%@ include file="/WEB-INF/views/frame/footer.jsp" %>
<!-- 푸터 끝 -->


<script>
	function delMember(idx) {
		if(confirm("삭제하시겠습니까?")){
			location.href="memberDelete?memberId="+idx;
		}
		
	}

</script>






</body>
</html>

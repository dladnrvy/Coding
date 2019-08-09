<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div id="nav">
	<%-- <ul>
		<li><a href="${pageContext.request.contextPath}">홈</a></li>
		<li><a href="${pageContext.request.contextPath}/newMember/login.jsp">로그인</a></li>
		<li><a href="${pageContext.request.contextPath}/newMember/memberRegform.jsp">회원가입</a></li>
		<li><a href="${pageContext.request.contextPath}/newMember/mypage.jsp">MyPage</a></li>
		<li><a href="${pageContext.request.contextPath}/newMember/memberList.jsp">회원리스트</a></li>
		<li><a href="${pageContext.request.contextPath}/newMember/logout.jsp">로그아웃</a></li>
	</ul> --%>
	
	<ul>
		<li><a href="<c:url value='/'/>">홈</a></li>
		<li>
		<c:if test="${loginInfo eq null}">
		<a href="<c:url value='/member/login' />">로그인</a>
		</c:if>
		<c:if test="${loginInfo ne null}">
		<li><a href="<c:url value='/member/logout'/>">로그아웃</a></li>
		</c:if>
		</li>
		<li><a href="<c:url value='/member/regist'/>">회원가입</a></li>
		<li><a href="<c:url value='/member/mypage'/>">MyPage1</a></li>
		<li><a href="<c:url value='/member/mypage'/>">MyPage2</a></li>
		<li><a href="<c:url value='/member/memberList'/>">회원리스트</a></li>
		<li><a href="<c:url value='/newMember/memberList2.jsp'/>">회원리스트2</a></li>
		<li><a href="<c:url value='/member/logout'/>">로그아웃</a></li>
		
	</ul>
	</div>
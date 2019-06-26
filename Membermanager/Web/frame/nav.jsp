<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="nav">
	<ul>
		<li><a href="<%= request.getContextPath()%>">홈</a></li>
		<li><a href="<%= request.getContextPath()%>/newMember/login.jsp">로그인</a></li>
		<li><a href="<%= request.getContextPath()%>/newMember/memberRegform.jsp">회원가입</a></li>
		<li><a href="<%= request.getContextPath()%>/newMember/mypage.jsp">MyPage</a></li>
		<li><a href="<%= request.getContextPath()%>/newMember/memberList.jsp">회원리스트</a></li>
		<li><a href="<%= request.getContextPath()%>/newMember/logout.jsp">로그아웃</a></li>
	</ul>
	</div>
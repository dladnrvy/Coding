<%@ page import = "web.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String pType = request.getParameter("type");
	String no = request.getParameter("no");
	String uname = request.getParameter("uname");
	//getParameter 는 string 으로만 값을 받을 수 있다.
	//여러가지 String 메소드 확인
	
	Member member = new Member(uname, pType, no);
	
	request.setAttribute("result", member);
	
	session.setAttribute("user", member);

	/* if(pType == null){
		pType = "a";
	} */

	/* if (no == null) {
		no = "0";
	}

	if (uname == null) {
		uname = "noname";
	}

	if (pType.equals("a")) { */
%>	
		<!-- 
		pType 파라미터 값을 비교 null값을 비교
		no  파라미터 값을 비교 null값을 비교
		uname 파라미터 값을 비교 null값을 비교
 	 -->
	
	<c:set value="${param.type}" var="pageType" scope="request" />
	<c:if test="${pageType eq null or pageType ==''}">
	<c:set value="a" var="pageType" scope="request" />		
	</c:if>  
	
	<c:set value="${param.no}" var="pNo" scope="request"/>
	<c:if test="${pNo eq null or pNo ==''}">
	<c:set value="0" var="pNo" scope="request"/>
	</c:if>
	
	<c:set value="${param.uname}" var="userName" scope="request"/>
	<c:if test="${userName == null or userName ==''}" > 
	<c:set value="noname" var="userName" scope="request"/>
	</c:if>
	
	<%-- <c:if test="${pageType == 'a'}">
		<c:set value="page_a.jsp" var="uri"/>
	</c:if>
	<c:if test="${pageType == 'b'}">
		<c:set value="page_b.jsp" var="uri"/>
	</c:if>
	<c:if test="${pageType == 'c'}">
		<c:set value="page_c.jsp" var="uri"/>
	</c:if> --%>
	
	<c:choose>
		<c:when test="${pageType =='a'}"></c:when>
			<c:set value="page_a.jsp" var="url"/>
		<c:when test="${pageType == 'b'}"></c:when>
			<c:set value="page_b.jsp" var="url"/>
		<c:when test="${pageType == 'c'}"></c:when>
			<c:set value="page_c.jsp" var="url"/>
		<c:otherwise>
			<c:set value="page_a.jsp" var="url"/>
		</c:otherwise>
	</c:choose>
	
	<%-- <jsp:forward page="${uri}"/> --%>
	<jsp:forward page="page_${pageType}.jsp"/>
		

<%-- <jsp:forward page="page_a.jsp">
	<jsp:param value="<%=no%>" name="num" />
	<jsp:param value="<%=uname%>" name="username" />
</jsp:forward>
<%
	} else if (pType.equals("b")) {
%>
<jsp:forward page="page_b.jsp">
	<jsp:param value="<%=no%>" name="num" />
	<jsp:param value="<%=uname%>" name="username" />
</jsp:forward>
<%
	} else {
%>
<jsp:forward page="page_c.jsp">
	<jsp:param value="<%=no%>" name="num" />
	<jsp:param value="<%=uname%>" name="username" />
</jsp:forward>

<%
	}
%> --%>
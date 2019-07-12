<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// usebean 액션 테그 사용전 인코딩 변경해야 한글처리 가능
	request.setCharacterEncoding("utf-8");
%>
<!-- usebean 액션 테그를 이용한 객체 생성 ( 찾고 -> 없을 때 생성 )  -->
<jsp:useBean id="memberInfo" class="member.MemberSave"/>
<!-- 생성된 객체에 데이터 바인딩 : 폼의 name 속성과 beans 클래스의 변수 이름이 동일해야한다 !!!!!  -->
<jsp:setProperty property="*" name="memberInfo"/>
<%
	if(memberInfo.getuPhoto() == null){
		memberInfo.setuPhoto("images.png");
	}
	// 내장객체에 회원정보 객체를 저장
	//application.setAttribute(memberInfo.getuId(), memberInfo);
	Connection conn = null;
	PreparedStatement pstmt = null;
	int resultCnt = 0;
	
	   String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	   String userid = "SCOTT";
	   String userpw = "tiger";
	
	try{
		//String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
	   // conn = DriverManager.getConnection(jdbcDriver);
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   conn = DriverManager.getConnection(jdbcUrl, userid, userpw);
		
	    String sql = "insert into memberinfo (idx,mid,mpw,mname,mphoto) values(memberinfo_idx_seq,?,?,?,?)";
	    pstmt = conn.prepareStatement(sql);
		
	    pstmt.setString(1, memberInfo.getuId());
	    pstmt.setString(2, memberInfo.getuPW());
	    pstmt.setString(3, memberInfo.getuName());
	    pstmt.setString(4, memberInfo.getuPhoto());
	    resultCnt = pstmt.executeUpdate();
	    
	} catch (SQLException se) {

	} finally {
		//6. 객체 close

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {

			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

			}
		}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link href="/mm/css/default.css" rel="stylesheet" type="text/css">
<style>
	.mInfor {
		border : 2px solid #ddd;
		box-shadow: 1px 1px 3px #EEE;
		padding : 10px;
	}
</style>
</head>
<body>

<!-- 해더 시작 -->
<%@ include file="../frame/header.jsp" %>
<!-- 해더 끝 -->

<!-- 네비게이션 시작 -->
<%@ include file="../frame/nav.jsp" %>
<!-- 네비게이션 끝 -->

<!-- 컨텐츠 시작 -->
<div id="contents">		
	
	<h1>회원가입이 완료되었습니다.</h1>
	<h3><%= resultCnt %>번째로 가입하신 회원입니다.</h3>
	
</div>

<!-- 컨텐츠 끝 -->


<!-- 푸터 시작 -->
<%@ include file="../frame/footer.jsp" %>
<!-- 푸터 끝 -->




</body>
</html>
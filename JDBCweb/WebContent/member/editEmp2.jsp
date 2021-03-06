<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="member.emp"></jsp:useBean>
<jsp:setProperty property="*" name="member" />
<%
	request.setCharacterEncoding("utf-8");

	String empno = request.getParameter("empno");
	String ename = request.getParameter("ename");
	String job = request.getParameter("job");

	int eno = Integer.parseInt(empno);

	Connection conn = null;
	PreparedStatement pstmt = null;
	int resultCnt = 0;

	try {
		//1. 데이터베이스 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//2. 데이터베이스 연결

		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

		//3. PreparedStatement 생성
		//사용자 정보 추가를 위한 SQL 작성
	
		pstmt = conn.prepareStatement("insert into emp (empno, ename, job) values(?,?,?)");
		
		pstmt.setInt(1, member.getEmpno());
		pstmt.setString(2, member.getEname());
		pstmt.setString(3, member.getJob());
		
		//4. SQL 실행
		resultCnt = pstmt.executeUpdate();

		//5. 실행결과 출력 : 수정되었습니다.
	} catch (ClassNotFoundException ce) {

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
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>


	<h1>사원 정보 추가</h1>
	<h3><%=resultCnt%>개 행이 추가되었습니다.
	<a href ="emplist.jsp" >리스트확인</a>
	</h3>

</body>
</html>

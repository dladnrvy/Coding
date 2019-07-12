package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			System.out.println("접속");
			
			Statement stmt = conn.createStatement();
			
			//1.입력프로그램
			String slq = "insert into emp values (?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(slq);
			
			pstmt.setInt(1,829);
			pstmt.setString(2,"UKPYO");
			pstmt.setString(3,"KING");
			pstmt.setInt(4, 9308);
			pstmt.setString(5,"93/08/29");
			pstmt.setInt(6, 100);
			pstmt.setInt(7, 100);
			pstmt.setInt(8,20);
			int resultCnt = pstmt.executeUpdate();
			
			if(resultCnt > 0) {
				System.out.println("정상입력");
			}
			//2. 모든데이터 출력
			String sql = "select * from emp order by depno";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("-------------------");
			while(rs.next()) {
				System.out.println("사원번호 :"+rs.getInt(1));
				System.out.println("사원이름 :"+rs.getString(2));
				System.out.println("직업 :"+rs.getString(3));
				System.out.println("매니저 :"+rs.getInt(4));
				System.out.println("입사날짜 :"+rs.getString(5));
				System.out.println("월급 :"+rs.getInt(6));
				System.out.println("성과급 :"+rs.getInt(7));
				System.out.println("부서번호 :"+rs.getInt(8));
				System.out.println("--------------------");
			}
			
			//3. scott 급여 수정
			String update = "update emp set sal = 1000 where ename = 'SCOTT'";
			
			rs = stmt.executeQuery(update);
			System.out.println("SCOTT 데이터 수정완료");
			
			//4. scott 이름 검색 결과
			String ser = "";
			
			rs= stmt.executeQuery(ser);
			
			System.out.println("SCOTT의 정보");
			while(rs.next()) {
				System.out.println("사원번호 :"+rs.getInt(1));
				System.out.println("사원이름 :"+rs.getString(2));
				System.out.println("직업 :"+rs.getString(3));
				System.out.println("매니저 :"+rs.getInt(4));
				System.out.println("입사날짜 :"+rs.getString(5));
				System.out.println("월급 :"+rs.getInt(6));
				System.out.println("성과급 :"+rs.getInt(7));
				System.out.println("부서번호 :"+rs.getInt(8));
				System.out.println("--------------------");
				
			}
			
			//5.모든 사원정보를 출력하되 부서정보를 함께 출력
			String AllPrint = ("select * from emp e, dept d where e.deptno=d.deptno");
			
			rs = stmt.executeQuery(AllPrint);
			
			
			System.out.println("사원정보, 부서정보 출력");
			System.out.println("부서번호 :"+rs.getInt("DEPTNO"));
			System.out.println("사원번호 :"+rs.getInt("EMPNO"));
			System.out.println("사원이름 :"+rs.getString("ENAME"));
			System.out.println("직업 :"+rs.getString("JOB"));
			System.out.println("매니저 :"+rs.getInt("MGR"));
			System.out.println("입사날짜 :"+rs.getString("HIREDATE"));
			System.out.println("월급 :"+rs.getInt("SAL"));
			System.out.println("성과급 :"+rs.getInt("COMM"));
			System.out.println("부서이름 :"+rs.getInt("DNAEM"));
			System.out.println("주소 :"+rs.getInt("LOC"));
			System.out.println("--------------------");
			
			rs.close();
            stmt.close();
            pstmt.close();
            conn.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

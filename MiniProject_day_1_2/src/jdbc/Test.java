package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
<JDBC>
- DB 연결 방법 -> DriverManager 클래스의 getConnection()
- DB 연결 객체  -> Connection 객체
- SQL 전달 , 결과 관리 객체 -> Statement 객체, PreparedStatement 객체, CallableStatement 객체 ( stored procedure )
    - Statement 객체 : SQL 전달할 때 SQL 문에 대한 사전 처리 등이 진행, 객체 생성 시에 SQL 과 상관없이 생성
    - PreparedStatement 객체 : SQL 전달 전에, 객체가 만들어 질 때 SQL 문에 대한 사전 처리 등이 진행 (권장)
    - CallableStatement 객체 :  stored procedure
- SQL 전달 / 결과 수신
    - C, U, D ( insert, update, delete ) : executeUpdate()
         return : 정수( insert, update, delete 된 row 리턴 )
    - R ( read ) : executeQuery()
         ResultSet ( grid )
-- 위 모든 jdbc interface 메소드의 처리는 모두 jdbc driver(implement 객체) 가 대행

*/

public class Test {
	
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/madangdb";
		String user = "root";
		String pwd = "qwer1234";
		
		// No ..driver... jdbc old version 에서 필요할 수도 있다.
//		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// DB 연결 시도하고 연결되면 Connectoin 객체 획득
		Connection con = DriverManager.getConnection(url, user, pwd);
		Statement stmt = con.createStatement();
		ResultSet rs = null;
		
		// insert 
//		{
//			String insertSql = "insert into customer values (6, '손흥민', '영국 토트넘', '010-6666-6666'); ";
//
//			int ret = stmt.executeUpdate(insertSql);
//			System.out.println(ret);
//		}
		
		// update
		{
			String updateSql = "update customer set address = '한국 서울' where custid = 6; ";
			
			int ret = stmt.executeUpdate(updateSql);
			System.out.println(ret);
		}
		
		// select list
		{
			String selectListSql = "select * from customer; ";
			rs = stmt.executeQuery(selectListSql);
			
			while (rs.next()) {
				// row 한 개당 행(컬럼) 값 추출
				System.out.println(rs.getInt("custid") + " | " + rs.getString("name") + " | " + rs.getString("address") + " | " + rs.getString("phone"));
			}
		}
		
		// select detail (one by pk)
		{
			String selectDetailSql = "select * from customer where custid = 6; ";
			rs = stmt.executeQuery(selectDetailSql);
			
			while (rs.next()) {
				// row 한 개당 행(컬럼) 값 추출
				System.out.println(rs.getInt("custid") + " | " + rs.getString("name") + " | " + rs.getString("address") + " | " + rs.getString("phone"));
			}
		}
		
		// delete
		{
			String deleteSql = "delete from customer where custid = 7; ";
			
			int ret = stmt.executeUpdate(deleteSql);
			System.out.println(ret);
		}
		
		// con, stmt <- resource
		if (rs != null) rs.close();
		stmt.close();
		con.close();

	}

}

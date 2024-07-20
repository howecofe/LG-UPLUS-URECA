package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// crud 를 개별 메소드로 구현
// => SQLException Handling
public class Test2 {
	
	static String url = "jdbc:mysql://localhost:3306/madangdb";
	static String user = "root";
	static String pwd = "qwer1234";
	
	public static void main(String[] args) throws SQLException {
		
		insertCustomer();
		updateCustomer();
		listCustomer();
		detailCustomer();
		deleteCustomer();
		
	}
	
	static void insertCustomer() {
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();
			
			String insertSql = "insert into customer values (6, '손흥민', '영국 토트넘', '010-6666-6666'); ";
			int ret = stmt.executeUpdate(insertSql);
			System.out.println(ret);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	static void updateCustomer() {
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();
			
			String updateSql = "update customer set address = '한국 서울' where custid = 6; ";
			int ret = stmt.executeUpdate(updateSql);
			System.out.println(ret);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	static void listCustomer() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();
			
			String selectListSql = "select * from customer; ";
			rs = stmt.executeQuery(selectListSql);
			
			while (rs.next()) {
				System.out.println(rs.getInt("custid") + " | " + rs.getString("name") + " | " + rs.getString("address") + " | " + rs.getString("phone"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	static void detailCustomer() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();
			
			String selectDetailSql = "select * from customer where custid = 6; ";
			rs = stmt.executeQuery(selectDetailSql);
			
			while (rs.next()) {
				System.out.println(rs.getInt("custid") + " | " + rs.getString("name") + " | " + rs.getString("address") + " | " + rs.getString("phone"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	static void deleteCustomer() {
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();
			
			String deleteSql = "delete from customer where custid = 6; ";
			int ret = stmt.executeUpdate(deleteSql);
			System.out.println(ret);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// crud 를 개별 메소드로 구현
// => SQLException Handling
// 개별 메소드를 파라미터, 리턴을 추가해서 main() 협업 메소드 내 하드코딩 제거
// Statement -> PreparedStatement
// select query 처리에 dto 적용
public class Test3 {
	
	static String url = "jdbc:mysql://localhost:3306/madangdb";
	static String user = "root";
	static String pwd = "qwer1234";
	
	public static void main(String[] args) throws SQLException {
		int ret = -1;
		
		ret = insertCustomer(6, "손흥민", "영국 토트넘", "010-1111-1111");
		System.out.println(ret);
		
		ret = updateCustomer(6, "한국 서울");
		System.out.println(ret);
		
		List<CustomerDto> list = listCustomer();
		for (CustomerDto dto : list) {
			System.out.println(dto);
		}
		
		CustomerDto dto = detailCustomer(6);
		System.out.println(dto);
		
		ret = deleteCustomer(6);
		System.out.println(ret);
		
	}
	
	static int insertCustomer(int custId, String name, String address, String phone) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String insertSql = "insert into customer values (?, ?, ?, ?); "; // ? : value 로 대체되어야 하는 항목
		int ret = -1;
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement(insertSql);
			pstmt.setInt(1, custId); // index 1부터 시작
			pstmt.setString(2, name);
			pstmt.setString(3, address);
			pstmt.setString(4, phone);

			ret = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}
	
	static int updateCustomer(int custId, String address) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String updateSql = "update customer set address = ? where custid = ?; "; // ? : value 로 대체되어야 하는 항목
		int ret = -1;
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement(updateSql);
			pstmt.setString(1, address);
			pstmt.setInt(2, custId);

			ret = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}
	
	static List<CustomerDto> listCustomer() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String selectListSql = "select * from customer; ";
		List<CustomerDto> list = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement(selectListSql);
			
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				CustomerDto dto = new CustomerDto();
				
				dto.setCustId(rs.getInt("custid"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
				dto.setPhone(rs.getString("phone"));
				
				list.add(dto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	static CustomerDto detailCustomer(int custId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String selectDetailSql = "select * from customer where custid = ?; ";
		CustomerDto dto = new CustomerDto();
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement(selectDetailSql);
			pstmt.setInt(1, custId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 한 건이니까 while 아니고 if
				dto.setCustId(rs.getInt("custid"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
				dto.setPhone(rs.getString("phone"));
			}
		
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
	
	static int deleteCustomer(int custId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String deleteSql = "delete from customer where custid = ?; "; // ? : value 로 대체되어야 하는 항목
		int ret = -1;
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement(deleteSql);
			pstmt.setInt(1, custId);

			ret = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}

}

package app.foodOrder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.foodOrder.common.DBManager;
import app.foodOrder.dto.StoreDto;

public class StoreDao {

	public int insertStore(StoreDto storeDto) {
		int ret = -1;
		
		String sql = "insert into store values (?, ?, ?, NULL, ?, NULL, ?); ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, storeDto.getStoreId());
			pstmt.setInt(2, storeDto.getCategoryId());
			pstmt.setString(3, storeDto.getStoreName());
			pstmt.setString(4, storeDto.getTell());
			pstmt.setInt(5, storeDto.getMinPrice());
			
			ret = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return ret;
	}
	
	public int updateStore(StoreDto storeDto) {
		int ret = -1;
		
		String sql = "update store set categoryId = ?, storeName = ?, tell = ?, minPrice = ? where storeId = ?; ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, storeDto.getCategoryId());
			pstmt.setString(2, storeDto.getStoreName());
			pstmt.setString(3, storeDto.getTell());
			pstmt.setInt(4, storeDto.getMinPrice());
			pstmt.setInt(5, storeDto.getStoreId());
			
			ret = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return ret;
	}
	
	public int deleteStore(int storeId) {
		int ret = -1;
		
		String sql = "delete from store where storeId = ?; ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, storeId);
			
			ret = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return ret;
	}
	
//	public List<StoreDto> listStore() {
//		List<StoreDto> list = new ArrayList<>();
//		
//		String sql = "select * from store; ";
//		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			con = DBManager.getConnection();
//			pstmt = con.prepareStatement(sql);
//			
//			rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
//				StoreDto storeDto = new StoreDto();
//				
//				storeDto.setStoreId(rs.getInt("storeId"));
//				storeDto.setCategoryId(rs.getInt("categoryId"));
//				storeDto.setStoreName(rs.getString("storeName"));
//				storeDto.setLocation(rs.getString("location"));
//				storeDto.setTell(rs.getString("tell"));
//				storeDto.setMinPrice(rs.getInt("minPrice"));
//				
//				list.add(storeDto);
//			}
//			
//		} catch(SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.releaseConnection(rs, pstmt, con);
//		}
//		
//		return list;
//	}
	
	public List<StoreDto> listStore(int categoryId) {
		List<StoreDto> list = new ArrayList<>();
		
		// join
		String sql = "select * from store, storeCategory where store.categoryId = storeCategory.categoryId and store.categoryId = ?; ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, categoryId);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				StoreDto storeDto = new StoreDto();
				
				storeDto.setStoreId(rs.getInt("storeId"));
				storeDto.setCategoryId(rs.getInt("categoryId"));
				storeDto.setCategoryName(rs.getString("name"));
				storeDto.setStoreName(rs.getString("storeName"));
				storeDto.setLocation(rs.getString("location"));
				storeDto.setTell(rs.getString("tell"));
				storeDto.setMinPrice(rs.getInt("minPrice"));
				
				list.add(storeDto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return list;
	}
	
	public List<StoreDto> listStore(String searchWord) {
		List<StoreDto> list = new ArrayList<>();
		
		String sql = "select * from store where name like ?; "; // % 사용 X, 파라미터 쓰는 곳에서 & 사용
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + searchWord + "%");
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				StoreDto storeDto = new StoreDto();
				
				storeDto.setStoreId(rs.getInt("storeId"));
				storeDto.setCategoryId(rs.getInt("categoryId"));
				storeDto.setStoreName(rs.getString("storeName"));
				storeDto.setLocation(rs.getString("location"));
				storeDto.setTell(rs.getString("tell"));
				storeDto.setMinPrice(rs.getInt("minPrice"));
				
				list.add(storeDto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return list;
	}
	
	public StoreDto detailStore(int storeId) {
		StoreDto storeDto = null;
		
		String sql = "select * from store where storeId = ?; ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, storeId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				storeDto = new StoreDto();
				
				storeDto.setStoreId(rs.getInt("storeId"));
				storeDto.setCategoryId(rs.getInt("categoryId"));
				storeDto.setStoreName(rs.getString("storeName"));
				storeDto.setLocation(rs.getString("location"));
				storeDto.setTell(rs.getString("tell"));
				storeDto.setMinPrice(rs.getInt("minPrice"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return storeDto;
	}
}

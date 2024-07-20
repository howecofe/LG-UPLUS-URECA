package app.foodOrder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.foodOrder.common.DBManager;
import app.foodOrder.dto.StoreCategoryDto;
import app.foodOrder.dto.StoreDto;

public class StoreCategoryDao {
	
	public int insertCategory(StoreCategoryDto storeCategoryDto) {
		int ret = -1;
		
		String sql = "insert into storeCategory values (?, ?, NULL); ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, storeCategoryDto.getCategoryId());
			pstmt.setString(2, storeCategoryDto.getName());
			
			ret = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return ret;
	}
	
	public int updateCategory(StoreCategoryDto storeCategoryDto) {
		int ret = -1;
		
		String sql = "update storeCategory set name = ? where categoryId = ?; ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, storeCategoryDto.getName());
			pstmt.setInt(2, storeCategoryDto.getCategoryId());
			
			ret = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return ret;
	}
	
	public int deleteCategory(int categoryId) {
		int ret = -1;
		
		String sql = "delete from storeCategory where categoryId = ?; ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, categoryId);
			
			ret = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return ret;
	}
	
	public List<StoreCategoryDto> listCategory() {
		List<StoreCategoryDto> list = new ArrayList<>();
		
		String sql = "select * from storeCategory; ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				StoreCategoryDto storeCategory = new StoreCategoryDto();
				
				storeCategory.setCategoryId(rs.getInt("categoryId"));
				storeCategory.setName(rs.getString("name"));
				
				list.add(storeCategory);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return list;
	}
	
	public StoreCategoryDto detailCategory(int categoryId) {
		StoreCategoryDto storeCategoryDto = null;
		
		String sql = "select * from storeCategory where categoryId = ?; ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, categoryId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				storeCategoryDto = new StoreCategoryDto();
				
				storeCategoryDto.setCategoryId(rs.getInt("categoryId"));
				storeCategoryDto.setName(rs.getString("name"));
			
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return storeCategoryDto;
	}
}

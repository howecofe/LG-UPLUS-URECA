package app.foodOrder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.foodOrder.common.DBManager;
import app.foodOrder.dto.MenuDto;
import app.foodOrder.dto.StoreDto;

public class MenuDao {
	public int insertMenu(MenuDto menuDto) {
		int ret = -1;
		
		String sql = "insert into menu values (?, ?, ?, NULL, ?, NULL, NULL); ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, menuDto.getMenuId());
			pstmt.setInt(2, menuDto.getStoreId());
			pstmt.setString(3, menuDto.getMenuName());
			pstmt.setInt(4, menuDto.getPrice());
			
			ret = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return ret;
	}
	
	public int updateMenu(MenuDto menuDto) {
		int ret = -1;
		
		String sql = "update menu set name = ?, price = ? where menuId = ?; ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, menuDto.getMenuName());
			pstmt.setInt(2, menuDto.getPrice());
			pstmt.setInt(3, menuDto.getMenuId());
			
			ret = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return ret;
	}
	
	public int deleteMenu(int menuId) {
		int ret = -1;
		
		String sql = "delete from menu where menuId = ?; ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, menuId);
			
			ret = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return ret;
	}
	
	public List<MenuDto> listMenu(int storeId) {
		List<MenuDto> list = new ArrayList<>();
		
		String sql = "select * from menu, store where menu.storeId = store.storeId and menu.storeId = ?; ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, storeId);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MenuDto menuDto = new MenuDto();
				
				menuDto.setMenuId(rs.getInt("menuId"));
				menuDto.setStoreId(rs.getInt("storeId"));
				menuDto.setStoreName(rs.getString("storeName"));
				menuDto.setMenuName(rs.getString("name"));
				menuDto.setPrice(rs.getInt("price"));
				
				list.add(menuDto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return list;
	}
	
	public List<MenuDto> listMenu(String searchWord) {
		List<MenuDto> list = new ArrayList<>();
		
		String sql = "select * from menu where name like ?; "; // % 사용 X, 파라미터 쓰는 곳에서 & 사용
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + searchWord + "%");
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MenuDto menuDto = new MenuDto();
				
				menuDto.setMenuId(rs.getInt("menuId"));
				menuDto.setStoreId(rs.getInt("storeId"));
				menuDto.setMenuName(rs.getString("name"));
				menuDto.setPrice(rs.getInt("price"));
				
				list.add(menuDto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return list;
	}
	
	public MenuDto detailMenu(int menuId) {
		MenuDto menuDto = null;
		
		String sql = "select * from menu where menuId = ?; ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, menuId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				menuDto = new MenuDto();
				
				menuDto.setMenuId(rs.getInt("menuId"));
				menuDto.setStoreId(rs.getInt("storeId"));
				menuDto.setMenuName(rs.getString("name"));
				menuDto.setPrice(rs.getInt("price"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return menuDto;
	}
}

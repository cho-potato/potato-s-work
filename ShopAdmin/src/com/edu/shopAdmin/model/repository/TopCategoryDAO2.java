package com.edu.shopAdmin.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.shopAdmin.domain.TopCategory;
import com.edu.shopAdmin.util.DBManager;

// 이 클래스는 topCategory 테이블에 대해서 CRUD 수행을 목적으로 정의함
// SELECT문을 AdminMain에서 작성해도 프로그램은 수행될 수 있으나,
// 개발방법적인 측면에서 본다면 유지보수성이 떨어진다
// DAO로 별도로 정의해놓으면 admin 뿐만 아니라 customer 입장에서도 이용 가능하다 (재사용=시간==돈)

public class TopCategoryDAO2 {
	DBManager dbManager = DBManager.getInstance();
	
	public List selectAll() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TopCategory> list = new ArrayList<TopCategory>();
		conn = dbManager.getConnection();
		
		String sql = "select * from topCategory order by topCategory_idx asc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			TopCategory topCategory = new TopCategory();
			topCategory.setTopcategory_idx(rs.getInt("topcategory_idx"));
			topCategory.setTopcategory_name(rs.getString("topCategory_name"));
			list.add(topCategory);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbManager.release(pstmt, rs);
		}
		return list;
	}
	public int getTopCategoryIdx(String topcategory_name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int topcategory_idx = 0;
		
		String sql = "select topcategory_idx from topcategory where topcategory_name=?";
		
		conn = dbManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, topcategory_name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				topcategory_idx = rs.getInt(topcategory_idx);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.release(pstmt, rs);
		}
		return topcategory_idx;
	}
}
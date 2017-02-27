package com.ltgo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ltgo.dao.UserLikeDao;
import com.ltgo.util.DBHelper;

public class UserLikeDaoImpl implements UserLikeDao {

	@Override
	public List<String> getUserLike(int id) {
		List<String> list = new ArrayList<String>();
		Connection conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from ts_like where u_Id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()){
				int likeNS = rs.getInt(1);
				list.add(String.valueOf(likeNS));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, pst, rs);
		}
		return null;
	}


}

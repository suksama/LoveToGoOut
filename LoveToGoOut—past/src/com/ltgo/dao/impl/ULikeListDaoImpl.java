package com.ltgo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ltgo.dao.ULikeListDao;
import com.ltgo.util.DBHelper;

public class ULikeListDaoImpl implements ULikeListDao {

	@Override
	public void setULikeList(List<String> list) {

		/*for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + "    " + i);

		}*/

		int uid = 0;
		int nid = 0;
		if (list.size() >= 2) {
			uid = Integer.parseInt(list.get(list.size() - 2));
			nid = Integer.parseInt(list.get(list.size() - 1));
			list.remove(list.get(list.size() - 1));
			list.remove(list.get(list.size() - 1));
		}

		String sql1 = "select NS_Id from ts_like where u_Id=? and n_Id=?";
		String sql2 = "insert into ts_like(u_Id,NS_Id,n_Id) values(?,?,?)";
		String sql3 = "delete from ts_like where u_Id =? and NS_Id=?";
		Connection conn = DBHelper.getConnection();
		PreparedStatement pst;
		ResultSet rs;
		int nsId;
		try {
			pst = conn.prepareStatement(sql1);
			pst.setInt(1, uid);
			pst.setInt(2, nid);
			rs = pst.executeQuery();
			while (rs.next()) {
				nsId = rs.getInt(1);
				if (list.contains(String.valueOf(nsId))) {
					list.remove(String.valueOf(nsId));
				} else {
					pst = conn.prepareStatement(sql3);
					pst.setInt(1, uid);
					pst.setInt(2, nsId);
					pst.executeUpdate();
				}
			}
			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i));

				pst = conn.prepareStatement(sql2);
				pst.setInt(1, uid);
				pst.setInt(2, Integer.parseInt(list.get(i)));
				pst.setInt(3, nid);
				pst.executeUpdate();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

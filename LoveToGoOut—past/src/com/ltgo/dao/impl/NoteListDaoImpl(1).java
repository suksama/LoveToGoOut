package com.ltgo.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ltgo.dao.NoteListDao;
import com.ltgo.json.model.TravelNoteSingle;
import com.ltgo.util.DBHelper;
import com.ltgo.util.Stringutil;

public class NoteListDaoImpl implements NoteListDao {

	@Override
	public List<TravelNoteSingle> getNoteList(int id) {
		List<TravelNoteSingle> list = new ArrayList<TravelNoteSingle>();
		Connection conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Stringutil sUtil = new Stringutil();
		String sql = "select * from travel_note_single where n_Id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				int nsid = rs.getInt(1);

				String sql2 = "select count(*) from ts_like where NS_Id=?";
				ResultSet rss = null;
				pst = conn.prepareStatement(sql2);
				pst.setInt(1, nsid);
				rss = pst.executeQuery();
				int likeNum = 0;
				if (rss.next()) {
					likeNum = rss.getInt(1);
				}
				String imageName = rs.getString(2);
				String content = rs.getString(3);
				String locate = rs.getString(4);
				String dateTime = rs.getString(6);
				imageName = sUtil.processNull(imageName);
				content = sUtil.processNull(content);
				locate = sUtil.processNull(locate);
				TravelNoteSingle tNote = new TravelNoteSingle(nsid, imageName, content, locate,likeNum,dateTime);
				list.add(tNote);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.close(conn, pst, rs);
		}
		return null;
	}

}

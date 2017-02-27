package com.ltgo.dao.impl;

import java.sql.Connection;
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
	public List<TravelNoteSingle> getNoteList() {
		List<TravelNoteSingle> list = new ArrayList<TravelNoteSingle>();
		Connection conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Stringutil sUtil = new Stringutil();
		String sql = "select * from travel_note_single";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				String imageName = rs.getString(2);
				String content = rs.getString(3);
				String locate = rs.getString(4);
				int likeNum = rs.getInt(5);
				imageName = sUtil.processNull(imageName);
				content = sUtil.processNull(content);
				locate = sUtil.processNull(locate);
				TravelNoteSingle tNote = new TravelNoteSingle(imageName, content, locate, likeNum);
				list.add(tNote);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

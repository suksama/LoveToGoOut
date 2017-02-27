package com.ltgo.dao;



import java.util.List;

import com.ltgo.json.model.TravelNoteSingle;


public interface NoteListDao {
	public List<TravelNoteSingle> getNoteList(int id);
}

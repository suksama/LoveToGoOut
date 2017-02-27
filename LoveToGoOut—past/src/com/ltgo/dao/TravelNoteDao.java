package com.ltgo.dao;

import com.ltgo.model.TravelNotePage;


public interface TravelNoteDao {
	public TravelNotePage getTravelNoteByPage(int tCurrentPage, int pageSize,String searchContent);

}

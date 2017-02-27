package com.ltgo.service;

import com.ltgo.model.TravelNotePage;


public interface TravelNoteService {
	public TravelNotePage getTravelNoteByPage(int tCurrentPage, int pageSize);

}

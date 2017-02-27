package com.ltgo.service.impl;

import com.ltgo.dao.TravelNoteDao;
import com.ltgo.dao.impl.TravelNoteDaoImpl;
import com.ltgo.model.TravelNotePage;
import com.ltgo.service.TravelNoteService;

public class TravelNoteServiceImpl implements TravelNoteService {
	private TravelNoteDao dao;
	
	public TravelNoteServiceImpl() {
		dao = new TravelNoteDaoImpl();
	}


	public TravelNotePage getTravelNoteByPage(int tCurrentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}

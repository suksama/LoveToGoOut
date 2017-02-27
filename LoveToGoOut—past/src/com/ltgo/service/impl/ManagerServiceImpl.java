package com.ltgo.service.impl;

import java.util.List;

import com.ltgo.dao.ManagerDao;
import com.ltgo.dao.impl.ManagerDaoImpl;
import com.ltgo.model.Manager;
import com.ltgo.model.ManagerPage;
import com.ltgo.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDao dao;

	public ManagerServiceImpl(){
		dao = new ManagerDaoImpl();
	}
	
	
	public List<Manager> getAllManagers() {
		// TODO Auto-generated method stub
		return dao.getAllManagers();
	}

	
	public boolean deleteManagerByAccount(String account) {
		// TODO Auto-generated method stub
		return dao.deleteManagerByAccount(account);
	}

	
	public Manager getManagerByAccount(String account) {
		// TODO Auto-generated method stub
		return dao.getManagerByAccount(account);
	}

	
	public boolean updateManager(Manager manager) {
		// TODO Auto-generated method stub
		return dao.updateManager(manager);
	}

	
	public int getPage(int pagesize) {
		// TODO Auto-generated method stub
		return dao.getPage(pagesize);
	}

	
	public ManagerPage getManagerByPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getManagerByPage(currentPage, pageSize);
	}

	
	public boolean addManager(Manager manager) {
		// TODO Auto-generated method stub
		return dao.addManager(manager);
	}

}

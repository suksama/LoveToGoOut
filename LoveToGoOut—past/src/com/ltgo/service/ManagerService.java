package com.ltgo.service;

import java.util.List;

import com.ltgo.model.Manager;
import com.ltgo.model.ManagerPage;

public interface ManagerService {
	public List<Manager> getAllManagers();
	public boolean deleteManagerByAccount(String account);
	public Manager getManagerByAccount(String account);
	public boolean updateManager(Manager manager);
	public int getPage(int pagesize); 
	public ManagerPage getManagerByPage(int currentPage,int pageSize);
	public boolean addManager(Manager manager);

}

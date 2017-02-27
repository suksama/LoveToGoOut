package com.ltgo.model;

import java.util.List;

public class ManagerPage {
	private List<Manager> data;
	private int totalPage;
	private int currentPage;
	public List<Manager> getData(){
		return data;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setData(List<Manager> data) {
		this.data = data;
	}
	public ManagerPage(List<Manager> data, int totalPage, int currentPage) {
		super();
		this.data = data;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
	}

}

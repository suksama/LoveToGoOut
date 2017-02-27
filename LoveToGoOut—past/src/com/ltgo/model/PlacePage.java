package com.ltgo.model;

import java.util.List;

public class PlacePage {
	private List<PlaceView> data;
	private int totalPage;
	private int currentPage;
	public List<PlaceView> getData() {
		return data;
	}
	public void setData(List<PlaceView> data) {
		this.data = data;
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
	public PlacePage(List<PlaceView> data, int totalPage, int currentPage) {
		super();
		this.data = data;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
	}
	
}

package com.ltgo.model;

import java.util.List;

public class TravelNotePage {
	private List<TravelNote> data;
	private int totalPage;
	private int currentPage;
	public TravelNotePage(List<TravelNote> data, int totalPage, int currentPage) {
		super();
		this.data = data;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
	}
	public List<TravelNote> getData() {
		return data;
	}
	public void setData(List<TravelNote> data) {
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
	
	
}

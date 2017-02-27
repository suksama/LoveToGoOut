package com.ltgo.json.model;

import java.util.List;



public class NotePage {
	private List<NotesJson> data;
	private int totalPage;
	private int currentPage;
	public List<NotesJson> getData() {
		return data;
	}
	public void setData(List<NotesJson> data) {
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
	public NotePage(List<NotesJson> data, int totalPage, int currentPage) {
		super();
		this.data = data;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
	}
	
}

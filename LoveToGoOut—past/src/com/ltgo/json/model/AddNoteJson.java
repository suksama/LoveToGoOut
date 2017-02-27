package com.ltgo.json.model;

import java.util.List;

public class AddNoteJson { 
	private int u_id;
	private int c_Id;
	private List<Integer> idlist;
	private List<String> datelist;
	
	public int getC_Id() {
		return c_Id;
	}
	public void setC_Id(int c_Id) {
		this.c_Id = c_Id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public List<Integer> getIdlist() {
		return idlist;
	}
	public void setIdlist(List<Integer> idlist) {
		this.idlist = idlist;
	}
	public List<String> getDatelist() {
		return datelist;
	}
	public void setDatelist(List<String> datelist) {
		this.datelist = datelist;
	}
	public AddNoteJson(int u_Id,int c_Id,List<Integer> idlist, List<String> datelist) {
		super();
		this.u_id=u_Id;
		this.c_Id=c_Id;
		this.idlist = idlist;
		this.datelist = datelist;
	}
	
}

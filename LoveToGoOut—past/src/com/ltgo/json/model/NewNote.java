package com.ltgo.json.model;

public class NewNote {
	private String nn_Name;
	private int u_Id;
	private String nn_CreateTime;
	public String getNn_Name() {
		return nn_Name;
	}
	public void setNn_Name(String nn_Name) {
		this.nn_Name = nn_Name;
	}
	public int getU_Id() {
		return u_Id;
	}
	public void setU_Id(int u_Id) {
		this.u_Id = u_Id;
	}
	public String getNn_CreateTime() {
		return nn_CreateTime;
	}
	public void setNn_CreateTime(String nn_CreateTime) {
		this.nn_CreateTime = nn_CreateTime;
	}
	public NewNote(String nn_Name, int u_Id, String nn_CreateTime) {
		super();
		this.nn_Name = nn_Name;
		this.u_Id = u_Id;
		this.nn_CreateTime = nn_CreateTime;
	}
	
}

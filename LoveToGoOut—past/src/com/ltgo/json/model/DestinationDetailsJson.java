package com.ltgo.json.model;

public class DestinationDetailsJson{
	@Override
	public String toString() {
		return "DestinationDetailsJson [ddj_Name=" + ddj_Name + ", ddj_imgUrl=" + ddj_imgUrl + ", ddj_Id=" + ddj_Id
				+ "]";
	}
	private String ddj_Name;
	private String ddj_imgUrl;
	private int ddj_Id;
	public String getDdj_Name() {
		return ddj_Name;
	}
	public void setDdj_Name(String ddj_Name) {
		this.ddj_Name = ddj_Name;
	}
	public String getDdj_imgUrl() {
		return ddj_imgUrl;
	}
	public void setDdj_imgUrl(String ddj_imgUrl) {
		this.ddj_imgUrl = ddj_imgUrl;
	}
	public int getDdj_Id() {
		return ddj_Id;
	}
	public void setDdj_Id(int ddj_Id) {
		this.ddj_Id = ddj_Id;
	}
	public DestinationDetailsJson(String ddj_Name, String ddj_imgUrl, int ddj_Id) {
		super();
		this.ddj_Name = ddj_Name;
		this.ddj_imgUrl = ddj_imgUrl;
		this.ddj_Id = ddj_Id;
	}
	
}
 
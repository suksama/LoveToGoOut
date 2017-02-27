package com.ltgo.json.model;

public class ReviseNote {
	private int rn_Id;
	private String rn_ImageUrl;
	private String rn_content;
	private String rn_Location;
	public int getRn_Id() {
		return rn_Id;
	}
	public void setRn_Id(int rn_Id) {
		this.rn_Id = rn_Id;
	}
	public String getRn_ImageUrl() {
		return rn_ImageUrl;
	}
	public void setRn_ImageUrl(String rn_ImageUrl) {
		this.rn_ImageUrl = rn_ImageUrl;
	}
	public String getRn_content() {
		return rn_content;
	}
	public void setRn_content(String rn_content) {
		this.rn_content = rn_content;
	}
	public String getRn_Location() {
		return rn_Location;
	}
	public void setRn_Location(String rn_Location) {
		this.rn_Location = rn_Location;
	}
	public ReviseNote(int rn_Id, String rn_ImageUrl, String rn_content, String rn_Location) {
		super();
		this.rn_Id = rn_Id;
		this.rn_ImageUrl = rn_ImageUrl;
		this.rn_content = rn_content;
		this.rn_Location = rn_Location;
	}
	
}

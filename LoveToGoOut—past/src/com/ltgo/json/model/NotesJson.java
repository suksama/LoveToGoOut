package com.ltgo.json.model;

import java.sql.Date;

public class NotesJson {
	private int nj_Id;//游记Id
	private String nj_Name;//游记名称
	private String nj_startTime;//游记开始时间
	private String nj_photo;//游记图片路径
	private String nj_icon;//游记头像路径
	
	public int getNj_Id() {
		return nj_Id;
	}
	public void setNj_Id(int nj_Id) {
		this.nj_Id = nj_Id;
	}
	public void setNj_startTime(String nj_startTime) {
		this.nj_startTime = nj_startTime;
	}
	public String getNj_Name() {
		return nj_Name;
	}
	public void setNj_Name(String nj_Name) {
		this.nj_Name = nj_Name;
	}
	public String getNj_startTime() {
		return nj_startTime;
	}
	public void setNj_createTime(String nj_startTime) {
		this.nj_startTime = nj_startTime;
	}
	public String getNj_photo() {
		return nj_photo;
	}
	public void setNj_photo(String nj_photo) {
		this.nj_photo = nj_photo;
	}
	public String getNj_icon() {
		return nj_icon;
	}
	public void setNj_icon(String nj_icon) {
		this.nj_icon = nj_icon;
	}
	public NotesJson(int nj_Id,String nj_Name, String nj_startTime, String nj_photo, String nj_icon) {
		super();
		this.nj_Id=nj_Id;
		this.nj_Name = nj_Name;
		this.nj_startTime = nj_startTime;
		this.nj_photo = nj_photo;
		this.nj_icon = nj_icon;
	}
	
}

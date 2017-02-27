package com.ltgo.json.model;

import java.util.Date;

public class presonNoteJson {
	private int pnj_Day;
	private String pnj_CreateTime;
	private String pnj_Name;
	public int getPnj_Day() {
		return pnj_Day;
	}
	public void setPnj_Day(int pnj_Day) {
		this.pnj_Day = pnj_Day;
	}
	public String getPnj_CreateTime() {
		return pnj_CreateTime;
	}
	public void setPnj_CreateTime(String pnj_CreateTime) {
		this.pnj_CreateTime = pnj_CreateTime;
	}
	public String getPnj_Name() {
		return pnj_Name;
	}
	public void setPnj_Name(String pnj_Name) {
		this.pnj_Name = pnj_Name;
	}
	public presonNoteJson(int pnj_Day, String pnj_CreateTime, String pnj_Name) {
		super();
		this.pnj_Day = pnj_Day;
		this.pnj_CreateTime = pnj_CreateTime;
		this.pnj_Name = pnj_Name;
	}
	@Override
	public String toString() {
		return "presonNoteJson [pnj_Day=" + pnj_Day + ", pnj_CreateTime=" + pnj_CreateTime + ", pnj_Name=" + pnj_Name
				+ "]";
	}
	
}

package com.ltgo.json.model;

public class PDJSon {
	private int pdj_id;
	private String pdj_date;
	private String pdj_end_address;
	public int getPdj_id() {
		return pdj_id;
	}
	public void setPdj_id(int pdj_id) {
		this.pdj_id = pdj_id;
	}
	public String getPdj_date() {
		return pdj_date;
	}
	public void setPdj_date(String pdj_date) {
		this.pdj_date = pdj_date;
	}
	public String getPdj_end_address() {
		return pdj_end_address;
	}
	public void setPdj_end_address(String pdj_end_address) {
		this.pdj_end_address = pdj_end_address;
	}
	public PDJSon(int pdj_id, String pdj_date, String pdj_end_address) {
		super();
		this.pdj_id = pdj_id;
		this.pdj_date = pdj_date;
		this.pdj_end_address = pdj_end_address;
	}
	
	
}

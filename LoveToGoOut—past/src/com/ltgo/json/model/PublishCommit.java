package com.ltgo.json.model;

public class PublishCommit {
	
	private String ch_Text;
	private String ch_SendTime;
	private int u_id;
	private int ch_status;
	private int NS_Id;
	
	public String getCh_Text() {
		return ch_Text;
	}
	public void setCh_Text(String ch_Text) {
		this.ch_Text = ch_Text;
	}
	public String getCh_SendTime() {
		return ch_SendTime;
	}
	public void setCh_SendTime(String ch_SendTime) {
		this.ch_SendTime = ch_SendTime;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getCh_status() {
		return ch_status;
	}
	public void setCh_status(int ch_status) {
		this.ch_status = ch_status;
	}
	public int getNS_Id() {
		return NS_Id;
	}
	public void setNS_Id(int nS_Id) {
		NS_Id = nS_Id;
	}
	public PublishCommit(String ch_Text, String ch_SendTime, int u_id, int ch_status, int nS_Id) {
		super();
		
		this.ch_Text = ch_Text;
		this.ch_SendTime = ch_SendTime;
		this.u_id = u_id;
		this.ch_status = ch_status;
		NS_Id = nS_Id;
	}
	
}

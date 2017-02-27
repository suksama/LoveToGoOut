package com.ltgo.model;

public class User {
	private String U_LoginID;
	private String U_PassWord;
	private String U_NickName;
	private String overflag;
	
	public String getU_LoginID() {
		return U_LoginID;
	}
	public void setU_LoginID(String u_LoginID) {
		U_LoginID = u_LoginID;
	}
	public String getU_PassWord() {
		return U_PassWord;
	}
	public void setU_PassWord(String u_PassWord) {
		U_PassWord = u_PassWord;
	}
	public String getU_NickName() {
		return U_NickName;
	}
	public void setU_NickName(String u_NickName) {
		U_NickName = u_NickName;
	}
	
	public String getOverflag() {
		return overflag;
	}
	public void setOverflag(String overflag) {
		this.overflag = overflag;
	}
	public User(String u_LoginID, String u_PassWord, String u_NickName, String overflag) {
		super();
		this.U_LoginID = u_LoginID;
		this.U_PassWord = u_PassWord;
		this.U_NickName = u_NickName;
		this.overflag = overflag;
	}
	
	


	

}

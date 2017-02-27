package com.ltgo.model;

public class City {
	private int c_Id;
	private String c_Name;
	private String c_Ename;
	private String c_Photo;
	private String c_Localtion;
	public int getC_Id() {
		return c_Id;
	}
	public void setC_Id(int cId) {
		c_Id = cId;
	}
	public String getC_Name() {
		return c_Name;
	}
	public void setC_Name(String cName) {
		c_Name = cName;
	}
	public String getC_Ename() {
		return c_Ename;
	}
	public void setC_Ename(String cEname) {
		c_Ename = cEname;
	}
	public String getC_Photo() {
		return c_Photo;
	}
	public void setC_Photo(String cPhoto) {
		c_Photo = cPhoto;
	}
	public String getC_Localtion() {
		return c_Localtion;
	}
	public void setC_Localtion(String cLocaltion) {
		c_Localtion = cLocaltion;
	}
	public City(int cId, String cName, String cEname, String cPhoto,
			String cLocaltion) {
		super();
		c_Id = cId;
		c_Name = cName;
		c_Ename = cEname;
		c_Photo = cPhoto;
		c_Localtion = cLocaltion;
	}
	public City() {
		super();
	}
	
}

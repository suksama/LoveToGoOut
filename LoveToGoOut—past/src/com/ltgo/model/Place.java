package com.ltgo.model;

public class Place {
	private  int p_Id;
	private String p_Name;
	private String p_Ename;
	private int c_Id;
	private String p_photo;
	private String p_Text;
	private double p_Local;
	public int getP_Id() {
		return p_Id;
	}
	public void setP_Id(int pId) {
		p_Id = pId;
	}
	public String getP_Name() {
		return p_Name;
	}
	public void setP_Name(String pName) {
		p_Name = pName;
	}
	public String getP_Ename() {
		return p_Ename;
	}
	public void setP_Ename(String pEname) {
		p_Ename = pEname;
	}
	public int getC_Id() {
		return c_Id;
	}
	public void setC_Id(int cId) {
		c_Id = cId;
	}
	public String getP_photo() {
		return p_photo;
	}
	public void setP_photo(String pPhoto) {
		p_photo = pPhoto;
	}
	public String getP_Text() {
		return p_Text;
	}
	public void setP_Text(String pText) {
		p_Text = pText;
	}
	public double getP_Local() {
		return p_Local;
	}
	public void setP_Local(double pLocal) {
		p_Local = pLocal;
	}
	public Place(int pId, String pName, String pEname, int cId, String pPhoto,
			String pText, double pLocal) {
		super();
		p_Id = pId;
		p_Name = pName;
		p_Ename = pEname;
		c_Id = cId;
		p_photo = pPhoto;
		p_Text = pText;
		p_Local = pLocal;
	}
	public Place() {
		super();
	}
	
}

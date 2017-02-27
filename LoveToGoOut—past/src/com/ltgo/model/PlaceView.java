package com.ltgo.model;

public class PlaceView {
	private int p_Id;
	private String p_Name;
	private String p_Ename;
	private String p_Text;
	private double p_Local;
	private int c_Id;
	private String c_Name;
	private String c_Ename;
	
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
	
	public int getC_Id() {
		return c_Id;
	}
	public void setC_Id(int cId) {
		c_Id = cId;
	}
	public PlaceView(int pId, String pName, String pEname, String pText,
			double pLocal, int c_Id,String cName, String cEname) {
		super();
		p_Id = pId;
		p_Name = pName;
		p_Ename = pEname;
		p_Text = pText;
		p_Local = pLocal;
		this.c_Id=c_Id;
		c_Name = cName;
		c_Ename = cEname;
		
	}
	@Override
	public String toString() {
		return "PlaceView [c_Ename=" + c_Ename + ", c_Id=" + c_Id + ", c_Name="
				+ c_Name + ", p_Ename=" + p_Ename + ", p_Id=" + p_Id
				+ ", p_Local=" + p_Local + ", p_Name=" + p_Name + ", p_Text="
				+ p_Text + "]";
	}
	
}

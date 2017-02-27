package com.ltgo.json.model;

public class AddressJson {
	private int aj_Id;//城市Id
	private String aj_Name;//城市名称
	private String aj_Ename;//城市英文名
	private String aj_imgUrl;//城市图片路径
	private int aj_Num;//城市旅游地数量
	public int getAj_Id() {
		return aj_Id;
	}
	public void setAj_Id(int aj_Id) {
		this.aj_Id = aj_Id;
	}
	@Override
	public String toString() {
		return "AddressJson [aj_Id=" + aj_Id + ", aj_Name=" + aj_Name + ", aj_Ename=" + aj_Ename + ", aj_imgUrl="
				+ aj_imgUrl + ", aj_Num=" + aj_Num + "]";
	}
	public String getAj_Name() {
		return aj_Name;
	}
	public void setAj_Name(String aj_Name) {
		this.aj_Name = aj_Name;
	}
	public String getAj_Ename() {
		return aj_Ename;
	}
	public void setAj_Ename(String aj_Ename) {
		this.aj_Ename = aj_Ename;
	}
	public String getAj_imgUrl() {
		return aj_imgUrl;
	}
	public void setAj_imgUrl(String aj_imgUrl) {
		this.aj_imgUrl = aj_imgUrl;
	}
	public int getAj_Num() {
		return aj_Num;
	}
	public void setAj_Num(int aj_Num) {
		this.aj_Num = aj_Num;
	}
	public AddressJson(int aj_Id,String aj_Name, String aj_Ename, String aj_imgUrl, int aj_Num) {
		super();
		this.aj_Id=aj_Id;
		this.aj_Name = aj_Name;
		this.aj_Ename = aj_Ename;
		this.aj_imgUrl = aj_imgUrl;
		this.aj_Num = aj_Num;
	}
	
}

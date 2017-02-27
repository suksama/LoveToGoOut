package com.ltgo.model;

public class PlacePrice {
	private int p_Id;
	private String pp_WebName;
	private double pp_Price;
	
	public int getP_Id() {
		return p_Id;
	}
	public void setP_Id(int p_Id) {
		this.p_Id = p_Id;
	}
	public String getPp_WebName() {
		return pp_WebName;
	}
	public void setPp_WebName(String ppWebName) {
		pp_WebName = ppWebName;
	}
	public double getPp_Price() {
		return pp_Price;
	}
	public void setPp_Price(double ppPrice) {
		pp_Price = ppPrice;
	}
	public PlacePrice(String ppWebName, double ppPrice) {
		super();
		pp_WebName = ppWebName;
		pp_Price = ppPrice;
	}
	public PlacePrice() {
		super();
	}
	public PlacePrice(int p_Id, String pp_WebName, double pp_Price) {
		super();
		this.p_Id = p_Id;
		this.pp_WebName = pp_WebName;
		this.pp_Price = pp_Price;
	}
	
}

package com.ltgo.json.model;

public class NoteBarJson {
	private int nbj_Id;
	private int nj_Id;
	private String nbj_Text;
	private String nbj_imgUrl;
	private String nbj_Time;
	private int p_Id;
	private String nbj_placename;
	
	public String getNbj_placename() {
		return nbj_placename;
	}
	public void setNbj_placename(String nbj_placename) {
		this.nbj_placename = nbj_placename;
	}
	public int getNbj_Id() {
		return nbj_Id;
	}
	public void setNbj_Id(int nbj_Id) {
		this.nbj_Id = nbj_Id;
	}
	public int getNj_Id() {
		return nj_Id;
	}
	public void setNj_Id(int nj_Id) {
		this.nj_Id = nj_Id;
	}
	public String getNbj_Text() {
		return nbj_Text;
	}
	public void setNbj_Text(String nbj_Text) {
		this.nbj_Text = nbj_Text;
	}
	public String getNbj_imgUrl() {
		return nbj_imgUrl;
	}
	public void setNbj_imgUrl(String nbj_imgUrl) {
		this.nbj_imgUrl = nbj_imgUrl;
	}
	public String getNbj_Time() {
		return nbj_Time;
	}
	public void setNbj_Time(String nbj_Time) {
		this.nbj_Time = nbj_Time;
	}
	public int getP_Id() {
		return p_Id;
	}
	public void setP_Id(int p_Id) {
		this.p_Id = p_Id;
	}
	public NoteBarJson(int nbj_Id, int nj_Id, String nbj_Text, String nbj_imgUrl, String nbj_Time, int p_Id,String nbj_placename) {
		super();
		this.nbj_Id = nbj_Id;
		this.nj_Id = nj_Id;
		this.nbj_Text = nbj_Text;
		this.nbj_imgUrl = nbj_imgUrl;
		this.nbj_Time = nbj_Time;
		this.p_Id = p_Id;
		this.nbj_placename=nbj_placename;
	}
	
}

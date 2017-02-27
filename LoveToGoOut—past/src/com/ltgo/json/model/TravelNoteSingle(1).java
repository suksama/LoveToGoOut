package com.ltgo.json.model;


public class TravelNoteSingle {
	private int id;
	private String imageName;
	private String content;
	private String locate;
	private int likeNum;
	private String dateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLocate() {
		return locate;
	}
	public void setLocate(String locate) {
		this.locate = locate;
	}
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public TravelNoteSingle(int id, String imageName, String content, String locate, int likeNum, String dateTime) {
		super();
		this.id = id;
		this.imageName = imageName;
		this.content = content;
		this.locate = locate;
		this.likeNum = likeNum;
		this.dateTime = dateTime;
	}


	
}

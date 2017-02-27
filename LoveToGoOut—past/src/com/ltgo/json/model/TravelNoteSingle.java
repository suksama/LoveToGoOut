package com.ltgo.json.model;

public class TravelNoteSingle {
	private String imageName;
	private String content;
	private String locate;
	private int likeNum;
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
	public TravelNoteSingle(String imageName, String content, String locate, int likeNum) {
		super();
		this.imageName = imageName;
		this.content = content;
		this.locate = locate;
		this.likeNum = likeNum;
	}
	
}

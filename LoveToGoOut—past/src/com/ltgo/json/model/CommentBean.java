package com.ltgo.json.model;

import java.util.ArrayList;
import java.util.List;

public class CommentBean {

	private int id;					//评论记录ID
	private int commentImgId;		//评论人图片索引
	private int commnetAccount;	//评论人账号
	private String commentNickname;	//评论人昵称
	private String commentTime;		//评论时间
	private String commentContent;	//评论内容
	private List<ReplyBean> replyList = new ArrayList<ReplyBean>();
	//回复内容列表
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCommentImgId() {
		return commentImgId;
	}
	public void setCommentImgId(int commentImgId) {
		this.commentImgId = commentImgId;
	}
	public int getCommnetAccount() {
		return commnetAccount;
	}
	public void setCommnetAccount(int commnetAccount) {
		this.commnetAccount = commnetAccount;
	}
	public String getCommentNickname() {
		return commentNickname;
	}
	public void setCommentNickname(String commentNickname) {
		this.commentNickname = commentNickname;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public List<ReplyBean> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<ReplyBean> replyList) {
		this.replyList = replyList;
	}
	public CommentBean(int id, int commnetAccount, String commentNickname, String commentTime, String commentContent) {
		super();
		this.id = id;
		this.commnetAccount = commnetAccount;
		this.commentNickname = commentNickname;
		this.commentTime = commentTime;
		this.commentContent = commentContent;
	}
	
	
}

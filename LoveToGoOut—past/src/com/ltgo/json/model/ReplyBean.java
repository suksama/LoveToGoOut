package com.ltgo.json.model;

public class ReplyBean {

	private int id;					//内容ID
	private int replyAccount;	//回复人账号
	private String replyNickname;	//回复人昵称
	private int commentAccount;	//被回复人账号
	private String commentNickname;	//被回复人昵称
	private String replyContent;	//回复的内容
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReplyAccount() {
		return replyAccount;
	}
	public void setReplyAccount(int replyAccount) {
		this.replyAccount = replyAccount;
	}
	public String getReplyNickname() {
		return replyNickname;
	}
	public void setReplyNickname(String replyNickname) {
		this.replyNickname = replyNickname;
	}
	public int getCommentAccount() {
		return commentAccount;
	}
	public void setCommentAccount(int commentAccount) {
		this.commentAccount = commentAccount;
	}
	public String getCommentNickname() {
		return commentNickname;
	}
	public void setCommentNickname(String commentNickname) {
		this.commentNickname = commentNickname;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public ReplyBean(int replyAccount, String replyNickname, int commentAccount, String commentNickname,
			String replyContent) {
		super();
	
		this.replyAccount = replyAccount;
		this.replyNickname = replyNickname;
		this.commentAccount = commentAccount;
		this.commentNickname = commentNickname;
		this.replyContent = replyContent;
	}
	
}

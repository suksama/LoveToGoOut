package com.ltgo.model;

public class Manager {
	private int id;
	private String account;
	private String password;
	private String sex;
	private String email;
	private String time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public Manager(String account, String password, String sex, String email, String time) {
		super();
		this.account = account;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.time = time;
	}
	public Manager(int id, String account, String password, String sex, String email, String time) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.time = time;
	}

}

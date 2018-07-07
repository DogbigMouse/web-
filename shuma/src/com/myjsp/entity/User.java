package com.myjsp.entity;



public class User  {

	
	private int id;
	private String uName;
	private String uPwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	public User(int id, String uName, String uPwd) {
		super();
		this.id = id;
		this.uName = uName;
		this.uPwd = uPwd;
	}
	public User() {
		super();
	}
	
} 

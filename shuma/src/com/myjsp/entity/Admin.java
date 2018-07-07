package com.myjsp.entity;

/**
 * π‹¿Ì‘±
 * @author 17909
 *
 */
public class Admin {
	private int aId;
	private String adminName;
	private String adminPwd;
	public Admin() {
		super();
	}
	public Admin(int aId, String adminName, String adminPwd) {
		super();
		this.aId = aId;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
}

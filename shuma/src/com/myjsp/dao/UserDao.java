package com.myjsp.dao;

import com.myjsp.entity.User;

public interface UserDao {
	
	
	
	/**
	 * ע��
	 * @param uName
	 * @param uPwd
	 * @return
	 */
	public boolean addUser(User u);
	
	
	/**
	 * ��¼
	 * @param uName
	 * @param uPwd
	 * @return
	 */
	public User getUser(String uName,String uPwd);
}

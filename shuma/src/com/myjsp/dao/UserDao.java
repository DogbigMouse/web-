package com.myjsp.dao;

import com.myjsp.entity.User;

public interface UserDao {
	
	
	
	/**
	 * ×¢²á
	 * @param uName
	 * @param uPwd
	 * @return
	 */
	public boolean addUser(User u);
	
	
	/**
	 * µÇÂ¼
	 * @param uName
	 * @param uPwd
	 * @return
	 */
	public User getUser(String uName,String uPwd);
}

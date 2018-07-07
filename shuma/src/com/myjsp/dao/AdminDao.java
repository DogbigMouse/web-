package com.myjsp.dao;

import com.myjsp.entity.Admin;

/**
 * 管理员接口
 * @author 17909
 *
 */
public interface AdminDao {
	
	
	public Admin login(String name,String pwd);
}

package com.myjsp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.myjsp.dao.UserDao;
import com.myjsp.entity.User;
import com.myjsp.utils.BaseDao;

public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public boolean addUser(User u) {
		String sql="insert  into `vipuser`(`uName`,`uPwd`) values(?,?)";
		return executeUpdate(sql, u.getuName(),u.getuPwd())>0;
	}

	@Override
	public User getUser(String uName, String uPwd) {
		User u = null;
		String sql = "select * from vipUser where uName=? and uPwd=?";
		ResultSet rs = executeQuery(sql, uName,uPwd);
		try {
			if(rs.next()){
				u = new User(rs.getInt("id"), rs.getString("uName"), rs.getString("uPwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				closeAll(rs, rs.getStatement(), rs.getStatement().getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return u;
	}

}

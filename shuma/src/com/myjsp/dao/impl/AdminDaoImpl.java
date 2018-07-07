package com.myjsp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.myjsp.dao.AdminDao;
import com.myjsp.entity.Admin;
import com.myjsp.entity.User;
import com.myjsp.utils.BaseDao;

/**
 *  µœ÷¿‡
 * @author 17909
 *
 */
public class AdminDaoImpl extends BaseDao implements AdminDao{

	@Override
	public Admin login(String name, String pwd) {
		Admin a = null;
		String sql = "select * from admin where adminName=? and adminPwd=?";
		ResultSet rs = executeQuery(sql, name,pwd);
		try {
			if(rs.next()){
				a=new Admin(rs.getInt("aId"), rs.getString("adminName"), rs.getString("adminPwd"));
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
		return a;
	}

}

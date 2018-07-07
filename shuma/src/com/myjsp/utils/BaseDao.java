package com.myjsp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {
	private final String URL="jdbc:mysql://localhost:3306/shuma";
	private final String UNAME = "root";
	private final String UPWD = "root";
	
	/**
	 * 加载驱动
	 */
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取连接
	 * @return
	 */
	public Connection getConn(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, UNAME, UPWD);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}
	/**
	 * 执行增删改
	 * @param sql 要执行的sql语句
	 * @param obj 
	 * @return
	 */
	public int executeUpdate(String sql,Object... obj){
		int result = -1;
		PreparedStatement stmt = null;
		try {
			stmt = getConn().prepareStatement(sql);
			if (obj!=null && obj.length>0) {
				for (int i = 0; i < obj.length; i++) {
					stmt.setObject(i+1, obj[i]);
				}
			}
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll(null, stmt, stmt.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * 执行查询操作
	 * @param sql
	 * @param obj
	 * @return
	 */
	public ResultSet executeQuery(String sql,Object... obj){
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			stmt = getConn().prepareStatement(sql);
			if (obj!=null&&obj.length>0) {
				for (int i = 0; i < obj.length; i++) {
					stmt.setObject(i+1, obj[i]);
				}
			}
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}	
	/**
	 * 关闭操作
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public void closeAll(ResultSet rs,Statement stmt,Connection conn){
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null&&!conn.isClosed()) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}

package com.myjsp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myjsp.dao.BookDao;
import com.myjsp.entity.Book;
import com.myjsp.utils.BaseDao;

public class BookDaoImpl extends BaseDao implements BookDao {

	@Override
	public List<Book> getAllBook(String bookName) {
		List<Book> list = new ArrayList<Book>();
		String sql = "select * from shuma";
		if(bookName!=null&&!bookName.equals("")){
			sql = "select * from shuma where bookName like '%"+bookName+"%'";
		}
		ResultSet rs = executeQuery(sql, null);
		try {
			while(rs.next()){
				Book b = new Book(
					 rs.getInt("bookId"), rs.getString("bookName"), rs.getInt("price"),
					 rs.getString("content"),rs.getString("img"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeAll(rs, rs.getStatement(), rs.getStatement().getConnection());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public boolean deleBook(int bookId) {
		String sql = "delete from shuma where bookId = ?";
		return executeUpdate(sql, bookId)>0;
	
	}

	@Override
	public boolean addBook(Book book) {
		String sql = "insert into shuma(`bookName`,`price`,`content`,`img`) values(?,?,?,?)";
		return executeUpdate(sql, book.getBookName(),book.getPrice(),book.getContent(),book.getImg())>0;
	}

	@Override
	public Book getBookByBookId(int bookId) {
		Book book = null;
		String sql = "select * from shuma where bookId = ?";
		ResultSet rs = executeQuery(sql, bookId);
		try {
			if(rs.next()){
				book = new Book(rs.getInt("bookId"), rs.getString("bookName"), rs.getInt("price"),
						 rs.getString("content"),rs.getString("img"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				closeAll(rs, rs.getStatement(), rs.getStatement().getConnection());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return book;
	}
	@Override
	public boolean updBook(Book book) {
			String sql = "update shuma set bookname=?,price=?,content=?,img=? where bookId = ?";
			return executeUpdate(sql, book.getBookName(),book.getPrice(),book.getContent(),book.getImg(),book.getBookId())>0;
	}

}

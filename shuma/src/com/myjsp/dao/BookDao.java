package com.myjsp.dao;

import java.util.List;

import com.myjsp.entity.Book;


public interface BookDao {
	    
	/**
	 * 查看所有图书信息
	 * @return
	 */
	public List<Book> getAllBook(String bookName);
	
	/**
	 * 根据图书编号删除图书信息
	 * @param bookId
	 * @return
	 */
	public boolean deleBook(int bookId);
	
	/**
	 * 添加书籍信息
	 * @param book
	 * @return
	 */
	public boolean addBook(Book book);
	/**
	 * 根据图书编号获取图书信息
	 * @param bookId
	 * @return
	 */
	public Book getBookByBookId(int bookId);
	/**
	 * 修改图书信息
	 * @param book
	 * @return
	 */
	public boolean updBook(Book book);
	
	
}	

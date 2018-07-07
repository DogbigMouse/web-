package com.myjsp.dao;

import java.util.List;

import com.myjsp.entity.Book;


public interface BookDao {
	    
	/**
	 * �鿴����ͼ����Ϣ
	 * @return
	 */
	public List<Book> getAllBook(String bookName);
	
	/**
	 * ����ͼ����ɾ��ͼ����Ϣ
	 * @param bookId
	 * @return
	 */
	public boolean deleBook(int bookId);
	
	/**
	 * ����鼮��Ϣ
	 * @param book
	 * @return
	 */
	public boolean addBook(Book book);
	/**
	 * ����ͼ���Ż�ȡͼ����Ϣ
	 * @param bookId
	 * @return
	 */
	public Book getBookByBookId(int bookId);
	/**
	 * �޸�ͼ����Ϣ
	 * @param book
	 * @return
	 */
	public boolean updBook(Book book);
	
	
}	

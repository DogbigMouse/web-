package com.myjsp.entity;

public class Book {
	private int bookId;
	private String bookName;
	private int price;
	private String content;
	private String img;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Book(int bookId, String bookName, int price, String content,
			String img) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.content = content;
		this.img = img;
	}
	public Book() {
		super();
	}

	
	
}

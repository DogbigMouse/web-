package com.myjsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myjsp.dao.BookDao;
import com.myjsp.dao.impl.BookDaoImpl;
import com.myjsp.entity.Book;
@WebServlet(urlPatterns="/all.do")
public class SelectServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
	   	//����book����  ��װ��ѯ����
	  	Book book = new Book();
	  	//��װ��ȡ��������
	  	book.setBookName(request.getParameter("bookName"));
		//����װ����������request������
		request.setAttribute("book", book);
		
		BookDao bdao = new BookDaoImpl();
	  	
	  	List<Book> list = bdao.getAllBook(book.getBookName());
		request.setAttribute("list", list);
		request.getRequestDispatcher("book/Book.jsp").forward(request, response);

	}

}

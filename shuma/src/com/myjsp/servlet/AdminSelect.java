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
@WebServlet(urlPatterns="/admin.do")
public class AdminSelect extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//创建book对象  封装查询条件
	  	Book book = new Book();
	  	//封装获取到的条件
	  	book.setBookName(request.getParameter("bookName"));
		//将封装的条件给到request对象中
		request.setAttribute("book", book);
		
		BookDao bdao = new BookDaoImpl();
	  	
	  	List<Book> list = bdao.getAllBook(book.getBookName());
		request.setAttribute("list", list);
		request.getRequestDispatcher("book/Admin.jsp").forward(request, response);
	}

}

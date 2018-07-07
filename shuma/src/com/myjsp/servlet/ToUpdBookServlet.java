
package com.myjsp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myjsp.dao.BookDao;
import com.myjsp.dao.impl.BookDaoImpl;
import com.myjsp.entity.Book;
@WebServlet(urlPatterns="/toupdbook.do")
public class ToUpdBookServlet extends HttpServlet {
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
		request.setCharacterEncoding("UTF-8");
  		int bookId = Integer.parseInt(request.getParameter("bookId"));
  		//创建底层对象
  		BookDao bdao = new BookDaoImpl();
  		//根据编号获取要修改的图书信息
  		Book book = bdao.getBookByBookId(bookId);
  		request.setAttribute("book", book);
  		request.getRequestDispatcher("book/updBook.jsp").forward(request, response);
	}

}

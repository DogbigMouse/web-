package com.myjsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myjsp.dao.BookDao;
import com.myjsp.dao.impl.BookDaoImpl;
@WebServlet(urlPatterns="/delbook.do")
public class DelBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		int bookId =Integer.parseInt( request.getParameter("bookId"));
		
			BookDao bdao = new BookDaoImpl();
			boolean flag =  bdao.deleBook(bookId);
			if(flag){
				out.print("<script type='text/javascript'>alert('É¾³ý³É¹¦');location.href='admin.do'; </script>");
			}else{
				out.print("<script type='text/javascript'>alert('É¾³ýÊ§°Ü');location.href='admin.do';</script>");
			}
		
	}

}

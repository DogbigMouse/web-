package com.myjsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.myjsp.dao.UserDao;
import com.myjsp.dao.impl.UserDaoImpl;
import com.myjsp.entity.User;
@WebServlet(urlPatterns="/login.do")
public class Login extends HttpServlet {

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
		String uName = request.getParameter("name");
		String uPwd = request.getParameter("pwd");
		
		
		UserDao udao = new UserDaoImpl();
		
		
		User user = udao.getUser(uName, uPwd);
		if(user!=null){
			out.print("<script type='text/javascript'>alert('µÇÂ¼³É¹¦');location.href='all.do';</script>");
		}else{
			out.print("<script type='text/javascript'>alert('µÇÂ¼Ê§°Ü');location.href='Login.jsp';</script>");
		}
		
	}

}

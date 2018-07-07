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
@WebServlet(urlPatterns="/zhuce.do")
public class ZhuCe extends HttpServlet {

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
		
		User u = new User(-1, uName, uPwd);
		
		UserDao udao = new UserDaoImpl();
		
		boolean flag = udao.addUser(u);
		if(flag){
			out.print("<script type='text/javascript'>alert('×¢²á³É¹¦');location.href='Login.jsp';</script>");
		}else{
			out.print("<script type='text/javascript'>alert('×¢²áÊ§°Ü');location.href='Register.jsp';</script>");
		}
		
	}

}

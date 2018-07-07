package com.myjsp.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.myjsp.dao.BookDao;
import com.myjsp.dao.impl.BookDaoImpl;
import com.myjsp.entity.Book;
import com.myjsp.utils.stringutils;
@WebServlet(urlPatterns="/addbook.do")
public class AddBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//创建上传对象
		SmartUpload su = new SmartUpload();
		//设置编码
		su.setCharset("UTF-8");
		//执行初始化操作
		su.initialize(this,request,response);
		//实现上传
		try {
			su.upload();
		} catch (SmartUploadException e1) {
			e1.printStackTrace();
		}
		
		//创建SmartUpload的Request对象
		Request rq = su.getRequest();
		//获取用户提交的信息
		String bookName = rq.getParameter("bookName");
		int price = Integer.parseInt(rq.getParameter("price"));
		String content = rq.getParameter("desc");
		
		
		//获取用户提交的信息
		File f = su.getFiles().getFile(0);
		String img = stringutils.geneFileNameByExtName(f.getFileExt());
		//永久提交
		try {
			f.saveAs("/img/"+img,f.SAVEAS_VIRTUAL);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		img = "img/"+img;
		Book book = new Book(-1, bookName,price,content,img);
		//创建底层对象，调用方法添加
		BookDao bdao = new BookDaoImpl();
		boolean flag = bdao.addBook(book);
		if(flag){
			response.sendRedirect(request.getContextPath()+"/admin.do");
		}else{
			response.sendRedirect(request.getContextPath()+"/book/Add.jsp");
		}

	}

}

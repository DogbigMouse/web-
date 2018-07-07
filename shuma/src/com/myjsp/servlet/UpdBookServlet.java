package com.myjsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet(urlPatterns="/updbook.do")
public class UpdBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			SmartUpload su = new SmartUpload();
			su.setCharset("UTF-8");
			su.initialize(this,request,response);
			try {
				su.upload();
			} catch (SmartUploadException e1) {
				e1.printStackTrace();
			}
			Request rq = su.getRequest();

			BookDao bdao = new BookDaoImpl();
			int bookId = Integer.parseInt(rq.getParameter("bookId"));
			String bookName = rq.getParameter("bookName");
			int price = Integer.parseInt(rq.getParameter("price"));
			String content = rq.getParameter("desc");
			
			File f = su.getFiles().getFile(0);
			String img = null;
				if(!f.isMissing()){
					img =stringutils.geneFileNameByExtName(f.getFileExt());
					try {
						f.saveAs("/img/"+img, f.SAVEAS_VIRTUAL);
					} catch (SmartUploadException e) {
						e.printStackTrace();
					}
					img = "img/"+img;
				}
			
			Book book = new Book(bookId, bookName,price,content,img);

			boolean flag = bdao.updBook(book);

			if(flag){
				out.print("<script type='text/javascript'>alert('修改成功'); </script>");
				response.sendRedirect(request.getContextPath()+"/admin.do");
			}else{
				out.print("<script type='text/javascript'>alert('修改失败'); </script>");
				response.sendRedirect(request.getContextPath()+"/toupdbook.do");
			}
		} catch (Exception e) {
			out.print("<script type='text/javascript'>alert('修改失败'); </script>");
			response.sendRedirect(request.getContextPath()+"/toupdbook.do");
		}
		
		

	}

}

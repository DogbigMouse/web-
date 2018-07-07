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

		//�����ϴ�����
		SmartUpload su = new SmartUpload();
		//���ñ���
		su.setCharset("UTF-8");
		//ִ�г�ʼ������
		su.initialize(this,request,response);
		//ʵ���ϴ�
		try {
			su.upload();
		} catch (SmartUploadException e1) {
			e1.printStackTrace();
		}
		
		//����SmartUpload��Request����
		Request rq = su.getRequest();
		//��ȡ�û��ύ����Ϣ
		String bookName = rq.getParameter("bookName");
		int price = Integer.parseInt(rq.getParameter("price"));
		String content = rq.getParameter("desc");
		
		
		//��ȡ�û��ύ����Ϣ
		File f = su.getFiles().getFile(0);
		String img = stringutils.geneFileNameByExtName(f.getFileExt());
		//�����ύ
		try {
			f.saveAs("/img/"+img,f.SAVEAS_VIRTUAL);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		img = "img/"+img;
		Book book = new Book(-1, bookName,price,content,img);
		//�����ײ���󣬵��÷������
		BookDao bdao = new BookDaoImpl();
		boolean flag = bdao.addBook(book);
		if(flag){
			response.sendRedirect(request.getContextPath()+"/admin.do");
		}else{
			response.sendRedirect(request.getContextPath()+"/book/Add.jsp");
		}

	}

}

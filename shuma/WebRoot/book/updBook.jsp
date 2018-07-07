<%@page import="com.myjsp.entity.Book"%>
<%@page import="com.myjsp.dao.impl.BookDaoImpl"%>
<%@page import="com.myjsp.dao.BookDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updBook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		img{width:150px;height: 200px;}
	</style>
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
  </head>
  
  <body>

  
       	<form action="updbook.do" enctype="multipart/form-data" method="post" >
       	<input type="hidden" name="bookId" value="${book.bookId}"/>
	   	<p><label>名称：</label><input type="text" name="bookName" value="${book.bookName}" /> </p>
	   	<p><label>价格：</label><input type="text" name="price" value="${book.price}" /> </p>
	   	<p><label>图片：</label>
   		<input type="file" name="image" onchange="PreviewImage(this)"/>
	   	</p>
	   	<p><label>描述：</label>
	   		<textarea rows="5" cols="20" name="desc">${book.content}</textarea>
	   	</p>
	   	<p><input type="submit" value="修改">
	   	</p>
   	</form>
   		<div id="imgPreview">
   		<img src="${book.img}" />
    </div>
  </body>
   <script type="text/javascript"> 
   function PreviewImage(imgFile) 
   { 
    var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;      
    if(!pattern.test(imgFile.value)) 
    { 
     alert("系统仅支持jpg/jpeg/png/gif/bmp格式的照片！");  
     imgFile.focus(); 
    } 
    else 
    { 
     var path; 
     if(document.all)//IE 
     { 
      imgFile.select(); 
      path = document.selection.createRange().text; 
     } 
     else//FF 
     { 
      path = URL.createObjectURL(imgFile.files[0]);
       
     } 
	 document.getElementById("imgPreview").innerHTML = "<img src='"+path+"'/>";
    } 
   } 
  </script>
  
</html>

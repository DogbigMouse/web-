<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddBook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		img{width:200px;height: 200px;}
		form{width:700px;margin: 0 auto;
	</style>
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
  </head>
  
  <body>
   	<form action="addbook.do" enctype="multipart/form-data" method="post" >
   		<h1>添加</h1>
	   	<p><label>名称：</label><input type="text" name="bookName" /> </p>
	   	<p><label>价格：</label><input type="text" name="price" /> </p>
	   	<p><label>图片：</label>
	   	<input type="file"  name="image" multiple onchange="PreviewImage(this)"/></p>
	   	<p><label>简介：</label>
	   		<textarea rows="5" cols="20" name="desc"></textarea>
	   	</p>
	   	<p><input type="submit" value="添加"><input type="reset" value="清空">
	   	</p>
	   	<div id="imgPreview">
    </div>
   	</form>
   	
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
    	 var count = imgFile.files.length;
    	 for(var i=0;i<count;i++){
    		 path = URL.createObjectURL(imgFile.files[i]);
    		 document.getElementById("imgPreview").innerHTML += "<img src='"+path+"'/>";
    	 }
      	return;
     } 
	 document.getElementById("imgPreview").innerHTML = "<img src='"+path+"'/>";
    } 
   } 
  </script>
</html>

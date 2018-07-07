<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BookInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	
		div{width: 300px;margin: 0 auto}
		.shu{width: 20px;text-align: center;}
		img{width: 160px;height: 160px;}
	</style>
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
  </head>
  
  <body>
    <div>
    
    <h2>数码详情信息</h2>
    	<a href="all.do">返回主页面</a>
    	 <div class="content">
		 	<img src="${b.img }" alt="">
		  	<p>数码编号：${b.bookId } </p>
		  	<p>数码名称：${b.bookName } </p>
		  	<p>价格：${b.price } </p>
		  	<p>描述：${b.content }</p>
  		</div>
    </div>
  </body>
</html>

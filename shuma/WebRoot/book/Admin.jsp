<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Admin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/book.css">
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>

  </head>
  
  <body>
     <form action="admin.do" method="post">
	  	<p><label>书籍名称：</label><input type="text" value="${book.bookName }" name="bookName"  /> </p>
	  	<p><input type="submit" name="sousuo" value="搜索"/></p>
	  	<div><a href="book/Add.jsp">添加</a></div>
	  	<p> <a href="Login.jsp">返回登录界面</a> </p>
   	</form>
		 <c:forEach items="${requestScope.list }" var="b">
		 <div class="content">
		 	<img src="${b.img }" alt="">
		  	<p>编号：${b.bookId } </p>
		  	<p>名称：${b.bookName } </p>
		  	<p>价格：${b.price } </p>
		  	<p>描述：${b.content }</p>
		  	<p><a href="delbook.do?bookId=${b.bookId }">删除</a>
		  	<a href="toupdbook.do?bookId=${b.bookId }">修改</a>
		  	</p>
  		</div>
  		</c:forEach>

	
  </body>
</html>

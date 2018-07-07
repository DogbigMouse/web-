<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		*{margin: 0;padding: 0}
		h3{margin: 0 auto;width: 120px;margin-bottom: 30px;}
		div{width:300px;margin: 0 auto;margin-top: 200px;}
		p{margin-bottom: 10px;}
		.denglu{margin: 5px 60px;}
	</style>
	<script type="text/javascript"src="js/jquery-1.12.4.js"></script>

  </head>
  
  <body>
	<div>
    	<h3>注册</h3>
    	<form action="zhuce.do" method="post">
    		<p><label>用  户  名:</label> <input type="text"  name="name" /> </p>
    		<p><label>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label> <input type="password"  name="pwd" /> </p>
    		<p><label>确认密码:</label> <input type="password"  name="repwd" /> </p>
    		
    		<input type="submit" class="denglu" value="注册" /><input type="submit" value="已有账号，返回登录" />
    	</form>
    
    </div>
  </body>
   <script type="text/javascript">
  

  		//页面加载
  		$(function(){
  			
  			//点击登录按钮要执行的函数
  			$("[value='注册']").click(function(){
  				//接受用户填写的信息  如果为空则提示用户
  				var name = $("[name='name']").val();
  				var pwd = $("[name='pwd']").val();
  				var repwd = $("[name='repwd']").val();
				if(name==""){
					alert("用户名不能为空！请填写！");
					return false;
				}
	  			if(pwd==""){
					alert("密码不能为空！请填写！");
					return false;
				}
	  			if(repwd==""){
					alert("请再次确认密码");
					return false;
				}
				//判断两次输入的密码是否一样
				if(pwd!=repwd){
					alert("两次密码不一样！请重新输入！");
					return false;
				}
				return true;
  			});
  			
  			$("[value='已有账号，返回登录']").click(function(){
  				$("form").attr("action","Login.jsp");
  			});
  			
  		});
  
  </script>
  
</html>

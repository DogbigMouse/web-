<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
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
    	<h3>登录</h3>
    	<form action="" method="post">
    		<p><label>用户名:</label> <input type="text"  name="name" /> </p>
    		<p><label>密&nbsp;&nbsp;&nbsp;&nbsp;码:</label> <input type="password"  name="pwd" /> </p>
    		<p><label>登录类型:</label> 
				<select name="xuan">
					<option value="请选择">请选择</option>
					<option value="管理员">管理员</option>
					<option value="学员">普通用户</option>
				</select>
			</p>
    		
    		<input type="submit" class="denglu" value="登录" /><input type="submit" value="注册" />
    	</form>
    
    </div>
  </body>
  <script type="text/javascript">
  
  		
  		//页面加载
  		$(function(){
  			//点击登录按钮要执行的函数
  			$("[value='登录']").click(function(){
  				//接受用户填写的信息  如果为空则提示用户
  				var name = $("[name='name']").val();
  				var pwd = $("[name='pwd']").val();
  				var xuan = $("[name='xuan']").val();
				if(name==""){
					alert("用户名不能为空！请填写！");
					return false;
				}
	  			if(pwd==""){
					alert("密码不能为空！请填写！");
					return false;
				}
				if(xuan=="请选择"){
					alert("请选择登录类型！");
					return false;
				}
  				var xuan = $("[name='xuan']").val();
  				if(xuan=="管理员"){ //选择的是管理员   则跳到管理员页面
  					$("form").attr("action","adminlogin.do");
  				}else{   // 跳到普通用户页面
  					$("form").attr("action","login.do");
  				};
  			});
  			//点击注册按钮
  			$("[value='注册']").click(function(){
  				$("form").attr("action","Register.jsp");
  			});
  			
  		});
  
  </script>
</html>

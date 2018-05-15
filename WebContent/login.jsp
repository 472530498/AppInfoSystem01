<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    <link href="<%=basePath %>/statics/css/login.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript"  src="<%=basePath %>/statics/js/register.js"></script>
    <script language="javascript" type="text/javascript">
function checkData() {
	var userid = window.form1.sUserId.value;
	var passwd = window.form1.sPasswd.value;

	if (userid.replace(/(^\s*)|(\s*$)/g, '') == "") {
		window.alert("用户ID不能为空！");
		window.form1.userId.focus();
		return false;
	}

	if (passwd.replace(/(^\s*)|(\s*$)/g, '') == "") {
		window.alert("用户密码不能为空！");
		window.form1.passwd.focus();
		return false;
	}
	return true;
}</script>
  </head>
  
  <body>
    <div id="login">   
        <h1>Login</h1>
        <form method="post" action="<%=basePath %>loginServlet" id="form1">   
            <li>用户ID:<input type="text"  name="sUserId" id="sUserId" class="inputttext" ></input> </li>  
            <li>密码:<input type="text"  name="sPasswd" id="passwd" class="inputttext"></input> </li> 
              
            <button class="but" type="submit" name="login" onmousedown="checkData()">登录</button>  
            <button class="put" type="submit" name="register" onmousedown="zhuce()">注册</button>
        </form>   
    </div>   

  </body>
</html>

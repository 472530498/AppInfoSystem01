<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="form1" action="${pageContext.request.contextPath}/user/dologin" method="post">
        <p>用户名：<input name="userName" type="text"/></p>
        <p>密　码：<input name="password" type="password"/></p>
        <p><input type="submit" value="登录">&nbsp;<input type="reset" value="重置"></p>
    </form>
   	
</body>
</html>
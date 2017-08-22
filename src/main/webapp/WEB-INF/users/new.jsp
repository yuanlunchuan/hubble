<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String baseUrl = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
新增用户
<form action="${pageContext.request.contextPath}/users" method="post">
  用户名：<input name="username" type="text"><br>
  昵称：<input name="nickName" type="text"><br>
  年龄：<input name="age" type="text"><br>
  密码：<input name="password" type="text"><br>
  <button type="submit">提交</button>
</form>
</body>
</html>

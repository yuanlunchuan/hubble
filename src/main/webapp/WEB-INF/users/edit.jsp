<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑用户</title>
</head>
<body>
<h1>编辑用户</h1>
<form action="${pageContext.request.contextPath}/users/${user.id}/update" method="post">
  用户名：<input name="username" type="text" value="${user.username }"><br>
  密码：<input name="password" type="text" value="${user.password }"><br>
  <button type="submit">提交</button>
</form>
</body>
</html>

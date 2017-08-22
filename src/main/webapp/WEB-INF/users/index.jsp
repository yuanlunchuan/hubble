<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String baseUrl = request.getContextPath(); %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
 table td{border:1px solid grey} 
</style>
<title>用户列表</title>
</head>
<body>
  <h1>用户列表</h1>
  <a href="users/new">新增用户</a>
  <hr>

  <form action="<%=baseUrl %>/users" method="GET">
          关键字:<input name="keyword" type="text" value="${param.keyword }" placeholder="请输入名字或昵称">
          年龄:<input name="age" type="text" value="${param.age }">
    <button type="submit">查询</button>
  </form>
  <hr>

  <table width="400" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td>序号</td>
      <td>用户名</td>
      <td>密码</td>
      <td>昵称</td>
      <td>年龄</td>
      <td>操作</td>
    </tr>
    <c:forEach var="user" items="${collection.content}" varStatus="status">
	  <tr>
	    <td>${status.index+1}</td>
	    <td>${user.username }</td>
	    <td>${user.password }</td>
	    <td>${user.nickName }</td>
	    <td>${user.age }</td>
	    <td><a href="<%=baseUrl %>/users/${user.id}/edit">编辑</a>
	    /<a href="<%=baseUrl %>/users/${user.id}/delete">删除</a></td>
	  </tr>
    </c:forEach>
  </table>
</body>
</html>
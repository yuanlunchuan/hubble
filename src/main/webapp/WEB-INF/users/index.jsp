<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String baseUrl = request.getContextPath(); %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<!-- Bootstrap -->
<link href="<%=baseUrl %>/static/lib/bootstrap/dist/css/bootstraptheam.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/hubble/users">云接口</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="/hubble/users">用户列表</a></li>
        <li><a href="users/new">新增用户</a></li>
      </ul>

      <form action="<%=baseUrl %>/users" method="GET" class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input name="keyword" type="text" value="${param.keyword }" placeholder="请输入名字或昵称">
          <input name="age" type="text" placeholder="年龄" value="${param.age }">
        </div>
        <button type="submit" class="btn btn-default btn-sm">搜索</button>
      </form>
    </div>
  </div>
</nav>

<div class="container">
  <table class="table table-striped table-hover ">
  <thead>
    <tr>
      <td>序号</td>
      <td>用户名</td>
      <td>密码</td>
      <td>昵称</td>
      <td>年龄</td>
      <td>操作</td>
    </tr>
  </thead>
  <tbody>
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
  </tbody>
</table>
<ul class="pagination">
  <li class="disabled"><a href="#">&laquo;</a></li>
  <li class="active"><a href="#">1</a></li>
  <li><a href="#">2</a></li>
  <li><a href="#">3</a></li>
  <li><a href="#">4</a></li>
  <li><a href="#">5</a></li>
  <li><a href="#">&raquo;</a></li>
</ul> 
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<%=baseUrl %>/static/lib/jquery/dist/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=baseUrl %>/static/lib/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>
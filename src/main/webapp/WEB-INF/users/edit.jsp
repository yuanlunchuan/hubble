<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String baseUrl = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
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
<div class="row">
<form class="form-horizontal" action="${pageContext.request.contextPath}/users/${user.id}/update" method="post">
  <fieldset>
    <legend>新增用户</legend>
    <div class="form-group">
      <label class="col-lg-2 control-label">用户名</label>
      <div class="col-lg-10">
        <input class="form-control" type="text" name="username" value="${user.username }">
      </div>
    </div>
    <div class="form-group">
      <label class="col-lg-2 control-label">昵称</label>
      <div class="col-lg-10">
        <input class="form-control" name="nickName" type="text" value="${user.nickName }">
      </div>
    </div>
    <div class="form-group">
      <label class="col-lg-2 control-label">年龄</label>
      <div class="col-lg-10">
        <input class="form-control" name="age" type="text" value="${user.age }">
      </div>
    </div>
    <div class="form-group">
      <label class="col-lg-2 control-label">密码</label>
      <div class="col-lg-10">
        <input class="form-control" name="password" type="text" value="${user.password }">
      </div>
    </div>
    <div class="form-group">
      <div class="col-lg-10 col-lg-offset-2">
        <button type="reset" class="btn btn-default">取消</button>
        <button type="submit" class="btn btn-primary">提交</button>
      </div>
    </div>
  </fieldset>
  </div>
</form>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<%=baseUrl %>/static/lib/jquery/dist/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=baseUrl %>/static/lib/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>管理中心</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<%@include file="../admin_shared/css.jsp"%>
<div class="wrapper">
  <%@include file="../admin_shared/header.jsp"%>
  <%@include file="../admin_shared/left_aside.jsp"%>

  <div class="content-wrapper">
    <section class="content-header">
      <h1>消息管理</h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
      </ol>
    </section>

    <section class="content">
      <div class="row">
        <div class="col-md-12">
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">新增消息</h3>
            </div>
            <!-- form start -->
            <form role="form" method="post" action="<c:url value='/admin/messages'/>">
              <div class="box-body">
                <div class="form-group">
                  <label>标题</label>
                  <input type="text" name="title" class="form-control" placeholder="标题">
                </div>
                <div class="form-group">
                  <label>级别</label>
                  <select class="form-control">
                    <option>一级</option>
                    <option>二级</option>
                    <option>三级</option>
                    <option>四级</option>
                  </select>
                </div>
                <div class="form-group">
                  <label>内容</label>
                  <textarea class="form-control" rows="5" name="content" placeholder="内容 ..."></textarea>
                </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button type="submit" class="btn btn-primary">提交</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
  </div>

  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      Anything you want
    </div>
    <strong>Copyright &copy; 2017 <a href="#">Company</a>.</strong> All rights reserved.
  </footer>

  <%@include file="../admin_shared/control_aside.jsp"%>
  <div class="control-sidebar-bg"></div>
</div>
<%@include file="../admin_shared/js.jsp"%>
</body>
</html>

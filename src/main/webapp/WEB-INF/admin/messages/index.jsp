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
      <h1>
        消息管理
        <small>消息列表</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
      </ol>
    </section>

    <section class="content">
      <div class="row">
        <div class="col-md-12">
          <div class="box">
            <div class="box-header with-border">
              <h3 class="box-title">消息列表</h3>
              <div class="box-tools">
                <a href="<c:url value='/admin/messages/new'/>" class="btn btn-box-tool pull-right"><i class="fa fa-plus"></i></a>
                <div class="input-group input-group-sm" style="width: 150px;">
                  <input type="text" name="table_search" class="form-control pull-right" placeholder="关键字...">
                  <div class="input-group-btn">
                    <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                  </div>
                </div>
              </div>
            </div>
          <table class="table table-hover">
            <tr>
              <td>id</td>
              <td>标题</td>
              <td>内容</td>
              <td>操作</td>
            </tr>
            <c:forEach var="message" items="${messages}">
              <tr>
                <td>${message.id}</td>
                <td>${message.title}</td>
                <td>${message.content}</td>
                <td>
                  <a href="<c:url value='/admin/messages/${message.id}/edit'/>" class="btn btn-primary"><i class="fa fa-edit"></i>编辑</a>
                  <a href="" class="btn btn-danger"><i class="fa fa-remove"></i>删除</a>
                </td>
              </tr>
            </c:forEach>
          </table>
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

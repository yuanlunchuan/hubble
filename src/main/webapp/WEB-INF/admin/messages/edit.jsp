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
<c:import url="../admin_shared/css.jsp"></c:import>
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
          <c:import url="_form.jsp">
            <c:param name="method" value="PUT"/>
            <c:param name="url">
              <c:url value='/admin/messages'/>
            </c:param>
          </c:import>
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String baseUrl = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <title>登录</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="${pageContext.request.contextPath}/static/custom/css/sessions_new.css" rel="stylesheet">
</head>
<body>
 <%@include file="../client_shared/shared_css.jsp" %>
 <%@include file="../client_shared/nav.jsp" %>
 
 <div class="container-fluid content">
   <div class="row">
	  <c:if test="${not empty errorMessage }">
	    <div class="alert alert-info alert-dismissible" role="alert">
	      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	      <strong>温馨提示!</strong>${errorMessage }
	    </div>
	   </c:if>
     <div class="col-md-4 col-md-offset-4">
       <div class="dailog-container">
		<form class="form-horizontal login-form" action="${pageContext.request.contextPath}/sessions" method="POST">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">Email</label>
		    <div class="col-sm-8">
		      <input type="email" class="form-control" name="email" value="799652013@qq.com">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">密码</label>
		    <div class="col-sm-8">
		      <input type="password" class="form-control" name="password" value="1">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-1 col-sm-6">
		      <div class="checkbox">
		        <label>
		          <input type="checkbox">记住我
		        </label>
		      </div>
		    </div>
		    <div class="col-sm-4">
		      <a href="">忘记密码</a>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="text-center">
		      <button type="submit" class="btn btn-default btn-lg"><span class="submit-button">登录</span></button>
		    </div>
		  </div>
		</form>
		
		<div class="line"></div>
		
		<div class="text-center">
		  <h5>没有帐号？<a href="${pageContext.request.contextPath}/register/new">立即注册</a> </h5>
		</div>
       </div>
     </div>
   </div>
 </div>

 <!-- <%@include file="../client_shared/_footer.jsp" %>  --> 
 <%@include file="../client_shared/js.jsp" %>
</body>
</html>

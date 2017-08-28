<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String baseUrl = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
  <title>用户注册</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="${pageContext.request.contextPath}/static/custom/css/register_new.css" rel="stylesheet">
</head>
<body>
 <%@include file="../client_shared/shared_css.jsp" %>
 <%@include file="../client_shared/nav.jsp" %>
 <div class="container content">
   <div class="row">
     <div class="col-md-5 col-md-offset-3">
		<form class="form-horizontal">
		  <div class="form-group">
		    <label class="col-md-3 control-label">email<span class="red-color">*</span></label>
		    <div class="col-md-9">
		      <input type="email" class="form-control">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-3 control-label">设置密码<span class="red-color">*</span></label>
		    <div class="col-md-9">
		      <input type="password" class="form-control">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-3 control-label">确认密码<span class="red-color">*</span></label>
		    <div class="col-sm-9">
		      <input type="password" class="form-control">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-3 control-label">验证码<span class="red-color">*</span></label>
		    <div class="col-md-4">
		      <input type="text" class="form-control">
		    </div>
		    <div id="yanzhengmaContainer"></div>
		    <span>换一张</span>
		  </div>
		  <div class="form-group">
		    <div class="col-md-10 col-md-offset-2">
		      <button type="submit" class="submit-button">注册</button>
		    </div>
		  </div>
		</form>
     </div>
   </div>
 </div>
 <%@include file="../client_shared/_footer.jsp" %>
 <%@include file="../client_shared/js.jsp" %>
 <script src="${pageContext.request.contextPath}/static/lib/yanzhengma/gVerify.js"></script>
 <script src="${pageContext.request.contextPath}/static/custom/js/register.js"></script>
</body>
</html>

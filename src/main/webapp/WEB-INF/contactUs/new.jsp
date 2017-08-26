<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String baseUrl = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
  <title>联系我们</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="${pageContext.request.contextPath}/static/custom/css/contact_us_new.css" rel="stylesheet">
</head>
<body>
 <%@include file="../client_shared/shared_css.jsp" %>
 <%@include file="../client_shared/nav.jsp" %>

 <div class="container content">
   <div class="row">
     <div class="col-md-12 text-center title-container">
       <h1>联系我们</h1>
     </div>
   </div>

   <div class="row border padding-top-5">
     <div class="col-md-6">
      <form class="form-horizontal">
	    <div class="form-group">
	      <label class="col-sm-2 control-label">Email<span class="red-text">*</span></label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control">
	      </div>
	    </div>

	    <div class="form-group">
	      <label class="col-sm-2 control-label">电话<span class="red-text">*</span></label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="col-sm-2 control-label">主题<span class="red-text">*</span></label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="col-sm-2 control-label">内容<span class="red-text">*</span></label>
	      <div class="col-sm-10">
	      <textarea class="form-control" rows="3"></textarea>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="submit-button">提交</button>
	    </div>
	  </div>
	</form>
     </div>

     <div class="col-md-6">
       <h3 style="margin-top: -5px;">联系我们</h3>
       <h4 class="orange">邮件:</h4>
       <p>799652013@qq.com</p>
       <h4 class="orange">公众号:</h4>
       <img width="150px" class="img-responsive" src="${pageContext.request.contextPath}/static/custom/image/qr_code.jpg">
     </div>
   </div>
 </div>

 <%@include file="../client_shared/_footer.jsp" %>
 <%@include file="../client_shared/js.jsp" %>
</body>
</html>

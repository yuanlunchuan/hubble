<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String baseUrl = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
  <title>联系我们</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="${pageContext.request.contextPath}/static/custom/css/about_us_show.css" rel="stylesheet">
</head>
<body>
 <%@include file="../client_shared/shared_css.jsp" %>
 <%@include file="../client_shared/nav.jsp" %>

 <div class="container content">
   <div class="row">
     <div class="col-md-12 text-center">
       <h1 class="title">我们专注web接口管理</h1>
       <p class="desc">专注接口管理，灵活的配置，快速访问</p>
     </div>
     <div class="col-md-12 text-center">
       <button class="praise-button">为我点赞</button>
     </div>
   </div>

   <div class="row total-container">
     <div class="col-md-3 text-center">
       <h2>2806</h2>
       <p>接口数量</p>
     </div>
     <div class="col-md-3 text-center">
       <h2>1540</h2>
       <p>用户数量</p>
     </div>
     <div class="col-md-3 text-center">
       <h2>5</h2>
       <p>团队数量</p>
     </div>
     <div class="col-md-3 text-center">
       <h2>2903</h2>
       <p>点赞</p>
     </div>
   </div>
 </div>

<div class="container team-intro">
   <div class="row">
     <div class="col-md-5 line"></div>
     <div class="col-md-2 text-center team-title">我们的团队</div>
     <div class="col-md-5 line"></div>
   </div>
   <div class="row">
     <div class="col-md-3">
       <img src="${pageContext.request.contextPath}/static/custom/image/yuan_icon.png" class="img-responsive">
     </div>
     <div class="col-md-8">
       <h2>东方先生</h2>
      <div>
          <a href="https://user.qzone.qq.com/799652013/infocenter" title="微博"><span class="space"><i class="fa fa-weibo"></i></span></a>
          <a href="mailto:open@799652013@qq.com" title="商务合作"><span class="space"><i class="fa fa-envelope-o"></i></span></a>
      </div>
       <h4>团队核心</h4>
       <p>这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述</p>
     </div>
   </div>
   <div class="row">
     <div class="line"></div>
   </div>
   <div class="row">
     <div class="col-md-8 text-right">
       <h2>程序猿大叔</h2>
      <div>
          <a href="https://user.qzone.qq.com/799652013/infocenter" title="微博"><span class="space"><i class="fa fa-weibo"></i></span></a>
          <a href="mailto:open@799652013@qq.com" title="商务合作"><span class="space"><i class="fa fa-envelope-o"></i></span></a>
      </div>
       <h4>团队核心</h4>
       <p>这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述这里是描述</p>
     </div>
     <div class="col-md-3">
       <img src="${pageContext.request.contextPath}/static/custom/image/yu_icon.png" class="img-responsive">
     </div>
   </div>
</div>
 <%@include file="../client_shared/_footer.jsp" %>
 <%@include file="../client_shared/js.jsp" %>
</body>
</html>

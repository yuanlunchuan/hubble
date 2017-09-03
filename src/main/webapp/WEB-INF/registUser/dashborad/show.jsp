<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员中心</title>
</head>
<body>
 <%@include file="../regist_user_shared/css.jsp" %>
 <%@include file="../regist_user_shared/nav.jsp" %>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/registUser/css/dashborad.css">
 
 <div class="container content">
   <div class="row">
     <div class="col-md-3 margin-left-3">
       <div class="row text-center">
         <div class="col-md-5 blue">
           <h1><i class="fa fa-comments" aria-hidden="true"></i></h1>
         </div>
         <div class="col-md-7 text-container">
           <h3>102</h3>
           <h4>消息</h4>
         </div>
       </div>
     </div>
     <div class="col-md-3 margin-left-3">
       <div class="row text-center">
         <div class="col-md-5 blue">
           <h1><i class="fa fa-comments" aria-hidden="true"></i></h1>
         </div>
         <div class="col-md-7 text-container">
           <h3>2017-8-30</h3>
           <h4>上次登录时间</h4>
         </div>
       </div>
     </div>
     <div class="col-md-3">
       <div class="row text-center">
         <div class="col-md-5 blue">
           <h1><i class="fa fa-comments" aria-hidden="true"></i></h1>
         </div>
         <div class="col-md-7 text-container">
           <h3>127</h3>
           <h4>接口总数</h4>
         </div>
       </div>
     </div>
     <div class="col-md-3">
       <div class="row text-center">
         <div class="col-md-5 blue">
           <h1><i class="fa fa-comments" aria-hidden="true"></i></h1>
         </div>
         <div class="col-md-7 text-container">
           <h3>127</h3>
           <h4>项目总数</h4>
         </div>
       </div>
     </div>
   </div>
 </div>
 
 <%@include file="../regist_user_shared/footer.jsp" %>
 <%@include file="../regist_user_shared/js.jsp" %>
</body>
</html>

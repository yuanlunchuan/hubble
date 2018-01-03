<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增接口</title>
<link href="${pageContext.request.contextPath}/static/registUser/css/interface_new.css" rel="stylesheet">
</head>
<body>
 <%@include file="../regist_user_shared/css.jsp" %>
 <%@include file="../regist_user_shared/nav.jsp" %>

 <div class="container content">
   <div class="row">
     <div class="col-md-8 col-md-offset-2">
       <ol class="breadcrumb">
         <li><a href="${pageContext.request.contextPath}/registUser/projects">项目管理</a></li>
         <li><a href="${pageContext.request.contextPath}/registUser/projects/1">接口列表</a></li>
         <li class="active">新增接口</li>
       </ol>     
     </div>
   </div>
   <%@include file="_form.jsp" %>

 </div>
 <%@include file="../regist_user_shared/footer.jsp" %>
 <%@include file="../regist_user_shared/js.jsp" %>
 <script src="${pageContext.request.contextPath}/static/registUser/js/interface_new.js"></script>
</body>
</html>

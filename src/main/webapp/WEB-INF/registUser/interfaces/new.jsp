<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
     <div class="col-md-12">
       <ol class="breadcrumb">
         <li><a href="${pageContext.request.contextPath}/registUser/projects">项目管理</a></li>
         <li><a href="${pageContext.request.contextPath}/registUser/projects/1">接口列表</a></li>
         <li class="active">新增接口</li>
       </ol>
     </div>
   </div>

   <c:import url="_form.jsp" />

 </div>
 <%@include file="../regist_user_shared/footer.jsp" %>
 <%@include file="../regist_user_shared/js.jsp" %>
 <script type="text/javascript" src="<c:url value='/static/lib/edit_area/edit_area_full.js'/>"></script>
 <script type="text/javascript" src="<c:url value='/static/registUser/js/interface.js'/>"></script>
</body>
</html>

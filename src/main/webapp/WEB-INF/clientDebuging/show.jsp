<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String baseUrl = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <title>api详情</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="${pageContext.request.contextPath}/static/custom/css/debugging_show.css" rel="stylesheet">
</head>
<body>
 <%@include file="../client_shared/shared_css.jsp" %>
 <%@include file="../client_shared/nav.jsp" %>
 
 <div class="container content">
   <div class="row">
     <div class="col-md-12">
       <table class="table table-hover">
         <tr class="info">
           <td>名称</td>
           <td>内容</td>
         </tr>
         <tr>
           <td>接口名称</td>
           <td>${unRegisterAPI.apiName }</td>
         </tr>
         <tr>
           <td>api</td>
           <td>${unRegisterAPI.api }</td>
         </tr>
         <tr>
           <td>请求方式</td>
           <td>${unRegisterAPI.method }</td>
         </tr>
         <tr>
           <td>创建时间</td>
           <td>${unRegisterAPI.createdAt }</td>
         </tr>
         <tr>
           <td>请求参数</td>
           <td>${unRegisterAPI.param }</td>
         </tr>
         <tr>
           <td>响应数据</td>
           <td>${unRegisterAPI.response }</td>
         </tr>
       </table>
     </div>
   </div>
 </div>
 
 <%@include file="../client_shared/_footer.jsp" %>
 <%@include file="../client_shared/js.jsp" %>
</body>
</html>

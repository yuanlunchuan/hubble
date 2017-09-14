<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String baseUrl = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <title>接口调试</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="${pageContext.request.contextPath}/static/lib/toast/toast.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/static/custom/css/debugging_index.css" rel="stylesheet">
</head>
<body>
 <%@include file="../client_shared/shared_css.jsp" %>
 <%@include file="../client_shared/nav.jsp" %>
 
 <div class="container content">
   <div class="row">
     <div class="col-md-5">
        <h3>已有的接口列表</h3>
     </div>
     <div class="col-md-6 text-right">
        <h3><a href="${pageContext.request.contextPath}/clientDebuging">新增接口</a></h3>
     </div>
   </div>
   <div class="row">
     <div class="col-md-12">
       <table class="table table-hover">
         <tr class="info">
           <td>序号</td>
           <td>接口名称</td>
           <td>api</td>
           <td>请求方式</td>
           <td>调用次数</td>
           <td>操作</td>
         </tr>
         <c:forEach var="unRegisterAPI" items="${unRegisterAPIs}" varStatus="status">
		  <tr>
		    <td>${status.index+1}</td>
		    <td>${unRegisterAPI.apiName }</td>
		    <td><a href="${pageContext.request.contextPath}/clientDebuging/detail/${unRegisterAPI.id}">${unRegisterAPI.api }</a></td>
		    <td>${unRegisterAPI.method }</td>
		    <td>${unRegisterAPI.invokeCount }</td>
		    <td><button class="btn btn-info copy-button hidden">点击复制</button><a class="btn btn-info copy-button" href="${pageContext.request.contextPath}/clientDebuging/${unRegisterAPI.id}/edit">编辑</a> </td>
		  </tr>
         </c:forEach>
        </table>
     </div>
   </div>
 </div>
 
 <%@include file="../client_shared/_footer.jsp" %>
 <%@include file="../client_shared/js.jsp" %>
 <script src="${pageContext.request.contextPath}/static/lib/toast/toast.min.js"></script>
 <script src="${pageContext.request.contextPath}/static/custom/js/debugging_index.js"></script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员中心</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/registUser/css/projects_index.css">
</head>
<body>
 <%@include file="../regist_user_shared/css.jsp" %>
 <%@include file="../regist_user_shared/nav.jsp" %>

 <div class="container">
   <div class="row">
     <div class="col-md-12">
       <h3>项目列表</h3>
     </div>
   </div>
 </div>

 <div class="container content">
   <div class="row menue-row">
    <div class="col-md-4">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="请输入项目名称或描述">
        <span class="input-group-btn">
          <button class="btn btn-default" type="button">
          <i class="fa fa-search" aria-hidden="true"></i></button>
        </span>
      </div>
    </div>
    <div class="col-md-7 text-right">
      <button type="button" class="btn btn-info" aria-label="Left Align" data-toggle="modal" data-target="#myModal">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
      </button>
    </div>
   </div>
   <div class="line"></div>
   <div class="row project-row">
    <c:forEach var="project" items="${collection.content}" varStatus="status">
     <div class="col-md-2">
       <a href="${pageContext.request.contextPath}/registUser/projects/${project.id}">
         <img alt="" src="${pageContext.request.contextPath}/${project.imgUrl}" class="img-responsive">
         <h4 class="text-center">${project.name}</h4>
       </a>
     </div>
     </c:forEach>
   </div>
   
	<nav aria-label="Page navigation">
	  <ul class="pagination">
	    <li>
	      <a href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
		<c:forEach var="i" begin="1" end="${collection.totalPage}">
     	  <li><a href="${pageContext.request.contextPath}/registUser/projects?pageSize=10&pageNumber=${i}">${i}</a></li>    
		</c:forEach>
	    <li>
	      <a href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
	</nav>
 </div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增项目</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/registUser/projects">
		  <div class="form-group">
		    <label class="col-md-2 control-label">项目名称</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" name="name">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">项目描述</label>
		    <div class="col-md-10">
		      <textarea class="form-control" rows="5" name="introduce"></textarea>
		    </div>
		  </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="submit" class="btn btn-primary">保存</button>
	      </div>
		</form>
      </div>
    </div>
  </div>
</div>
 <%@include file="../regist_user_shared/footer.jsp" %>
 <%@include file="../regist_user_shared/js.jsp" %>
</body>
</html>

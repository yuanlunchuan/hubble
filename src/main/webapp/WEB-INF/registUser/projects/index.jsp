<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
     <div class="col-md-2">
       <a href="${pageContext.request.contextPath}/registUser/projects/1">
         <img alt="" src="${pageContext.request.contextPath}/static/registUser/image/project1.jpg" class="img-responsive">
         <h4 class="text-center">云账房管理系统</h4>
       </a>
     </div>
     <div class="col-md-2">
       <a href="${pageContext.request.contextPath}/registUser/projects/1">
         <img alt="" src="${pageContext.request.contextPath}/static/registUser/image/project2.jpg" class="img-responsive">
         <h4 class="text-center">店里客O2O</h4>
       </a>
     </div>
     <div class="col-md-2">
       <a href="${pageContext.request.contextPath}/registUser/projects/1">
         <img alt="" src="${pageContext.request.contextPath}/static/registUser/image/project3.jpg" class="img-responsive">
         <h4 class="text-center">快递抢单系统</h4>
       </a>
     </div>
     <div class="col-md-2">
       <a href="${pageContext.request.contextPath}/registUser/projects/1">
         <img alt="" src="${pageContext.request.contextPath}/static/registUser/image/project4.jpg" class="img-responsive">
         <h4 class="text-center">yonex嘉宾签到</h4>
       </a>
     </div>
     <div class="col-md-2">
       <a href="${pageContext.request.contextPath}/registUser/projects/1">
         <img alt="" src="${pageContext.request.contextPath}/static/registUser/image/project5.jpg" class="img-responsive">
         <h4 class="text-center">aud官网建设</h4>
       </a>
     </div>
     <div class="col-md-2">
       <a href="${pageContext.request.contextPath}/registUser/projects/1">
         <img alt="" src="${pageContext.request.contextPath}/static/registUser/image/project6.jpg" class="img-responsive">
         <h4 class="text-center">快便当送餐平台</h4>
       </a>
     </div>
   </div>

   <div class="row project-row">
     <div class="col-md-2">
       <a href="${pageContext.request.contextPath}/registUser/projects/1">
         <img alt="" src="${pageContext.request.contextPath}/static/registUser/image/project7.jpg" class="img-responsive">
         <h4 class="text-center">微信摇一摇</h4>
       </a>
     </div>
     <div class="col-md-2">
       <a href="${pageContext.request.contextPath}/registUser/projects/1">
         <img alt="" src="${pageContext.request.contextPath}/static/registUser/image/project8.jpg" class="img-responsive">
         <h4 class="text-center">师傅到家系统</h4>
       </a>
     </div>
     <div class="col-md-2">
       <a href="${pageContext.request.contextPath}/registUser/projects/1">
         <img alt="" src="${pageContext.request.contextPath}/static/registUser/image/project9.jpg" class="img-responsive">
         <h4 class="text-center">搜附近的人</h4>
       </a>
     </div>
     <div class="col-md-2">
       <a href="${pageContext.request.contextPath}/registUser/projects/1">
         <img alt="" src="${pageContext.request.contextPath}/static/registUser/image/project10.jpg" class="img-responsive">
         <h4 class="text-center">微信摇一摇</h4>
       </a>
     </div>
     <div class="col-md-2">
       <a href="${pageContext.request.contextPath}/registUser/projects/1">
         <img alt="" src="${pageContext.request.contextPath}/static/registUser/image/project11.jpg" class="img-responsive">
         <h4 class="text-center">师傅到家系统</h4>
       </a>
     </div>
     <div class="col-md-2">
       <a href="${pageContext.request.contextPath}/registUser/projects/1">
         <img alt="" src="${pageContext.request.contextPath}/static/registUser/image/project12.jpg" class="img-responsive">
         <h4 class="text-center">搜附近的人</h4>
       </a>
     </div>
   </div>
   
   <div class="row project-row">
     <div class="col-md-2">
       <a href="${pageContext.request.contextPath}/registUser/projects/1">
         <img alt="" src="${pageContext.request.contextPath}/static/registUser/image/project13.jpg" class="img-responsive">
         <h4 class="text-center">微信摇一摇</h4>
       </a>
     </div>
     <div class="col-md-2">
       <a href="${pageContext.request.contextPath}/registUser/projects/1">
         <img alt="" src="${pageContext.request.contextPath}/static/registUser/image/project14.jpg" class="img-responsive">
         <h4 class="text-center">师傅到家系统</h4>
       </a>
     </div>
     <div class="col-md-2">
       <a href="${pageContext.request.contextPath}/registUser/projects/1">
         <img alt="" src="${pageContext.request.contextPath}/static/registUser/image/project15.jpg" class="img-responsive">
         <h4 class="text-center">搜附近的人</h4>
       </a>
     </div>
   </div>
   
	<nav aria-label="Page navigation">
	  <ul class="pagination">
	    <li>
	      <a href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    <li><a href="#">1</a></li>
	    <li><a href="#">2</a></li>
	    <li><a href="#">3</a></li>
	    <li><a href="#">4</a></li>
	    <li><a href="#">5</a></li>
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
		<form class="form-horizontal">
		  <div class="form-group">
		    <label class="col-md-2 control-label">项目名称</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">项目简介</label>
		    <div class="col-md-10">
		      <input type="password" class="form-control">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">项目描述</label>
		    <div class="col-md-10">
		      <textarea type="password" class="form-control" rows="5"></textarea>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary">保存</button>
      </div>
    </div>
  </div>
</div>
 <%@include file="../regist_user_shared/footer.jsp" %>
 <%@include file="../regist_user_shared/js.jsp" %>
</body>
</html>

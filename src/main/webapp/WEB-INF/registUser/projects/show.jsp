<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员中心</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/registUser/css/projects_show.css">
</head>
<body>
 <%@include file="../regist_user_shared/css.jsp" %>
 <%@include file="../regist_user_shared/nav.jsp" %>

 <div class="container">
   <div class="row">
     <div class="col-md-12">
       <h3>师傅到家</h3>
     </div>
   </div>
 </div>

 <div class="container content">
  <div class="row">
    <div class="col-md-4 team-area">
      <h4 class="team-title">成员列表</h4>
      <button class="btn btn-info add-team-button" data-toggle="modal" data-target="#myModal">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增成员
      </button>
      <div class="clear"></div>
	  <ul class="media-list team-list">
		<li class="media">
		  <div class="media-left">
		    <a href="#">
		      <img class="media-object" width="60" src="${pageContext.request.contextPath}/static/registUser/image/person.jpg" alt="...">
		    </a>
		  </div>
		  <div class="media-body">
		    <h4 class="media-heading">张真人</h4>
		    799652013@qq.com
		  </div>
		  <div class="media-right remove-area hidden">
		    <span class="glyphicon glyphicon-remove red-color"></span>
		  </div>
		 </li>
		<li class="media">
		  <div class="media-left">
		    <a href="#">
		      <img class="media-object" width="60" src="${pageContext.request.contextPath}/static/registUser/image/person.jpg" alt="...">
		    </a>
		  </div>
		  <div class="media-body">
		    <h4 class="media-heading">张真人</h4>
		    799652013@qq.com
		  </div>
		  <div class="media-right remove-area hidden">
		    <span class="glyphicon glyphicon-remove red-color"></span>
		  </div>
		 </li>
		<li class="media">
		  <div class="media-left">
		    <a href="#">
		      <img class="media-object" width="60" src="${pageContext.request.contextPath}/static/registUser/image/person.jpg" alt="...">
		    </a>
		  </div>
		  <div class="media-body">
		    <h4 class="media-heading">张真人</h4>
		    799652013@qq.com
		  </div>
		  <div class="media-right remove-area hidden">
		    <span class="glyphicon glyphicon-remove red-color"></span>
		  </div>
		 </li>
		<li class="media">
		  <div class="media-left">
		    <a href="#">
		      <img class="media-object" width="60" src="${pageContext.request.contextPath}/static/registUser/image/person.jpg" alt="...">
		    </a>
		  </div>
		  <div class="media-body">
		    <h4 class="media-heading">张真人</h4>
		    799652013@qq.com
		  </div>
		  <div class="media-right remove-area hidden">
		    <span class="glyphicon glyphicon-remove red-color"></span>
		  </div>
		 </li>
		<li class="media">
		  <div class="media-left">
		    <a href="#">
		      <img class="media-object" width="60" src="${pageContext.request.contextPath}/static/registUser/image/person.jpg" alt="...">
		    </a>
		  </div>
		  <div class="media-body">
		    <h4 class="media-heading">张真人</h4>
		    799652013@qq.com
		  </div>
		  <div class="media-right remove-area hidden">
		    <span class="glyphicon glyphicon-remove red-color"></span>
		  </div>
		 </li>
	  </ul>
    </div>
    <div class="col-md-8">
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
         <a type="button" class="btn btn-info" href="${pageContext.request.contextPath}/registUser/interfaces/new">
                           新增接口
         </a>
       </div>
     </div>
     
     <div class="row">
       <div class="col-md-12">
         <table class="table table-striped table-hover">
           <tr class="info">
             <td>序号</td>
             <td>接口名称</td>
             <td>请求方式</td>
             <td>请求说明</td>
             <td>操作</td>
           </tr>
           <tr>
             <td>1</td>
             <td>订单列表</td>
             <td>GET请求</td>
             <td>获取订单列表</td>
             <td><a href="${pageContext.request.contextPath}/registUser/interfaces/123/edit">编辑</a>
             /<a href="">删除</a>
             /<a href="">查看响应数据</a>
             /<a href="">查看详情</a>
             </td>
           </tr>
           <tr>
             <td>2</td>
             <td>订单详情</td>
             <td>GET请求</td>
             <td>获取订单详情数据</td>
             <td><a href="${pageContext.request.contextPath}/registUser/interfaces/123/edit">编辑</a>
             /<a href="">删除</a>
             /<a href="">查看响应数据</a>
             /<a href="">查看详情</a>
             </td>
           </tr>
           <tr>
             <td>3</td>
             <td>删除用户</td>
             <td>Delete请求</td>
             <td>删除数据</td>
             <td><a href="${pageContext.request.contextPath}/registUser/interfaces/123/edit">编辑</a>
             /<a href="">删除</a>
             /<a href="">查看响应数据</a>
             /<a href="">查看详情</a>
             </td>
           </tr>
         </table>
       </div>
     </div>
    </div>
  </div>
 </div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title" id="myModalLabel">新增成员</h4>
      </div>
      <div class="modal-body">
		<form class="form-horizontal" method="post" action="<c:url value='/registUser/projects'/>/${projectId}">
		  <div class="form-group">
		    <label class="col-md-2 control-label">Email</label>
		    <div class="col-md-10">
		      <input type="email" class="form-control" name="email" placeholder="Email">
		    </div>
		  </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="submit" class="btn btn-primary">新增</button>
	      </div>
		</form>
      </div>
    </div>
  </div>
</div>

 <!-- <%@include file="../regist_user_shared/footer.jsp" %> -->
 <%@include file="../regist_user_shared/js.jsp" %>
 <script src="${pageContext.request.contextPath}/static/registUser/js/project_show.js"></script>
</body>
</html>

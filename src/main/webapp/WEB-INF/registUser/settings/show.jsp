<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员中心</title>
</head>
<body>
 <%@include file="../regist_user_shared/css.jsp" %>
 <%@include file="../regist_user_shared/nav.jsp" %>

 <div class="container" style="height: 500px; margin-top: 50px;">
   <div class="row">
     <div class="col-md-12">
	  <!-- Nav tabs -->
	  <ul class="nav nav-tabs" role="tablist">
	    <li role="presentation" class="active">
	      <a href="#home" aria-controls="home" role="tab" data-toggle="tab">个人信息</a>
	    </li>
	    <li role="presentation">
	      <a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">修改个人信息</a>
	    </li>
	    <li role="presentation">
	      <a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">修改密码</a>
	    </li>
	    <li role="presentation">
	      <a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">项目转让</a>
	    </li>
	  </ul>
	
	  <!-- Tab panes -->
	  <div class="tab-content" style="margin-top: 30px;">
	    <div role="tabpanel" class="tab-pane active" id="home">
	      <div class="col-md-2">
	        <img alt="" src="<c:url value='/static/registUser/image/user.jpg'/>" class="img-responsive">
	      </div>
	      <div class="col-md-6">
	        <h3>用户名： 张三</h3>
	        <h4>签名： 为了公司的发展奋斗到最后一刻。</h4>
	        <h4>邮箱： 799652013@qq.com</h4>
	        <h4>性别：男</h4>
	      </div>
	    </div>
	    <div role="tabpanel" class="tab-pane" id="profile">
	      <div class="col-md-2">
	        <img alt="" src="<c:url value='/static/registUser/image/user.jpg'/>" class="img-responsive">
	      </div>
	      <form action="">
	        <div class="col-md-6">
	          <h3>用户名： <input type="text" name="username" value="张三"> </h3>
	          <h4>签名： <input type="text" name="sign" value="为了公司的发展奋斗到最后一刻。"></h4>
	          <h4>邮箱： <input type="text" name="email" value="799652013@qq.com"> </h4>
	          <h4>性别：<input type="radio" name="sex" value="nan">男<input type="radio" name="sex" value="nv">女</h4>
	          <button type="button" class="btn btn-default">提交</button>
	        </div>
	      </form>
	    </div>
	    <div role="tabpanel" class="tab-pane" id="messages">
			<form class="form-horizontal">
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">原密码</label>
			    <div class="col-sm-8">
			      <input type="password" class="form-control" id="inputEmail3" placeholder="原密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">新密码</label>
			    <div class="col-sm-8">
			      <input type="password" class="form-control" id="inputPassword3" placeholder="新密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-8">
			      <input type="password" class="form-control" id="inputPassword3" placeholder="确认密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">确认修改</button>
			    </div>
			  </div>
			</form>
	    </div>
	    <div role="tabpanel" class="tab-pane" id="settings">
		<div class="row">
		  <div class="col-md-4">
		    <div class="thumbnail">
		      <img src="<c:url value='/static/registUser/image/project1.jpg'/>" alt="">
		      <div class="caption">
		        <h3>师傅到家</h3>
		        <p>师傅到家，专门为需要上门的用户提供服务，当您的东西坏了后，可以使用我们的app进行搜索。</p>
		        <p><a href="#" class="btn btn-primary" role="button" data-toggle="modal" data-target="#myModal">转让</a>
		        <a href="#" class="btn btn-danger" role="button">删除</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-4">
		    <div class="thumbnail">
		      <img src="<c:url value='/static/registUser/image/project1.jpg'/>" alt="">
		      <div class="caption">
		        <h3>师傅到家</h3>
		        <p>师傅到家，专门为需要上门的用户提供服务，当您的东西坏了后，可以使用我们的app进行搜索。</p>
		        <p><a href="#" class="btn btn-primary" role="button" data-toggle="modal" data-target="#myModal">转让</a>
		        <a href="#" class="btn btn-danger" role="button">删除</a></p>
		      </div>
		    </div>
		  </div>
		  <div class="col-md-4">
		    <div class="thumbnail">
		      <img src="<c:url value='/static/registUser/image/project1.jpg'/>" alt="">
		      <div class="caption">
		        <h3>师傅到家</h3>
		        <p>师傅到家，专门为需要上门的用户提供服务，当您的东西坏了后，可以使用我们的app进行搜索。</p>
		        <p><a href="#" class="btn btn-primary" role="button" data-toggle="modal" data-target="#myModal">转让</a>
		        <a href="#" class="btn btn-danger" role="button">删除</a></p>
		      </div>
		    </div>
		  </div>
		</div>
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
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">转让项目</h4>
      </div>
      <div class="modal-body">
		<select class="form-control">
		  <option>张三</option>
		  <option>李四</option>
		  <option>王五</option>
		  <option>刘二</option>
		</select>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary">确认转让</button>
      </div>
    </div>
  </div>
</div>

 <%@include file="../regist_user_shared/footer.jsp" %>
 <%@include file="../regist_user_shared/js.jsp" %>
</body>
</html>

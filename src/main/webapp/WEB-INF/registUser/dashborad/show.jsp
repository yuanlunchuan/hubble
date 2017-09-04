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
       <div class="text-center">
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
       <div class="text-center">
         <div class="col-md-5 blue">
           <h1><i class="fa fa-sign-in" aria-hidden="true"></i></h1>
         </div>
         <div class="col-md-7 text-container">
           <h3>2017-8-30</h3>
           <h4>上次登录时间</h4>
         </div>
       </div>
     </div>
     <div class="col-md-3">
       <div class="text-center">
         <div class="col-md-5 blue">
           <h1><i class="fa fa-link" aria-hidden="true"></i></h1>
         </div>
         <div class="col-md-7 text-container">
           <h3>127</h3>
           <h4>接口总数</h4>
         </div>
       </div>
     </div>
     <div class="col-md-3">
       <div class="text-center">
         <div class="col-md-5 blue">
           <h1><i class="fa fa-flag" aria-hidden="true"></i></h1>
         </div>
         <div class="col-md-7 text-container">
           <h3>127</h3>
           <h4>项目总数</h4>
         </div>
       </div>
     </div>
   </div>
 </div>
 
 <div class="container message-table">
   <div class="row">
     <div class="col-md-12">
		<div class="panel panel-default">
		  <div class="panel-heading">
		    <h3 class="panel-title">消息列表</h3>
		  </div>
		  <div class="panel-body">
		    <table class="table table-hover">
		      <tr class="info">
                <td>序号</td>
                <td>内容</td>
                <td>发送者</td>
                <td>发送时间</td>
                <td>已读</td>
                <td>操作</td>
              </tr>
		      <tr>
                <td>1</td>
                <td>关于网站升级..</td>
                <td>系统</td>
                <td>2018-3-2</td>
                <td>已读</td>
                <td><button class="btn btn-xs btn-danger">删除</button></td>
              </tr>
		      <tr>
                <td>2</td>
                <td>请快速加入接口..</td>
                <td>张三</td>
                <td>2017-3-08</td>
                <td>未读</td>
                <td><button class="btn btn-xs btn-danger">删除</button></td>
              </tr>
		      <tr>
                <td>3</td>
                <td>新功能已完成开发</td>
                <td>王二</td>
                <td>2018-7-12</td>
                <td>已读</td>
                <td><button class="btn btn-xs btn-danger">删除</button></td>
              </tr>
		      <tr>
                <td>4</td>
                <td>需求已发至王经理..</td>
                <td>王妃</td>
                <td>2018-5-4</td>
                <td>已读</td>
                <td><button class="btn btn-xs btn-danger">删除</button></td>
              </tr>
		      <tr>
                <td>5</td>
                <td>接口文档待存在缺陷</td>
                <td>刘二</td>
                <td>2017-5-9</td>
                <td>已读</td>
                <td><button class="btn btn-xs btn-danger">删除</button></td>
              </tr>
            </table>
            <div class="text-right">
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
		  </div>
		</div>
     </div>
   </div>
 </div>
 
 <%@include file="../regist_user_shared/footer.jsp" %>
 <%@include file="../regist_user_shared/js.jsp" %>
</body>
</html>

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
 
 <div class="container" style="height: 500px;">
   <div class="row">
     <div class="col-md-4">
		<form>
		  <div class="checkbox">
		    <label><input type="checkbox">新人加入通知</label>
		  </div>
		  <div class="checkbox">
		    <label><input type="checkbox">加入项目通知</label>
		  </div>
		  <div class="checkbox">
		    <label><input type="checkbox">被踢出项目通知</label>
		  </div>
		  <div class="checkbox">
		    <label><input type="checkbox">对项目api修改通知</label>
		  </div>
		  <div class="checkbox">
		    <label><input type="checkbox">接收api修改通知</label>
		  </div>
		  <button type="submit" class="btn btn-default">提交</button>
		</form>
     </div>
   </div>
 </div>
 
 <%@include file="../regist_user_shared/footer.jsp" %>
 <%@include file="../regist_user_shared/js.jsp" %>
</body>
</html>

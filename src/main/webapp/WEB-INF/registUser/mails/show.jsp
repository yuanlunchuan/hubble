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
   	 <form>
        <div class="col-md-10 col-md-offset-1">
          <table style="width: 100%;">
            <tr>
              <td></td>
              <td>系统通知</td>
              <td>邮件通知</td>
            </tr>
            <tr>
              <td>新人加入通知</td>
              <td><input type="checkbox"></td>
              <td><input type="checkbox"></td>
            </tr>
            <tr>
              <td>加入项目通知</td>
              <td><input type="checkbox"></td>
              <td><input type="checkbox"></td>
            </tr>
            <tr>
              <td>被踢出项目通知</td>
              <td><input type="checkbox"></td>
              <td><input type="checkbox"></td>
            </tr>
            <tr>
              <td>对项目api修改通知</td>
              <td><input type="checkbox"></td>
              <td><input type="checkbox"></td>
            </tr>
          </table>
		  <button type="submit" class="btn btn-default" style="margin-top: 50px;">提交</button>
		</div>
	  </form>
   </div>
 </div>
 
 <%@include file="../regist_user_shared/footer.jsp" %>
 <%@include file="../regist_user_shared/js.jsp" %>
</body>
</html>

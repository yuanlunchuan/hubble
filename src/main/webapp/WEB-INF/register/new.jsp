<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String baseUrl = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<title>用户注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="${pageContext.request.contextPath}/static/custom/css/register_new.css"
	rel="stylesheet">
</head>
<body>
	<%@include file="../client_shared/shared_css.jsp"%>
	<%@include file="../client_shared/nav.jsp"%>
	<div class="container content">
		<div class="row">
			<div class="col-md-5 col-md-offset-3">
				<form class="form-horizontal"
					action="${pageContext.request.contextPath}/register/create"
					method="post">
					<div class="form-group">
						<label class="col-md-3 control-label">email<span
							class="red-color">*</span></label>
						<div class="col-md-9">
							<input type="email" class="form-control" name="email">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">设置密码<span
							class="red-color">*</span></label>
						<div class="col-md-9">
							<input type="password" class="form-control" name="password"
								id="pwd">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">确认密码<span
							class="red-color">*</span></label>
						<div class="col-sm-9">
							<input type="password" class="form-control" name="repassword"
								id="repwd" onkeyup="validate()"><span id="hinter"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">验证码<span
							class="red-color">*</span></label>
						<div class="col-md-4">
							<input type="text" class="form-control" name="valicode">
						</div>
						<div id="yanzhengmaContainer"></div>
						<span>换一张</span>
					</div>
					<div class="form-group">
						<div class="col-md-10 col-md-offset-2">
							<button type="submit" class="submit-button">注册</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script>
		function validate() {
			var pwd = document.getElementById("pwd").value;
			var repwd = document.getElementById("repwd").value;
			//对比两次输入的密码 
			if (pwd == repwd) {
				document.getElementById("hinter").innerHTML = "<font color='green'>两次密码相同</font>";
				document.getElementById("submit").disabled = false;
			} else {
				document.getElementById("hinter").innerHTML = "<font color='red'>两次密码不相同</font>";
				document.getElementById("submit").disabled = true;
			}
		}
	</script>
	<%@include file="../client_shared/_footer.jsp"%>
	<%@include file="../client_shared/js.jsp"%>
	<script
		src="${pageContext.request.contextPath}/static/lib/yanzhengma/gVerify.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/custom/js/register.js"></script>
</body>
</html>

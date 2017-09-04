<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="header">
	<div class="headerinner">
		<ul class="headernav">
			<li class="logo">
				<!---<img src="" alt="" />--->
			</li>
			<li><a href="${pageContext.request.contextPath}/registUser/dashborad">首页</a></li>
			<li><a href="${pageContext.request.contextPath}/registUser/teams" >团队管理</a></li>
			<li><a href="${pageContext.request.contextPath}//registUser/interfaces">接口管理</a></li>
			<li><a href="#" >在线体验</a></li>
			<li><a href="#" >个人设置</a></li>
			<li class="search">
				<a class="search_pic"></a>
			</li>
			<li class="list">
				<a></a>
			</li>
		</ul>
		<!-- 搜索 -->
		<form action="">
			<div class="search_main">
				<button class="search_btn" type="submit"></button>
				<input class="search_text" type="text" placeholder="接口搜索">
				<span class="close_btn"></span>
			</div>
		</form>
		<!-- 会员登录 -->
		<div class="member">
			<p>会员中心</p>
			<ul>
				<li>
					<img src="${pageContext.request.contextPath}/static/registUser/image/huiyuan1.png" alt="">
					<a href="login.html">退出</a>
				</li>
				<li>
					<img src="${pageContext.request.contextPath}/static/registUser/image/huiyuan1.png" alt="">
					<a href="register.html">账号管理</a>
				</li>
			</ul>
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header">
	<div class="headerinner">
		<ul class="headernav">
			<li class="logo">
				<!---<img src="" alt="" />--->
			</li>
			<li><a href="${pageContext.request.contextPath}/registUser/dashborad">首页</a></li>
			<li class="hidden"><a href="${pageContext.request.contextPath}/registUser/teams" >团队管理</a></li>
			<li><a href="${pageContext.request.contextPath}/registUser/projects">项目管理</a></li>
			<li><a href="<c:url value='/registUser/mails' />" >邮件通知设置</a></li>
			<li><a href="<c:url value='/registUser/settings'/>">个人设置</a></li>
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
					<a href="${pageContext.request.contextPath}/sessions/logout">退出</a>
				</li>
				<li>
					<img src="${pageContext.request.contextPath}/static/registUser/image/huiyuan1.png" alt="">
					<a href="register.html">账号管理</a>
				</li>
			</ul>
		</div>
	</div>
</div>
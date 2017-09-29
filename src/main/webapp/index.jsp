<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String baseUrl = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
  <title>首页</title>
<!-- Bootstrap -->
<link href="<%=baseUrl %>/static/lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<%=baseUrl%>/static/lib/font-awesome/css/font-awesome.min.css">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<link href="<%=baseUrl %>/static/custom/css/index.css" rel="stylesheet">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<nav class="navbar navbar-default header navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand brand" href="/hubble/">Hubble</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/hubble/">首页</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">接口调试<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="/hubble/clientDebuging/index">接口列表</a></li>
            <li><a href="/hubble/clientDebuging">新增接口</a></li>
          </ul>
        </li>
        <li><a href="/hubble/aboutUs/show">关于我们</a></li>
        <li><a href="/hubble/contactUs/new">联系我们</a></li>
        <li><a href="<%=baseUrl %>/sessions/new">登录注册</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container-fluid content">
  <div class="row desc">
    <div class="col-md-12 white-color text-center">
      <h1>为您开发的速度加上腾飞的翅膀</h1>
      <h3>接口管理平台</h3>
    </div>
  </div>
  <div class="row">
    <div class="col-md-12 text-center">
      <button class="transparent btn btn-default btn-lg">
        <span class="button-text">开始调试</span>
      </button>
      <button class="btn btn-default btn-lg pink">
        <span class="button-text">了解更多</span>
      </button>
    </div>
  </div>
</div>

<div class="container product-intro">
  <div class="row">
    <div class="col-md-6">
      <img src="<%=baseUrl%>/static/custom/image/intro-page.png" class="img-responsive">
    </div>
    <div class="col-md-6 text-center">
      <h1 class="intro-text">产品介绍</h1>
      <p style="text-indent:2em; text-align:left;">
       目前web项目大部分是采用前后端进行分离开发，如Android，iOS需要访问服务器的数据都是
       通过发起http请求，再对数据解析显示。
       web前端开发框架也逐渐进入到开发中，比较流行的有AngularJs，Vue等前端框架。使前端端开发人员
       独立进行开发，但是web前端获取数据需要通过web接口进行获取，因此就存在一个问题，前端在做好界面后，
       需要等待后端人员的接口，或者后端需要和前端一起调试接口，增加了交流沟通的成本，本产品着力解决，
       联调的问题，后端和前端只需要约定好调用的接口，传递的参数，返回的响应数据等录入系统，前后端便可独立开发
       互不影响。
      </p> 
    </div>
  </div>
</div>

<div class="container-fluid normal-user">
  <div class="row normal-user-content">
    <div class="col-md-5 col-md-offset-1 text-center">
      <h1 class="intro-text">普通用户</h1>
      <p style="text-indent:2em; text-align:left;">
       点击右上角开始调试链接，即可进入到接口数据录入界面，此处为前后端需要协调好交互的数据
       请求的http接口，请求方法，请求参数。设置好后点击提交。即可将数据进行保存。数据保存成功后，
       页面会返回您刚刚录入的数据。web开发人员或前端开发人员就可使用此接口，接口是严格按照http协议。
       执行的。假如您请求的接口不正确，或者请求的方式不正确。系统均会返回相应的提示信息。
      </p> 
    </div>
    <div class="col-md-5">
      <img src="<%=baseUrl%>/static/custom/image/normal-user.png" class="img-responsive">
    </div>
  </div>
</div>

<div class="container sys-user">
  <div class="row sys-user-content">
    <div class="col-md-5">
      <img src="<%=baseUrl%>/static/custom/image/intro-page.png" class="img-responsive">
    </div>
    <div class="col-md-5 col-md-offset-1 text-center">
      <h1 class="intro-text">注册用户</h1>
      <p style="text-indent:2em; text-align:left;">
       点击右上角按钮进行注册，成为注册用户后，能进行团队管理。添加，删除团队成员。团队管理员能对成员进行
       权限管理，即是否授权某成员对接口进行管理。成为注册用户后能对历史接口进行查看管理。方便新加入的团队
       查询接口，尽快熟悉系统上手工作。
      </p> 
    </div>
  </div>
</div>

<div class="container">
  <h1 class="text-center use-company">这些公司也在用</h1>
  <div class="row">
    <div class="col-md-3">
      <img src="<%=baseUrl%>/static/custom/image/baidu.jpg" class="img-responsive">
    </div>
    <div class="col-md-3">
      <img src="<%=baseUrl%>/static/custom/image/ali.jpg" class="img-responsive">
    </div>
    <div class="col-md-3">
      <img src="<%=baseUrl%>/static/custom/image/jd.jpg" class="img-responsive">
    </div>
    <div class="col-md-3">
      <img src="<%=baseUrl%>/static/custom/image/tencent.jpg" class="img-responsive">
    </div>
  </div>
</div>

<div class="container-fluid footer">
  <div class="row">
    <div class="col-md-12">
      <div class="text-center">
        <a href="https://user.qzone.qq.com/799652013/infocenter" target="_blank"><span class="space">关于</span></a>
        <a href="https://user.qzone.qq.com/799652013/infocenter" target="_blank"><span class="space">博客</span></a>
        <a href="https://user.qzone.qq.com/799652013/infocenter" target="_blank"><span class="space">网站</span></a>
      </div>
      <div class="line"></div>
      <div class="text-center">
          <a href="https://user.qzone.qq.com/799652013/infocenter" title="微博"><span class="space"><i class="fa fa-weibo"></i></span></a>
          <a href="mailto:open@799652013@qq.com" title="商务合作"><span class="space"><i class="fa fa-envelope-o"></i></span></a>
      </div>
      <p class="copy text-center">© 2017 · hubble接口助手 · All Rights Reserved</p></div>
  </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<%=baseUrl %>/static/lib/jquery/dist/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=baseUrl %>/static/lib/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>

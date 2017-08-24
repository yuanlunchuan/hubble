<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String baseUrl = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
  <title>接口调试</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="${pageContext.request.contextPath}/static/custom/css/debugging_new.css" rel="stylesheet">
</head>
<body>
 <%@include file="../client_shared/shared_css.jsp" %>
 <%@include file="../client_shared/nav.jsp" %>
 
 <div class="container content">
   <div class="row">
     <div class="col-md-6 request-form">
		<div class="panel panel-default">
		  <div class="panel-heading">请求参数录入</div>
		  <div class="panel-body">
			<form class="form-horizontal">
			  <div class="form-group">
			    <label class="col-sm-2 control-label">web接口</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control">
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">请求方式</label>
			    <div class="col-sm-10">
			      <select class="form-control">
				    <option>GET请求</option>
				    <option>POST请求</option>
				    <option>DELETE请求</option>
				    <option>PUT请求</option>
				  </select>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">参数</label>
			    <div class="col-sm-10">
			      <textarea class="form-control" rows="3"></textarea>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">提交并模拟请求</button>
			    </div>
			  </div>
			</form>
		  </div>
		</div>
     </div>

     <div class="col-md-6">
		<div class="panel panel-default">
		  <div class="panel-heading">
		    <h3 class="panel-title">模拟请求响应数据</h3>
		  </div>
		  <div class="panel-body">
			<p>
			  {"rspCode":"000000","rspDesc":"请求成功","id":null,"data":{"rows":[{"dictId":73,"dictCode":"1","dictName"
				:"发起","dictType":"orderStatus","dictTypeName":"订单状态"},{"dictId":74,"dictCode":"2","dictName":"预处理","dictType"
				:"orderStatus","dictTypeName":"订单状态"},{"dictId":385,"dictCode":"13","dictName":"分票","dictType":"orderStatus"
				,"dictTypeName":"订单状态"},{"dictId":75,"dictCode":"3","dictName":"识别","dictType":"orderStatus","dictTypeName"
				:"订单状态"},{"dictId":76,"dictCode":"4","dictName":"纠偏","dictType":"orderStatus","dictTypeName":"订单状态"}
				,{"dictId":77,"dictCode":"5","dictName":"审单","dictType":"orderStatus","dictTypeName":"订单状态"},{"dictId"
				:78,"dictCode":"6","dictName":"记账","dictType":"orderStatus","dictTypeName":"订单状态"},{"dictId":79,"dictCode"
				:"7","dictName":"复核","dictType":"orderStatus","dictTypeName":"订单状态"},{"dictId":217,"dictCode":"0","dictName"
				:"草稿","dictType":"orderStatus","dictTypeName":"订单状态"},{"dictId":235,"dictCode":"8","dictName":"完成","dictType"
				:"orderStatus","dictTypeName":"订单状态"},{"dictId":236,"dictCode":"9999","dictName":"删除","dictType":"orderStatus"
				,"dictTypeName":"订单状态"},{"dictId":434,"dictCode":"14","dictName":"结算","dictType":"orderStatus","dictTypeName"
				:"订单状态"}],"total":0}}
			</p>
		  </div>
		</div>
     </div>     
   </div>
 </div>
 
 <!-- <%@include file="../client_shared/_footer.jsp" %>  --> 
 <%@include file="../client_shared/js.jsp" %>
</body>
</html>

﻿  <div class="row">
    <div class="col-md-12 request-form">
	<div class="panel panel-default">
	  <div class="panel-heading">请求参数录入</div>
	  <div class="panel-body">
		<form action="${pageContext.request.contextPath}/registUser/projects/${projectId}/interfaces" method="post" class="form-horizontal">
		  <input type="hidden" name="projectId" value="${projectId}">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">接口名称</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="apiName">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">接口url</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="api">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">请求方式</label>
		    <div class="col-sm-10">
		      <select class="form-control" name="method">
			    <option value="get">GET请求</option>
			    <option value="post">POST请求</option>
			    <option value="delete">DELETE请求</option>
			    <option value="put">PUT请求</option>
			  </select>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">参数</label>
		    <div class="col-sm-10">
		      <textarea class="form-control" rows="3" name="param"></textarea>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">响应数据</label>
		    <div class="col-sm-10">
				<textarea id="resp-data" class="form-control" style="height: 350px; width: 100%;" name="response">
				</textarea>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">提交</button>
		    </div>
		  </div>
		</form>
	  </div>
	</div>
    </div>
  </div>



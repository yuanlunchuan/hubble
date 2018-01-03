  <div class="row">
    <div class="col-md-8 col-md-offset-2 request-form">
	<div class="panel panel-default">
	  <div class="panel-heading">请求参数录入</div>
	  <div class="panel-body">
		<form action="${pageContext.request.contextPath}/clientDebuging" method="post" class="form-horizontal">
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
		    <div class="col-sm-offset-2 col-sm-2">
		      <button type="button" class="btn btn-default">格式化</button>
		    </div>
		    <div class="col-sm-2">
		      <button type="button" class="btn btn-default">压缩</button>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">响应数据</label>
		    <div class="col-sm-10">
		      <textarea id="response-data" class="form-control" rows="3" name="response"></textarea>
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
  
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					响应数据
				</h4>
			</div>
			<div class="modal-body">
	          <form class="form-horizontal">
				  <div class="form-group">
				    <label class="col-sm-2 control-label">响应数据</label>
				    <div class="col-sm-10">
				      <textarea id="response-data" class="form-control" rows="20" name="response"></textarea>
				    </div>
				  </div>
	          </form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-primary">
					确认
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
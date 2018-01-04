<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <div class="box box-primary">
   <div class="box-header with-border">
     <h3 class="box-title">新增消息</h3>
   </div>
   <!-- form start -->
   <form role="form" method="post" action="${param.url}">
     <input type="hidden" name="id" value="${message.id}">
     <div class="box-body">
       <div class="form-group">
         <label>标题</label>
         <input type="text" name="title" class="form-control" placeholder="标题" value="${message.title}">
       </div>
       <div class="form-group">
         <label>级别</label>
         <select class="form-control">
           <option>一级</option>
           <option>二级</option>
           <option>三级</option>
           <option>四级</option>
         </select>
       </div>
       <div class="form-group">
         <label>内容</label>
         <textarea class="form-control" rows="5" name="content" placeholder="内容 ...">${message.content}</textarea>
       </div>
     </div>
     <!-- /.box-body -->
     <div class="box-footer">
       <button type="submit" class="btn btn-primary">提交</button>
     </div>
   </form>
 </div>
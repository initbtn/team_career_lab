ㅜ<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>

<%@ include file="../include/header.jsp" %>

<body class="bg-gradient-primary">

	<script type="text/javascript">
		$(function(){
			const formObj = $("form");
			
			$('button').on("click",
				function(e)
				{
					e.preventDefault();
					
					const operation = $(this).data("oper");
					
					console.log(operation);
					
					if (operation === 'remove') 
					{
						formObj.attr("action", "/board/remove");
					}
					else if(operation === 'list')
					{
						formObj.attr("action", "/board/list").attr("method","get");
						formObj.empty();
					}
					
					formObj.submit();
				});
		});
	</script>
	
    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-5">
                <!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">게시글 수정</h1>
					</div>
					<!--  /.col-lg-12 -->
				</div>
				<!--  /.row -->
				
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
						
							<div class="panel-heading">Board Modify</div>
							<!--  /.panel-heading -->
							<div class="panel-body">
								<form role="form" action="/board/modify" method="post">
							
							<div class="form-group">
								<label>Post_id</label>
								<input class="form-control" name='post_id' value='<c:out value="${board.post_id }"/>' readonly="readonly">
							</div>
							
							<div class="form-group">
								<label>Title</label>
								<input class="form-control" name='title' value='<c:out value="${board.title}"/>'>
							</div>
 							
							<div class="form-group">
								<label>User ID</label>
								<input class="form-control" name='user_id' value='${userId}' readonly="readonly">
							</div>
							
							<div class="form-group">
								<label>Text area</label>
								<textarea class="form-control" rows="5" name='content'><c:out value="${board.content}" /></textarea>
							</div>

							

							<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
							<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
							<button type="submit" data-oper='list' class="btn btn-info">List</button>

								
							</form>
							
							<!-- end panel-body -->
           			 	</div>
       			 	</div>
	  			</div>
    		</div>
  		</div>
  	</div>
  	</div>
</body>
</html>
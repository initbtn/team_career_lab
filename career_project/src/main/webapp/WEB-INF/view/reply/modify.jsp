<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../include/header.jsp" %>
<body class="bg-gradient-primary">
            		<div>
						<form action="/reply/modify" method="post">
						
							<div>
								<input type="hidden" name="post_id" value="${reply1.post_id}">
							</div>
							<div>
								<input type="hidden" name="comment_id" value="${reply1.comment_id}">
							</div>
							<div>
								<label>댓글 작성자</label><br>
								<input name='userId' value="${userId}"  readonly="readonly">							
							</div>
							<div>
								<label>댓글</label><br>
								<textarea rows="5" cols="50" name="content"></textarea>
							</div>
							<div>
								
							</div>
							 <button id="reply" type="submit" >댓글 수정</button> 
							 <button id="reset" type="reset" >취소</button>
						</form>
					</div>

</body>
</html>
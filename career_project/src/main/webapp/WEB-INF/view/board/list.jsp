<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<%@ include file="../include/header.jsp" %>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

		<%@ include file="../include/sidebar.jsp" %>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
			
			<%@ include file="../include/content.jsp" %>
			<div class="container-fluid">
			<div class="card shadow mb-4">
		            <div class="card-header py-3">
		                <h6 class="m-0 font-weight-bold text-primary">게시글</h6>
		            </div>
		            <div class="card-body">
		                <div class="table-responsive">
		                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
		                        <thead>
		                        	<tr>
		                        		<th>#번호</th>
		                        		<th>작성자</th>
		                        		<th>제목</th>
		                        		<th>조회수</th>
		                        		<th>등록일</th>
		                        	</tr>
		                        </thead>
		                        
		                        <c:forEach items="${list}" var="board">
		                        	<tr>
		                        		<td><c:out value="${board.post_id}" /></td>
		                        		
		                        		<td><a href="/career/getuser?userId=<c:out value="${board.userId}" />"><c:out value="${board.userId}" /></a></td>
		                        			
		                        		<td><a href="/board/get?post_id=<c:out value='${board.post_id}'/>">
		                        		<c:out value="${board.title}"/></a></td>
		                        		
		                        		<td><c:out value="${board.hit}" /></td>
		                        		
		                        		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.created_at}" /></td>
		                        	
		                        	</tr>
		                        </c:forEach>
		                    </table>
	               		</div>
		            </div>
            	</div></div>
			
			<%@ include file="../include/footer.jsp" %>

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>


<%-- 	<%@ include file="../include/modal.jsp" %> --%>
	
</body>

</html>
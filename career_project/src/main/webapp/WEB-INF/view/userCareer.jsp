<%@page import="org.springframework.security.core.userdetails.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file = "./include/header.jsp" %>    
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
      
    <!-- Require SEO -->
    <title>${userId}님의 소개</title>
    
</head>
<body>
	<div id="wrapper">
<!-- 		사이드바 -->
		<jsp:include page="./include/sidebar.jsp" />
		<div id="content-wrapper">
			<div id="content">
<!-- 				헤더 -->
				<jsp:include page="./include/content.jsp" />
			<div class="container-fluid">
	                <c:forEach var="user" items="${career.userList}">
                   	</c:forEach>
                    <div class="row">
					<c:forEach var="user" items="${career.userList}">
                        <!-- Earnings (Monthly) Card Example -->
		                        <div class="col-xl-3 col-md-6 mb-4">
		                            <div class="card border-left-primary shadow h-100 py-2">
		                                <div class="card-body">
		                                    <div class="row no-gutters align-items-center">
		                                        <div class="col mr-2">
		                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
		                                                ${user.userNickname} 가입날짜</div>
		                                            <div class="h5 mb-0 font-weight-bold text-gray-800">
		                                            ${user.userCreatedAt}
		                                            </div>
		                                            <img alt="사진" src="/career/display?prPic=${career.prPic}" width="100" />
		                                        </div>
		                                        <div class="col-auto">
		                                            <i class="fas fa-calendar fa-2x text-gray-300"></i>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
                        <!-- 팔로우 -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
												<li class="nav-item">
									                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsefollowing" aria-expanded="true" aria-controls="collapsefollowing">
									                    <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
			                                                팔로우</div>
			                                            <div class="h5 mb-0 font-weight-bold text-gray-800">
			                                            ${following}명
			                                            </div>
									                </a>
									                <div id="collapsefollowing" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
									                    <div class="bg-white py-2 collapse-inner rounded">
									                        <c:forEach var="List" items="${followingList}">
									                        <a class="collapse-item" href="/career/getuser?userId=<c:out value="${List.following}"/>">${List.following}</a>
									                        </c:forEach>
									                    </div>
									                </div>
									            </li>
									            <li class="nav-item">
									                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsefollower" aria-expanded="true" aria-controls="collapsefollower">
									                    <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
			                                                팔로워</div>
			                                            <div class="h5 mb-0 font-weight-bold text-gray-800">
			                                            ${follower}명
			                                            </div>
									                </a>
									                <div id="collapsefollower" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
									                    <div class="bg-white py-2 collapse-inner rounded">
									                        <c:forEach var="List" items="${followerList}">
									                        <a class="collapse-item" href="/career/getuser?userId=<c:out value="${List.follower}"/>">${List.follower}</a>
									                        </c:forEach>
									                    </div>
									                </div>
									            </li>
												<div class="follow">
												  <!-- 기본적으로 팔로우 버튼으로 시작 -->
												  <c:choose>
												  	<c:when test="${empty follower1}">
												    	<button type="button" class="followBtn" id="follow-btn">팔로우</button>
												  	</c:when>
												  	<c:otherwise>
												  		<button type="button" class="followBtn" id="unfollow-btn">언팔로우</button>
												  	</c:otherwise>
												  </c:choose>
												</div>	
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 자기 소개 -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-info shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">자기소개
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">${career.prIntro}</div>
                                                </div>
                                                <div class="col">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </c:forEach>
                    </div>
                    <!-- DataTales Example -->
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
		                        		<th>작성일</th>
		                        		<th>등록일</th>
		                        	</tr>
		                        </thead>
		                        
		                        <c:forEach items="${board}" var="board">
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
            	</div>
            	</div>
			</div>
		</div>
		</div>
</body>
<script type="text/javascript">
	$('#follow-btn').on('click', function(){
		follow(true);
	});
	$('#unfollow-btn').on('click', function(){
		follow(false);
	});
	
	function follow(check){
		if(check){
			$.ajax({
				type : "POST",
				url : "/follow/follow/?userId=" + ${career.userId},
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST",
				},
				success : function(result){
					console.log("result : " + result);
					if(result == "FollowOk"){
						window.location.href = "/career/getuser?userId=" + ${career.userId};
						alert("팔로우 완료")
						$(".follow").html('<button type="button" class="followBtn" id="unfollow-btn">언팔로우</button>');
						
					}
				}
			});
		} else {
			$.ajax({
				type : "POST",
				url : "/follow/unfollow/?userId=" + ${career.userId},
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST",
				},
				success : function(result){
					window.location.href = "/career/getuser?userId=" + ${career.userId};
					console.log("result : " + result);
					if(result == "unFollowOK"){
						alert("언팔로우 완료")
						$(".follow").html('<button type="button" class="followBtn" id="follow-btn">언팔로우</button>');
						
					}
				}
			});
		}
	}
</script>
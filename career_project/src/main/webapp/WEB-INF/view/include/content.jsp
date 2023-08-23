<%@ page contentType = "text/html; charset=UTF-8"
			pageEncoding = "UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Main Content -->
    <!-- Topbar -->
    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

        <!-- Sidebar Toggle (Topbar) -->
        <form class="form-inline">
            <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                <i class="fa fa-bars"></i>
            </button>
        </form>


        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">

            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
            <li class="nav-item dropdown no-arrow d-sm-none">
                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-search fa-fw"></i>
                </a>
                </li>

            <li class="nav-item dropdown no-arrow">
            	<c:choose>
            	<c:when test="${empty userId }">
                	<a class="nav-link" type="button" href="#" data-toggle="modal" data-target="#loginmodal">
	                    <span class="mr-2 d-none d-lg-inline text-gray-600 small"> 로그인 </span>
                	</a>
                </c:when>
                <c:otherwise>
                	<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                    <span class="mr-2 d-none d-lg-inline text-gray-600 small"> [ ${userId } ]님 </span>
                	</a>
	                <!-- Dropdown - User Information -->
	                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
	                    aria-labelledby="userDropdown">
	               		<a class="dropdown-item" href="/career/get">
	                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
	                        나의 커리어
	                    </a>
	                    <a class="dropdown-item" href="/user/modify">
	                        <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
	                        정보 수정
	                    </a>
	                    <div class="dropdown-divider"></div>
	                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
	                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
	                        로그아웃
	                    </a>
	                </div>
                </c:otherwise>
                </c:choose>
            <!-- 로그인 Modal -->

				<div class="modal fade" id="loginmodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLongTitle">
					        
					        </h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					      <div aria-hidden="true">
				        	<form method="post">
					        	<input type="hidden" id="login_tab">
					        	<button type="button" class="btn btn-light" id="ulogin_tab">개인 회원</button>
						        <button type="button" class="btn btn-light" id="clogin_tab">기업 회원</button>
								<div class="form-group">
									<label for="userId">아이디</label>
									<input type="text" class="form-control" id="userId" name="userId" placeholder="ID 입력" >
								</div>
								<div class="form-group">
									<label for="userPassword">비밀번호</label>
									<input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="Password 입력">
								</div>
								<button type="submit" id="login" class="btn btn-primary">로그인</button>
									<a href="/user/add" id="addUser" class="btn btn-success">회원가입</a>
							</form>
							</div>
						</div>
					 <div class="modal-footer">
					     <div class="find_password">
							<a href="#">아이디 또는 비밀번호를 잊으셨나요?</a>
					     </div>
		            </div>
		            </div>
				  </div>
				</div>
            </li>
        </ul>
    </nav>
    <!-- End of Topbar -->
<!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
	<!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">로그아웃</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">클릭시 로그아웃</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
                    <a class="btn btn-primary" href="/user/logout">로그아웃</a>
                </div>
            </div>
        </div>
    </div>
<!-- End of Main Content -->

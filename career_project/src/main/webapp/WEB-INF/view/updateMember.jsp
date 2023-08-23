<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "./include/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
	<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">회원 수정</h1>
                            </div>
                            <form id="updateform" class="user" method="post">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="userId" name="userId" placeholder="회원 ID" value="${userId}">
                                    </div>
                                    <div class="col-sm-3" id="checkDiv">
                                        
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user" id="userPassword" name="userPassword" placeholder="Password" value="${user.userPassword }">
                                    </div>
<!--                                     <div class="col-sm-6"> -->
<!--                                         <input type="password" class="form-control form-control-user" id="repeatPassword" placeholder="Repeat Password"> -->
<!--                                     </div> -->
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="userName" name="userName" placeholder="이름" value="${userName}">
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user" id="userEmail" name="userEmail" placeholder="Email 주소" value="${user.userEmail}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="userNickname" name="userNickname" placeholder="닉네임" value="${user.userNickname}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="userAddress" name="userAddress" placeholder="주소" value="${user.userAddress}">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="userPhone" name="userPhone" placeholder="휴대번호" value="${user.userPhone}">
                                </div>
                                <button type="submit" class="btn btn-primary btn-user btn-block" data-oper='update'>
                                	회원 정보 수정
                                </button>
                                <button type="submit" class="btn btn-primary btn-user btn-block" data-oper='remove' >
                                	회원 정보 삭제
                                </button>
                                <hr>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="login.html">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
<script type="text/javascript">
$(document).ready(function(){
	
	let formObj = $("#updateform");
    
    $('button').on("click",
    function(e) {
      e.preventDefault();
      const operation = $(this).data("oper");
      console.log(operation);
      
      if (operation === 'remove') {
        formObj.attr("action", "/user/remove");
      }
      
      else if (operation === 'update') {
        formObj.find("#post_id").remove();
        formObj.attr("action", "/user/modify")
      }
      formObj.submit();
    });
	
	
})

</script>
</body>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "./include/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	$('#checkId').click(checkId); 
})
function checkId(){
	$.ajax({
		url:'idcheck?userId='+$('#userId').val(),
		type: 'GET'
	})
	.done(function(check){
		let resDiv = document.getElementById("checkDiv");
		let res = "";
		if(check =="true"){
			res = "<span class='input-group-text' id='basic-addon3'>사용불가 ID</span>"
			resDiv.innerHTML = res;
			
		} else {
			$('#userId').attr('readonly', 'true');
			res = "<span class='input-group-text' id='basic-addon3'>사용가능 ID</span>"
			resDiv.innerHTML = res;
		}
	})
	.fail(function(e){
		alert(e);
	})
}

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
                                <h1 class="h4 text-gray-900 mb-4">회원 가입</h1>
                            </div>
                            <form class="user" action="/user/register" method="post" onsubmit="try {return check(this);} catch(e){}">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="userId" name="userId" placeholder="회원 ID">
                                    	<button type="button" id="checkId" class="btn btn-success">아이디 검사</button>
                                    </div>
                                    <div class="col-sm-3" id="checkDiv">
                                        
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user" id="userPassword" name="userPassword" placeholder="Password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="userName" name="userName" placeholder="이름">
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user" id="userEmail" name="userEmail" placeholder="Email 주소">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="userNickname" name="userNickname" placeholder="닉네임">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="userAddress" name="userAddress" placeholder="주소">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="userPhone" name="userPhone" placeholder="휴대번호">
                                </div>
                                <button type="submit" class="btn btn-primary btn-user btn-block">
                                    회원 가입
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
</body>
</body>
</html>
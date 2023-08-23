<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "./include/header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
                                <h1 class="h4 text-gray-900 mb-4">커리어 등록</h1>
                            </div>
                            <form class="user" action="/career/register" method="post">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="userId" name="userId" placeholder="회원 ID" readonly="readonly" value="${userId}">
                                	</div>
                               	</div>
                                <div class="form-group">
                                    <textarea rows="2" cols="5" class="form-control form-control-user" id="prIntro" name="prIntro"></textarea>
                                </div>
                                <button type="submit" class="btn btn-primary btn-user btn-block">
                                    커리어 등록
                                </button>
                                <hr>
<!--                                 <a href="index.html" class="btn btn-google btn-user btn-block"> -->
<!--                                     <i class="fab fa-google fa-fw"></i> Register with Google -->
<!--                                 </a> -->
<!--                                 <a href="index.html" class="btn btn-facebook btn-user btn-block"> -->
<!--                                     <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook -->
<!--                                 </a> -->
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

</body>
</body>
</html>
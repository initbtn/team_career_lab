<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/sb-admin-2.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.min.css"/>" rel="stylesheet">
    
        <!-- Bootstrap core JavaScript-->
    <script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

    <!-- Core plugin JavaScript-->
    <script src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

    <!-- Custom scripts for all pages-->
    <script src="<c:url value="/resources/js/sb-admin-2.min.js"/>"></script>

    <!-- Page level plugins -->
    <script src="<c:url value="/resources/vendor/datatables/jquery.dataTables.min.js"/>"></script>
    <script src="<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.min.js"/>"></script>

    <!-- Page level custom scripts -->
    <script src="<c:url value="/resources/js/demo/datatables-demo.js"/>"></script>
<style>
 	button#ulogin_tab:focus { 
 		background-color: blue; 
 		color: white; 
 	} 
	
 	button#clogin_tab:focus { 
 		background-color: blue; 
 		color: white; 
 	} 
</style>
<script type="text/javascript">
	

	$(function(){
		
		$('button#ulogin_tab').on("click", function(){
			$('#login_tab').val("u");
			$('#addUser').attr('href', '/user/add');
		})
		$('button#clogin_tab').on("click", function(){
			$('#login_tab').val("c")
			$('#addUser').attr('href', '/company/reg_admin');
			$('#userId').attr('name', 'userid');
			$('#userId').attr('id', 'userid');
			$('#userPassword').attr('name', 'password');
		})
		
    	const formObj = $('form');
    	
    	$('button#login').on("click", function(e){
    		e.preventDefault();
    		
    		const operation = $('#login_tab').val();
    		
    		console.log(operation);

    		if(operation === 'u'){
    			formObj.attr("action", "/user/login");
    		} else if(operation === 'c'){
				formObj.attr("action", "/company/login");
    		} else {
    			formObj.attr("action", "/user/login");
    		}
    		formObj.submit();
    	});
    });
 
    function check(form){ 
        if(form.userId.value==""){
            alert("아이디를 입력하세요");
            form.userId.focus();
            return false;
        }
        if(form.userId.value.indexOf(" ")>0){
            alert("아이디에 공백에 있습니다. 공백을 제거해주세요");
            form.userId.focus();
            return false;
        }
        if(form.userId.value.length<4){
            alert("아이디는 4자이상이어야 합니다");
            form.userId.focus();
            return false;
        }
        if(form.userPassword.value==""){
            alert("비밀번호를 입력하세요");
            form.userPassword.focus();
            return false;
        }
        if(form.userPassword.value.length < 4 || form.userPassword.value.length > 32){
            alert("비밀번호는 영문,숫자,특수문자 조합 6~32자 입니다.");
            form.userPassword.focus();
            return false;
        }
	}
</script>
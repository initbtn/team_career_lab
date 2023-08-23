<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="">
	$(document).ready(function(){
		$('#button').click(checkId); // 버튼 클릭시 id check
	})
	function checkId(){
		let userid = ${'#userid'}.val(); // userid "userid" 입력란 값 저장 
		$.ajax({
			url:'./user/idCheck',  // 요청할 서버url
			type: 'post', // 타입 (get, post, put 등등)
			async: true,
			headers : {   // Http header
					      "Content-Type" : "application/json",
					      "X-HTTP-Method-Override" : "POST"
					  },
			data: JSON.stringfy({
				"userid" : userid
			}), // 보낼 데이터 
			success : function(check){ //controller check값 받기
				if(check){
					
					alert('사용 가능한 id입니다.');
					
				} else {
					
					alert('이미 사용중인 아이디입니다.');
				}
			},
			error : function(){
				
			}
		})
	}
</script>
<meta charset="UTF-8">
<title>회원 로그인</title>
</head>
<body>

</body>
</html>
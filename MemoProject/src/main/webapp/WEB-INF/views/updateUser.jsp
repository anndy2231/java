<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css" media="screen" type="text/css">    
<title>Update</title>
 	<script>
		$(document).on('click', '#submit_button', function(event){
			var pwd1 = $('input[name="pwd1"]').val();
			var pwd2 = $('input[name="pwd2"]').val();
			if (pwd1 != pwd2) {
				alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			} else {
				$('#updateUser_form').submit();
			}
		});
 	</script>
</head>

<body>
	<section class="wrap">
		<form action="updateUser_action" method="post" id="updateUser_form"><br>
			<input type="hidden" name="idx" value="${idx}" /><br>
			아이디(변경불가) : <span>${id }</span><br> 
			새 비밀번호 : <input type="password" name="pwd1" value="${pwd1}" /> <br>
			새 비밀번호 확인 :<input type="password" name="pwd2" value="${pwd2}"/><br>
			이름 : <input type="text" name="name" value="${name}" /> <br>
			생일 : <input type="text" name="birthday" value="${birthday}" /> <br>
			주소 : <input type="text" name="address" value="${address}" /> <br>
			<input type="button" value="입력 완료" id="submit_button" />
		</form>
	</section>
		<button type="button" onclick="location.href='/memoproject'">홈으로</button>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css" media="screen" type="text/css">
<title>Login</title>
</head>

<body>
	<section class="wrap">
		<h2 style="text-align:center;">비밀번호를 입력해주세요</h2>
		<form action="login2_action" method="post"> 
			<label> 비밀번호 입력: <input type="password" name="pwd" placeholder="비밀번호" /></label>
			<input type="submit" value="확인" id="" /><br>
			<div>
			<button type="button" onclick="location.href='/memoproject'">홈으로</button>
			</div>
		</form>
	</section>
</body>

</html>
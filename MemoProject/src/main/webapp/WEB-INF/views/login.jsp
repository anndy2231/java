<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/insert.css" media="screen" type="text/css"> --%>
<title>Login</title>
</head>

<body>
	<section class="wrap">
		<h2 style="text-align:center;">서비스 이용을 위하여 로그인이 필요합니다</h2>
		<form action="login_action" method="post">
			<label> 아이디 입력: <input type="text" name="id"	placeholder="아이디" /></label> 
			<label> 비밀번호 입력: <input type="password" name="pwd" placeholder="비밀번호" /></label> 
			<input type="submit" value="로그인" id="" />
			
			<div>
			<a href="/memoproject/">홈으로</a>
			</div>
		</form>
	</section>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main.css"
	media="screen" type="text/css">
<title>Main</title>
</head>

<body>
	<section class="wrap">
		<a href="list">회원 정보 확인</a>
		<a href="login2">개인 정보 수정</a>
		<a href="search">회원 조회</a>
		<a href="create_table">회원 테이블 생성</a>
	</section>
	<div class="button">
		<button type="button" onclick="location.href='/spring_login_0601/login'">로그인</button>
		<button type="button" onclick="location.href='/spring_login_0601/logout'">로그아웃</button>
		<button type="button" onclick="location.href='/spring_login_0601/insert'">회원가입</button>
	</div>

</body>

</html>
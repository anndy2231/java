<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css" media="screen" type="text/css">    
 	<title>SignUp</title>
</head>

<body>
    <section class="wrap">
        <form action="signUp_action" method="post">
            아이디 입력: <input type="text" name="id" placeholder="아이디" /> <br>
			비밀번호 입력: <input type="password" name="pwd" placeholder="비밀번호" /> <br>
			이름 입력: <input type="text" name="name" placeholder="이름" /> <br>
            나이 입력: <input type="text" name="age"placeholder="만 나이" /> <br>
			성별 입력: <input type="text" name="gender"placeholder="남성 / 여성" /> <br>
            <input type="submit" value="입력 완료" />
        </form>
           <button type="button" onclick="location.href='/finalexam'">홈으로</button>
    </section>
</body>

</html>
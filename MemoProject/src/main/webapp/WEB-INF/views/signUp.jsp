<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--  	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/insert.css" media="screen" type="text/css">     --%>
 	<title>SignUp</title>
</head>

<body>
    <section class="wrap">
        <form action="signUp_action" method="post">
            아이디 입력: <input type="text" name="id" id="" placeholder="아이디" /> <br>
			비밀번호 입력: <input type="password" name="pwd" id="" placeholder="비밀번호" /> <br>
			이름 입력: <input type="text" name="name" id="" placeholder="이름" /> <br>
            생일 입력: <input type="date" name="birthday" id="" placeholder="ex)1월 1일" /> <br>
			주소 입력: <input type="text" name="address" id="" placeholder="주소" /> <br>
            <input type="submit" value="입력 완료" id="" />
        </form>
            <a href ="/memoproject/" style="margin-top:100px;">홈으로</a>
    </section>
</body>

</html>
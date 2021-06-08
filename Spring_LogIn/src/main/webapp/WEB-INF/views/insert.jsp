<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/insert.css" media="screen" type="text/css">    
 	<title>Insert</title>
</head>

<body>
    <section class="wrap">
        <form action="insert_action" method="post">
			<input type="hidden" name="idx" value="${idx}"/>   
            <label> 아이디 입력:
                <input type="text" name="id" id="" placeholder="아이디" />
            </label>
            <label> 비밀번호 입력:
                <input type="password" name="pwd" id="" placeholder="비밀번호" />
            </label>
            <label> 이름 입력:
                <input type="text" name="user_name" id="" placeholder="이름" />
            </label>
            <label> 생일 입력:
                <input type="date" name="birthday" id="" placeholder="ex)1월 1일" />
            </label>
			<label> 주소 입력:
                <input type="text" name="address" id="" placeholder="주소" />
            </label>
            <input type="submit" value="입력 완료" id="" />
        </form>
            <a href ="/spring_login_0601" style="margin-top:100px;">홈으로</a>
    </section>
</body>

</html>
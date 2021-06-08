<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/insert.css" media="screen" type="text/css">    
 	<title>Search</title>
</head>

<body>
    <section class="wrap">
        <form action="search_action">
            <label> 이름 입력:
                <input type="text" name="user_name" id="" placeholder="이름"/>
            </label>
            <input type="submit" value="조회" id="" />
        </form>
        <a href ="/spring_login_0601" style="margin-top:100px;">홈으로</a>
    </section>
</body>

</html>
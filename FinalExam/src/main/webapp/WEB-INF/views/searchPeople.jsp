<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css" media="screen" type="text/css">    
 	<title>Search</title>
</head>

<body>
    <section class="wrap">
        <form action="searchPeople_action" method="post">
            <label> 이름 입력:
                <input type="text" name="name" placeholder="이름"/>
            </label>
            <input type="submit" value="조회" />
        </form>
        <button type="button" onclick="location.href='/finalexam'">홈으로</button>
    </section>
</body>

</html>
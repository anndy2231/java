<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css" media="screen" type="text/css">
    <title>Message</title>
</head>

<body>
    <section class="wrap" style="width: 60%; margin: 0 auto; padding: 50px;">
        <p style="padding: 20px; color: rgb(231, 126, 84); font-weight: bold; background: #eee; border-radius: 5px; text-align: center;">
            ${m1}
        </p>
        <button type="button" onclick="location.href='/memoproject'">홈으로</button>
    </section>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css" media="screen" type="text/css">
        <title>Memo_Z</title>
    </head>

    <body>
        <form action="insertMemo_action" method="post">
        <p>
         <input type="text" name="title" placeholder="제목" />
         </p>
            <textarea name="content" cols="40" rows="15" placeholder="내용"></textarea><br>
            <input type="submit" value="입력 완료" id="" />
        </form>
		<button type="button" onclick="location.href='/memoproject'">홈으로</button>
    </body>

    </html>
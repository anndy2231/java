<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Memo_Z</title>
    </head>

    <body>
        <h1>Memo_Z</h1>
        <form action="insertMemo_action" method="post">
        <p>
         <input type="text" name="title" placeholder="제목" />
         </p>
            <textarea name="content" cols="40" rows="15" placeholder="내용"></textarea>
            <p>
            <input type="submit" value="입력 완료" id="" />
            </p>
        </form>
		<a href="/memoproject/">홈으로</a>
    </body>

    </html>
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
    	<h1>Memo_Z</h1>
		    <div>
		    <a href="/memoproject/insertMemo">메모 작성하기</a><br>
		    <a href="/memoproject/memoList">메모 목록 및 관리</a><br>
		    <a href="/memoproject/updateUser">개인정보 수정</a><br>
		    <a href="/memoproject/searchUser">회원 검색</a><br>
		    <a href="/memoproject/create_table">메모 테이블 생성</a><br>
			</div>
		    <br>
		    <button type="button" onclick="location.href='/memoproject/login'">로그인</button>
		    <button type="button" onclick="location.href='/memoproject/logout'">로그아웃</button>
		    <button type="button" onclick="location.href='/memoproject/signUp'">회원가입</button>
	</body>

    </html>
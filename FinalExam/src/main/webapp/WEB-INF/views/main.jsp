<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css" media="screen" type="text/css">
        <title>People</title>
    </head>

    <body>
    	<h1>People</h1>
		    <div>
		    <a href="/finalexam/insertApartment">아파트 정보 작성하기</a><br>
		    <a href="/finalexam/apartmentList">아파트 목록 및 관리</a><br>
		    <a href="/finalexam/searchPeople">입주자 검색</a><br>
		    <a href="/finalexam/peopleList">입주자 목록 및 관리</a><br>		   
		    <a href="/finalexam/peopleStatistics">입주자 통계</a><br>		   		     
		    <a href="/finalexam/create_table">테이블 생성</a><br>
			</div>
		    <br>
		    <button type="button" onclick="location.href='/finalexam/login'">로그인</button>
		    <button type="button" onclick="location.href='/finalexam/logout'">로그아웃</button>
		    <button type="button" onclick="location.href='/finalexam/signUp'">입주자 회원가입</button>
	</body>

    </html>
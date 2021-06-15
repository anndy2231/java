<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="org.sqlite.*" %>
 
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css" media="screen" type="text/css">
<title>PeopleList2</title>
</head>

<body>
	<section class="wrap">
		전체 입주자 수 : ${total }<br>
		평균 나이 : ${avgAge }<br>
		남녀 비율 : 남성 ${man } % / 여성 ${woman } %<br>
		<button type="button" onclick="location.href='/finalexam'">홈으로</button>
	</section>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="org.sqlite.*" %>
 
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/list.css" media="screen" type="text/css">
<title>List</title>
</head>

<body>
	<section class="wrap">
		<table>
			<thead>
				<tr>
					<th>idx</th><th>ID</th><th>PWD</th><th>이름</th><th>생일</th><th>주소</th><th>생성일</th><th>수정일</th><th>정보수정</th><th>정보삭제</th>
				</tr>
			</thead>
			<tbody>
				${listInTbody}
			</tbody>
		</table>
		<a href ="/spring_login_0601/" style="margin-top:100px;">홈으로</a>
	</section>
</body>

</html>
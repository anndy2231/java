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
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/list.css" media="screen" type="text/css"> --%>
<title>List</title>
</head>

<body>
	<section class="wrap">
		<table>
			<thead>
				<tr>
<<<<<<< HEAD
					<th>idx</th><th>Title</th><th>Content</th><th>작성일</th><th>수정일</th><th>수정</th><th>삭제</th>
=======
					<th>idx</th><th>Title</th><th>Content</th><th>Created</th><th>Updated</th><th>Update</th><th>Delete</th>
>>>>>>> 1f8bc39d9efe120c11a2d348441da9dbd828c7c8
				</tr>
			</thead>
			<tbody>
				${listInTbody}
			</tbody>
		</table>
		<a href ="/memoproject/" style="margin-top:100px;">홈으로</a>
	</section>
</body>

</html>
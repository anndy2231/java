<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--  	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/insert.css" media="screen" type="text/css">     --%>
 	<title>Update</title>
</head>

<body>
    <section class="wrap">
        <form action="update_action" method="post">
        <input type="hidden" name="idx" value="${idx}"/>     
<<<<<<< HEAD
        <p>
         <input type="text" name="title" value ="${title}" />
         </p>
            <textarea name="content" cols="40" rows="15">${content}</textarea>
=======
        <p><input type="text" name="title" value ="${title}" /></p>
        <p><textarea name="content" cols="40" rows="15">${content}</textarea></p>
>>>>>>> 1f8bc39d9efe120c11a2d348441da9dbd828c7c8
            <input type="submit" value="입력 완료"  />
        </form>
    </section>
</body>

</html>
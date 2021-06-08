<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/insert.css" media="screen" type="text/css">    
 	<title>Update</title>
</head>

<body>
    <section class="wrap">
        <form action="update_action">
        <input type="hidden" name="idx" value="${idx}"/>     
            <label> 아이디는 수정 불가
				<input type="hidden" name="id" id="" placeholder="아이디" value="${id }"/>
            </label>
            <label> 비밀번호 입력:
                <input type="password" name="pwd" id="" placeholder="비밀번호" value="${pwd }"/>
            </label>
            <label> 이름 입력:
                <input type="text" name="user_name" id="" placeholder="이름" value="${nameInJspValue }"/>
            </label>
            <label> 생일 입력:
                <input type="date" name="birthday" id="" placeholder="ex)1월 1일" value="${birthday }" />
            </label>
			<label> 주소 입력:
                 <input type="text" name="address" id="" placeholder="주소" value="${address }"/>
            </label>            
            <input type="submit" value="입력 완료" id="" />
        </form>
    </section>
</body>

</html>
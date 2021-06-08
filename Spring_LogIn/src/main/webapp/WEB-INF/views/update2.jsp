<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/insert.css" media="screen" type="text/css">    
 	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
 	<title>Update</title>
 	<script>
		$(document).on('click', '#submit_button', function(event){
			var pwd1 = $('input[name="pwd1"]').val();
			var pwd2 = $('input[name="pwd2"]').val();
			if (pwd1 != pwd2) {
				alert("패스워드가 다릅니다. 다시 입력해주세요.");
			} else {
				$('#update_form').submit();
			}
		});
 	</script>
</head>

<body>
    <section class="wrap">
        <form action="update_action2" method="post" id="update_form">
        <input type="hidden" name="idx" value="${idx}"/>     
            <label> 아이디는 수정 불가
				<input type="text" name="id" id="" placeholder="아이디" value="${id }"/>
            </label>
            <label> 새 비밀번호 입력:
                <input type="password" name="pwd1" id="" placeholder="비밀번호" value="${pwd1}"/>
            </label>
            <label> 새 비밀번호 확인:
                <input type="password" name="pwd2" id="" placeholder="비밀번호" value="${pwd2}"/>
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
            <input type="button" value="수정하기" id="submit_button" />
        </form>
    </section>
</body>

</html>
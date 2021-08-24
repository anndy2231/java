<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">
<script src="<c:url value='/resources/js/jquery-3.4.1.min.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<script type="text/javaScript" language="javascript" defer="defer">
	function login(){
	   	if( $("#userId").val()==''){
			alert("아이디를 입력해주세요.");
	    	$("#userId").focus();
	    	return;
		}
	   	if( $("#password").val()==''){
			alert("비밀번호를 입력해주세요.");
	    	$("#password").focus();
	    	return;
		}
	   	
	   	var formData = new FormData();		
		formData.append('userId', $('#userId').val());
		formData.append('password', $('#password').val());
		
		var url = "<c:url value='/login_action.do'/>";
		$.ajax({
			  url: url,
			  processData: false,
			  contentType: false,
			  method: "POST",
			  cache: false,
			  data: formData
		})
		.done(function( data ) {
			if(data.returnCode == 'success') {
				alert("로그인 성공");
				location.href="/board.do";
			} else {
				alert("아이디 또는 비밀번호 불일치");
			}
		})
		.fail(function( jqXHR, textStatus, errorThrown ) {
			alert("오류");
		});
	}
	
	function cancel(){
		$('#userId').val('');
		$('#password').val('');
	}
</script>
</head>
<body>
	<div class="card">
		<h1>로그인</h1>
		<%@ include file="../jsp/layout/sessionName.jsp"%>
		<%@ include file="../jsp/layout/topButtons.jsp"%>
		<div class="card-body">
			<div class="row">
				<div class="col-lg-5">
					<div class="card bg-light text-dark" style="min-height: 500px; max-height: 1000px">
						<form id="form1" name="form1">
							
							<div class="form-group">
								<label class="control-label" for="userId">아이디:</label>
								<div>
									<input type="text" class="form-control" id="userId" placeholder="아이디를 입력하세요">
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label" for="password">비밀번호:</label>
								<div>
									<input type="password" class="form-control" rows="10" id="password" placeholder="비밀번호를 입력하세요"></input>
								</div>
							</div>

							<input type="hidden" id="id" name="id" />
						</form>
						<div style="text-align: center">
							<div class="btn-group">
								<button type="button" class="btn btn-primary" onclick="login()">로그인</button>
								<button type="button" class="btn btn-secondary"	onclick="cancel()">다시입력</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="card-footer">
			SpringBoot + MongoDB + jquery + bootstrap4 게시판 만들기
		</div>
	</div>
</body>
</html>
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
<title>UpdateUser</title>
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">
<script src="<c:url value='/resources/js/jquery-3.4.1.min.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<script type="text/javaScript" language="javascript" defer="defer">
	function update(){
	   	if( $("#name").val()==''){
			alert("이름을 입력해주세요.");
	    	$("#name").focus();
	    	return;
		}
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
	   	if( $("#password2").val()==''){
			alert("비밀번호를 한번 더 입력해주세요.");
	    	$("#password2").focus();
	    	return;
		}
	   	if( $("#password2").val()!=$("#password").val()){
			alert("비밀번호 불일치");
	    	return;
		}
	   	
	   	var formData = new FormData();		
		formData.append('id', $('#id').val());
		formData.append('name', $('#name').val());
		formData.append('userId', $('#userId').val());
		formData.append('password', $('#password').val());
		
		var url = "<c:url value='/updateUser_action.do'/>";
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
				alert("수정완료");
				document.location.href="/logout.do";
			} else {
				alert(data.returnDesc);
			}
		})
		.fail(function( jqXHR, textStatus, errorThrown ) {
			alert("오류");
		});
	}
	
	function cancel(){
		$('#name').val('');
		$('#userId').val('');
		$('#password').val('');
		$('#password2').val('');
	}
	
	function leave() {
		if( !confirm("정말 탈퇴하시겠습니까?") ){
			return;
		}
		
		var formData = new FormData();
		formData.append('id', $('#id').val());
		
		$.ajax({
			  url: "<c:url value='/leave.do'/>",
			  processData: false,
			  contentType: false,
			  method: "POST",
			  cache: false,
			  data: formData
		})
		.done(function( data ) {
			if(data.returnCode == 'success'){
				alert("탈퇴 완료");
				document.location.href="/logout.do";
			}else{
				alert(data.returnDesc);
			}
		})
		.fail(function( jqXHR, textStatus, errorThrown ) {
			alert("오류");
		});
		
	}
	
	
</script>
</head>
<body>
	<div class="card">
		<h1>회원정보수정</h1>
		<%@ include file="../jsp/layout/sessionName.jsp"%>
		<%@ include file="../jsp/layout/topButtons.jsp"%>
		
		<div class="card-body">
			<div class="row">
				<div class="col-lg-5">
					<div class="card bg-light text-dark" style="min-height: 500px; max-height: 1000px">
						<form id="form1" name="form1">
						
							<div class="form-group">
								<label class="control-label" for="userId">아이디 변경 불가</label>
								<div>
									<input type="text" class="form-control" id="userId" value="${userId }" readonly></input>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label" for="name">이름:</label>
								<div>
									<input class="form-control" rows="10" id="name" value="${name}" placeholder="이름을 입력하세요" ></input>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label" for="password">비밀번호:</label>
								<div>
									<input type="password" class="form-control" rows="10" id="password" placeholder="비밀번호를 입력하세요"></input>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label" for="password2">비밀번호 확인:</label>
								<div>
									<input type="password" class="form-control" rows="10" id="password2" placeholder="비밀번호를 한번 더 입력하세요"></input>
								</div>
							</div>

							<input type="hidden" id="id" name="id" />
						</form>
						<div style="text-align: center">
							<div class="btn-group">
								<button type="button" class="btn btn-primary" onclick="update()">정보수정</button>
								<button type="button" class="btn btn-secondary"	onclick="cancel()">다시입력</button>
								<button type="button" class="btn btn-danger" onclick="leave()">회원탈퇴</button>
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
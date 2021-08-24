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
<title>BoardMongoDB</title>
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">
<script src="<c:url value='/resources/js/jquery-3.4.1.min.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
<script type="text/javaScript" language="javascript" defer="defer">

	<% request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String title = request.getParameter("title");
	String contents = request.getParameter("contents");
	String fname = request.getParameter("fname");
	%>
	
	$(function() {
		getImg("<%=fname%>");
	});
		
	function getImg(fname){
		//alert(fname);
		$.ajax({
			  url: "<c:url value='/img.do'/>?fname="+encodeURI(fname),
			  processData: false,
			  contentType: false,
			  method: "GET",
			  cache: false,
			  data: ''
		})
		.done(function( data ) {
			if( data == "" ){
				$('#img').attr("src", "");
			}else{
				$('#img').attr("src", "data:image/jpeg;base64,"+data);
			}
		})
		.fail(function( jqXHR, textStatus, errorThrown ) {
			alert("오류");
		})
	}
	
	function save() {
		
		if( !confirm("저장하시겠습니까?") ){
			return;
		}
		
		var formData = new FormData();		
		formData.append('id', $('#id').val());
		formData.append('title', $('#title').val());
		formData.append('contents', $('#contents').val());
		formData.append('file', $('#file')[0].files[0]);
		
		var url = "<c:url value='/add.do'/>";
		if( $('#id').val() == '' ){
			url = "<c:url value='/add.do'/>";
		} else {
			url = "<c:url value='/mod.do'/>";
			location.href="/board.do";
		}
		
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
				list();
			} else {
				alert(data.returnDesc);
			}
		})
		.fail(function( jqXHR, textStatus, errorThrown ) {
			alert("오류");
		})
	}
	
	function reply() {
		alert("reply");
	}
	
	function cancel() {
		$('#id').val('');
		$('#title').val('');
		$('#contents').val('');
		$('#img').attr("src", "");
	}
	
	function del(){
		if( $('#id').val() == '' ){
			alert("삭제할 데이터가 없습니다.");
		}
		if( !confirm("삭제하시겠습니까?") ){
			return;
		}
		
		var formData = new FormData();
		formData.append('id', $('#id').val());
		
		$.ajax({
			  url: "<c:url value='/del.do'/>",
			  processData: false,
			  contentType: false,
			  method: "POST",
			  cache: false,
			  //data: $('#form1').serialize()
			  data: formData
		})
		.done(function( data ) {
			if(data.returnCode == 'success'){
				location.href="/board.do";
			}else{
				alert(data.returnDesc);
			}
		})
		.fail(function( jqXHR, textStatus, errorThrown ) {
			alert("오류");
		})
	}
	
	function delimg() {
		if( $('#id').val() == '' ){
			alert("삭제할 데이터가 없습니다.");
		}
		if( !confirm("그림을 삭제하시겠습니까?") ){
			return;
		}
		
		var formData = new FormData();
		formData.append('id', $('#id').val());
		
		$.ajax({
			  url: "<c:url value='/delimg.do'/>",
			  processData: false,
			  contentType: false,
			  method: "POST",
			  cache: false,
			  data: formData
		})
		.done(function( data ) {
			if(data.returnCode == 'success'){
				location.href="/board.do";
			}else{
				alert(data.returnDesc);
			}
		})
		.fail(function( jqXHR, textStatus, errorThrown ) {
			alert("오류");
		})
	}
	
</script>
</head>
<body>
	<div class="card">
		<h1>BoardMongoDB</h1>
		<%@ include file="../jsp/layout/sessionName.jsp"%>
		<%@ include file="../jsp/layout/topButtons.jsp"%>
		
		<div class="card-body">
			<div class="row">
				<div class="col-lg-5">
					<div class="card bg-light text-dark" style="min-height: 500px; max-height: 1000px">
						<form id="form1" name="form1" action="">
							<div class="form-group">
								<label class="control-label" for="title">제목:</label>
								<div>
									<input type="text" class="form-control" id="title" value="<%=title%>" >
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="contents">내용:</label>
								<div>
									<textarea class="form-control" rows="10" id="contents"><%=contents%></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label">이미지첨부: jpg,gif,png</label>
								<div>
									<input type="file" class="form-control" id="file" name="file" style="width: 90%" />
								</div>
							</div>
							<input type="hidden" id="id" name="id" value="<%=id%>"/>
						</form>
						<div style="text-align: center">
							<div class="btn-group">
								<button type="button" class="btn btn-primary" onclick="save()">저장</button>
								<button type="button" class="btn btn-secondary"	onclick="cancel()">취소</button>
								<button type="button" class="btn btn-danger" onclick="del()">삭제</button>
								<button type="button" class="btn btn-info" onclick="delimg()">그림삭제</button>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<form id="form2" name="form2">
						<div class="card" style="min-height: 500px; max-height: 1000px">
							<div class="form-group">
								<label class="control-label" for="writer">댓글</label>
								<div>
									<input type="text" class="form-control" id="writer" placeholder="작성자">
								</div>
							</div>
							<div>
								<textarea class="form-control" rows="5" id="replyContents" placeholder="내용"></textarea>
							</div>
							<div style="text-align: center">
								<button type="button" class="btn btn-primary" onclick="reply()">댓글 입력</button>
							</div>
						</div>
					</form>
				</div>
				<div class="col-lg-3">
					<div class="card bg-light text-dark" style="min-height: 500px; max-height: 1000px">
						<img src="" id="img" alt="이미지" style="max-width:100%">
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
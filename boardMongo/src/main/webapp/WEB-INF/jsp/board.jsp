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
	$(function() {
		list();
	});
	
	function list(){
		$.ajax({
			  url: "<c:url value='/list.do'/>",
			  processData: false,
			  contentType: false,
			  method: "GET",
			  cache: false,
			  data: ''
		})
		.done(function( data ) {
			for(var i=0; i < data.list.length; i++){
				
				var contents = data.list[i].contents;
				contents = contents.replace(/\n/gi,'\\n');
				
				var txt = "<tr onclick=\"view('"+data.list[i].id+"','"+data.list[i].title+"','"+contents+"','"+data.list[i].fname+"');\">";
		        txt += "<td>"+ data.list[i].title +"<span style=\"float:right\">"+ data.list[i].date +"</span></a></td>";
		      	txt += "</tr>";
		      	$('#list').append(txt);
			}
		})
		.fail(function( jqXHR, textStatus, errorThrown ) {
			alert("오류");
		})
	}

	function view(id, title, contents, fname){
		location.href = "<c:url value='/boardContents.do'/>?id="+id+"&title="+title+"&contents="+contents+"&fname="+fname;
	}
	
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

	function save(){
		location.href = "<c:url value='/boardWrite.do'/>"
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
				<div class="col-lg-4">
					<div class="card" style="min-height: 500px; max-height: 1000px">
						<table class="table">
							<thead>
								<tr>
									<th>게시물 리스트</th>
								</tr>
							</thead>
							<tbody style="cursor:pointer" id="list">
							</tbody>
						</table>
					</div>
					<c:if test="${!empty sessionScope.userId }">
					<div class="btn-group" style="text-align: center">
						<button type="button" class="btn btn-primary" onclick="save()">작성</button>
					</div>
					</c:if>
				</div>
			</div>
		</div>
		<div class="card-footer">
			SpringBoot + MongoDB + jquery + bootstrap4 게시판 만들기
		</div>
	</div>
</body>
</html>
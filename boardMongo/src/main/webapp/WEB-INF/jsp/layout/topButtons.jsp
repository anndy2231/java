<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card-header">
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link" href="<c:url value='/board.do'/>">게시판</a></li>
		<%-- <li class="nav-item"><a class="nav-link" href="<c:url value='/board2.do'/>">멀티이미지 게시판</a></li> --%>
		<li class="nav-item"><c:if test="${empty sessionScope.userId }"><a class="nav-link" href="<c:url value='/login.do'/>">로그인</a></c:if></li>
		<li class="nav-item"><c:if test="${!empty sessionScope.userId }"><a class="nav-link" href="<c:url value='/logout.do'/>">로그아웃</a></c:if></li>
		<li class="nav-item"><a class="nav-link" href="<c:url value='/signup.do'/>">회원가입</a></li>
		<li class="nav-item"><c:if test="${!empty sessionScope.userId }"><a class="nav-link" href="<c:url value='/updateUser.do'/>">회원정보수정</a></c:if></li>
	</ul>
</div>
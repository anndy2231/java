<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4>
	<c:if test = "${sessionScope.name !=null && sessionScope.name !='' }">
		${sessionScope.name}님 환영합니다.
	</c:if>
</h4>
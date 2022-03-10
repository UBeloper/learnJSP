<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<c:choose>
<c:when test="${!empty a_id}">
<h1>
	Hello ${a_id}! 
	<a href="/admin/logout">로그아웃</a>
	</h1>
</c:when>
<c:otherwise>
<h1>
	Hello Guest!
	<a href="/admin/login">로그인</a> 
</h1>
</c:otherwise>
</c:choose>


<P>  The time on the server is ${serverTime}. </P>
</body>
</html>

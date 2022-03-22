<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	
	<form action="/login" method="post">
		<input type="text" name="m_id">
		<input type="password" name="m_passwd">
		<input type="submit" value="로그인">
	</form>		
	
</body>
</html>

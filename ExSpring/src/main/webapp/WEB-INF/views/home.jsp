<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<div>
	<a href="">장바구니로</a>
	<a href="">장바구니로</a>
	</div>
	
	<table>
		<tr>
			<th>상품코드</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>등록일</th>
		</tr>
		<c:forEach items="${product}" var="product">
		<tr>
			<td>${product.p_code}</td>
			<td>${product.p_name}</td>
			<td>${product.p_price}</td>
			<td>${product.p_rdate}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>

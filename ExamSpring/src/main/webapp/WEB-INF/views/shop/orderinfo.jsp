<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>

<div style="width: 100%">
	<button type="button" class="btn btn-light"
		style="float: right; margin: 1rem 2rem;">
		<a href="/shop/deleteall?cm_code=${cm_code}">모두 삭제</a>
	</button>
	<button type="button" class="btn btn-light"
		style="float: right; margin: 1rem 2rem;">
		<a href="/shop/orderinfo?cm_code=${cm_code}">상품 주문</a>
	</button>

	<button type="button" class="btn btn-light"
		style="float: right; margin: 1rem 2rem;">
		총 금액 :
		<fmt:formatNumber value="${cartmember.cm_total}" pattern="#,###"></fmt:formatNumber>
	</button>
</div>

<table class="table" style="text-align: center">
	<thead>
		<tr>
			<th scope="col">주문번호</th>
			<th scope="col">상품명</th>
			<th scope="col">상품가격</th>
			<th scope="col">수량</th>
			<th scope="col">합계</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="list">
			<tr>
				<th scope="row">${list.os_code}</th>
				<td><a
					href="http://localhost:8088/resources/product/${list.p_code}.jpg">${list.p_name}</a></td>
				<td>${list.p_price}</td>
				<td>${list.os_cnt}</td>
				<td>${list.os_money}</td>
				<td>
					<button><a href="/shop/cartdelete?cm_code=${cm_code}&os_code=${list.os_code}">삭제</a></button>
				</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="../include/footer.jsp"%>
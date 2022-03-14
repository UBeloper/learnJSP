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
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="list">
			<tr>
				<th scope="row">${list.cs_code}</th>
				<td><a
					href="http://localhost:8088/resources/product/${list.p_code}.jpg">${list.p_name}</a></td>
				<td>${list.p_price}</td>
				<td>
				
				<form action="/shop/cartupdate" method="post">
					<input type="hidden" name="cs_code" value="${list.cs_code}">
					<select name="cs_cnt">
						<c:forEach var="count" begin="1" end="30" step="1">
							<c:if test="${count == list.cs_cnt}">
								<option value="${count}" selected>${count}</option>
							</c:if>
							<c:if test="${count != list.cs_cnt}">
								<option value="${count}">${count}</option>
							</c:if>
							<!-- if구문은 else가 없어서 choose when으로 otherwise가 있는 문법을 쓰는게 좋다. -->
						</c:forEach>
					</select> 
					<input type="submit" value="수정">
				</form>
				</td>
				
				<td>
					<button><a href="/shop/cartdelete?cm_code=${cm_code}&cs_code=${list.cs_code}">삭제</a></button>
				</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="../include/footer.jsp"%>
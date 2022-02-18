<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">장바구니 리스트</h1>
	<p class="mb-4"></p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">
				<a href="/shop/list">상품 리스트</a>
			</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th>상품이름</th>
							<th>상품코드</th>
							<th>이미지</th>
							<th>가격</th>
							<th>수량</th>
							<th>금액</th>
						</tr>
					</thead>
					
					<tbody>
					
						<c:forEach items="${list}" var="cartsub">
							<tr>
								<td>${cartsub.p_name}</td>
								<td>${cartsub.p_code}</td>
								<td><img src="/resources/product/${cartsub.p_code}.jpg" height="50"></td>
								<td>${cartsub.p_price}</td>
								<td>${cartsub.cs_cnt}</td>
								<td>${cartsub.cs_money}</td>
							</tr>
						</c:forEach>
							<tr>
								<th colspan="6" style="text-align:center"> ${cartmember.m_name} 님, 
								총금액 : 
								<fmt:formatNumber value="${cartmember.cm_total}" pattern="#,###"></fmt:formatNumber>
								<%-- 아니면 이렇게도 가능 <fmt: value="" pattern="" /> --%>
								</th>
							</tr>

					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->
<%@include file="../include/footer.jsp"%>

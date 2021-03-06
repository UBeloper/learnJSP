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
								<td><img src="/resources/product/${cartsub.p_code}.jpg"
									height="50"></td>
								<td>${cartsub.p_price}</td>
								
								<td>
								
									<form action="/shop/cartupdate" method="post">
									<input type="hidden" name="cs_code" value="${cartsub.cs_code}">
									<select name="cs_cnt">
										<c:forEach var="count" begin="1" end="30" step="1">
											<c:if test="${count == cartsub.cs_cnt}">
												<option value="${count}" selected>${count}</option>
											</c:if>
											<c:if test="${count != cartsub.cs_cnt}">
												<option value="${count}">${count}</option>
											</c:if>
											<!-- if구문은 else가 없어서 choose when으로 otherwise가 있는 문법을 쓰는게 좋다. -->
										</c:forEach>
									</select>
									<input type="submit" value="수정">
									</form>
									&nbsp;<a href="/shop/cartdelete?cs_code=${cartsub.cs_code}&cm_code=${cm_code}">삭제</a>
									
								</td>
								
								<td>${cartsub.cs_money}</td>
							</tr>
						</c:forEach>

						<tr>
							<th colspan="6" style="text-align: center">
								회원 ${cartmember.m_name} 님, 장바구니번호 : ${cm_code}, 총금액 : <fmt:formatNumber
									value="${cartmember.cm_total}" pattern="#,###"></fmt:formatNumber>원
								<%-- 아니면 이렇게도 가능 <fmt: value="" pattern="" /> --%>
							
							<c:if test="${not empty cm_code}">
								<a href="/shop/cartdeleteall?cm_code=${cm_code}">상품 모두 삭제</a>
								<a href="/shop/orderinfo?cm_code=${cm_code}">상품 주문</a>
							</c:if>
							
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

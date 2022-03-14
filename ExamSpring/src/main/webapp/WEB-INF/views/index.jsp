<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="./include/header.jsp"%>

<!-- Section-->
<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div
			class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

			<c:forEach items="${list}" var="list">

				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<div class="badge bg-dark text-white position-absolute"
							style="top: 0.5rem; right: 0.5rem">Sale</div>

						<!-- Product image-->
						<img class="card-img-top"
							src="http://localhost:8088/resources/product/${list.p_code}.jpg"
							alt="..." / height=200>


						<!-- Product details-->

						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">${list.p_name}</h5>
								<!-- Product price-->
								<fmt:formatNumber type="number" maxFractionDigits="3"
									value="${list.p_price}" />
								원
							</div>
						</div>

						<!-- Product actions-->
						<form action="/shop/cart" method="post">
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<input type="hidden" name="p_code" value="${list.p_code}">
								
								<div class="text-center">
								<select name="cs_cnt">
									<c:forEach var="count" begin="1" end="30" step="1">
										<option value="${count}">${count}개</option>
									</c:forEach>
								</select>
									<input type="submit" class="btn btn-outline-dark mt-auto"
										value="Add to cart">
								</div>
							</div>
						</form>
					</div>
				</div>

			</c:forEach>


		</div>
	</div>
</section>

<%@ include file="./include/footer.jsp"%>
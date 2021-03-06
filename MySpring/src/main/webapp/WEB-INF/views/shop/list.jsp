<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../include/header.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">shop 리스트</h1>
	<p class="mb-4"></p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">
				<a href="/product/insert">상품등록</a>
				<a href="/shop/cartinfo">장바구니로</a>
			</h6>
		</div>
		
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" width="100%" cellspacing="0">
					<!-- 	
                                <thead>
                                        <tr>
                                            <th>상품코드</th>
                                            <th>상품명</th>
                                            <th>단가</th>
                                            <th>이미지</th>
                                            <th>작성일</th>
                                            <th>수정일</th>
                                        </tr>
                                    </thead>
                                    -->

					<tbody>
						<!-- 변수이름 cnt, 초기값 0 -->
						<c:set var="cnt" value="0" />
						<c:forEach items="${list}" var="product">
							<c:choose>
								<c:when test="${cnt % 3 == 0}">
									<!-- test = keyword -->
									<!-- like switch-case -->
									<tr>
										<td>
											<table border=1>
												<tr>
													<th>${product.p_code}</th>
												</tr>
												<tr>
													<td>${product.p_name}</td>
												</tr>
												<tr>
													<td><img
														src="/resources/product/${product.p_code}.jpg" height=50></td>
												</tr>
												<tr>
													<td>${product.p_price}</td>
												</tr>
												<!--  -->
											<tr>
												<td>
													<form method="post" action="/shop/cart">
														<input type="hidden" name="p_code"
															value="${product.p_code}"> 
															<select name="cs_cnt">
																<c:forEach var="count" begin="1" end="30" step="1">
																<%-- step은 1씩 늘어나면 생략가능 --%>
																	<option value="${count}">${count}개</option>
																</c:forEach>
														</select>
														&nbsp;&nbsp;
														<input type="submit" value="장바구니">
													</form>
												</td>
											</tr>
											<!--  -->
											</table>
										</td>
								</c:when>

								<c:when test="${cnt % 3 == 2}">
									<td>
										<table border=1>
											<tr>
												<th>${product.p_code}</th>
											</tr>
											<tr>
												<td>${product.p_name}</td>
											</tr>
											<tr>
												<td><img src="/resources/product/${product.p_code}.jpg"
													height=50></td>
											</tr>
											<tr>
												<td>${product.p_price}</td>
											</tr>
											<!--  -->
											<tr>
												<td>
													<form method="post" action="/shop/cart">
														<input type="hidden" name="p_code"
															value="${product.p_code}"> 
															<select name="cs_cnt">
																<c:forEach var="count" begin="1" end="30" step="1">
																<%-- step은 1씩 늘어나면 생략가능 --%>
																	<option value="${count}">${count}개</option>
																</c:forEach>
														</select>
														&nbsp;&nbsp;
														<input type="submit" value="장바구니">
													</form>
												</td>
											</tr>
											<!--  -->
										</table>
									</td>
									</tr>
								</c:when>

								<c:otherwise>
									<td>
										<table border=1>
											<tr>
												<th>${product.p_code}</th>
											</tr>
											<tr>
												<td>${product.p_name}</td>
											</tr>
											<tr>
												<td><img src="/resources/product/${product.p_code}.jpg"
													height=50></td>
											</tr>
											<tr>
												<td>${product.p_price}</td>
											</tr>
											<!--  -->
											<tr>
												<td>
													<form method="post" action="/shop/cart">
														<input type="hidden" name="p_code"
															value="${product.p_code}"> 
															<select name="cs_cnt">
																<c:forEach var="count" begin="1" end="30" step="1">
																<%-- step은 1씩 늘어나면 생략가능 --%>
																	<option value="${count}">${count}개</option>
																</c:forEach>
														</select>
														&nbsp;&nbsp;
														<input type="submit" value="장바구니">
													</form>
												</td>
											</tr>
											<!--  -->
										</table>
									</td>
								</c:otherwise>
							</c:choose>

							<c:set var="cnt" value="${cnt+1}" />
							<!-- cnt = cnt + 1 -->
						</c:forEach>




						<!--  
                                    	<c:forEach items="${list}" var="product">
                                    		<tr>
                                    			<td>${product.p_code}</td>
                                    			<td><a href="/product/view?p_code=${product.p_code}">${product.p_name}</a></td>
                                    			<td>${product.p_price}</td>
                                    			<td><img src="/resources/product/${product.p_code}.jpg" height="50"></td>
                                    			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${product.p_rdate}"/>
                                    			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${product.p_udate}"/>
                                    		</tr>
                                    	</c:forEach>
                                    	-->

					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->
<%@include file="../include/footer.jsp"%>

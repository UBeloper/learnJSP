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
					<tbody>
					
					
				<%-- <c:forEach items="${list}" var="product">
                                    		<tr>
                                    			<td>${product.p_code}</td>
                                    			<td><a href="/product/view?p_code=${product.p_code}">${product.p_name}</a></td>
                                    			<td>${product.p_price}</td>
                                    			<td><img src="/resources/product/${product.p_code}.jpg" height="50"></td>
                                    			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${product.p_rdate}"/>
                                    			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${product.p_udate}"/>
                                    		</tr>
                                    	</c:forEach> --%> 
                                   

					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->
<%@include file="../include/footer.jsp"%>
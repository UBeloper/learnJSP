<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script>
	function ImgWinOpen(p_code) {
		window.open("/product/imgupload?p_code="+p_code, "", "width=500,height=200,toolbar=no,menubar=no,status=no,scrollbars=no");
	}
</script>

<form action="/product/view" method="post">
	<fieldset>
		<legend>상품세부사항</legend>
		<div class="mb-3">
			<label for="disabledTextInput" class="form-label">상품코드</label> <input
				type="text" id="disabledTextInput" class="form-control"
				value="${product.p_code}" readonly>
		</div>

		<div class="mb-3">
			<label for="disabledTextInput" class="form-label">상품명</label> 
			<input
				type="text" class="form-control" value="${product.p_name}">
		</div>

		<div class="mb-3">
			<label for="disabledTextInput" class="form-label">상품가격</label> 
			<input
				type="text" class="form-control" value="${product.p_price}">
		</div>

		<div class="mb-3">
			<label for="disabledTextInput" class="form-label">상품이미지</label> 
			<img src="/resources/product/${product.p_code}.jpg" height="200">
		</div>

		<div class="mb-3">
			<label for="disabledTextInput" class="form-label">이미지등록</label> 
			<input 
					type="button" value="이미지등록"
					class="form-control" onclick="ImgWinOpen('${product.p_code}')">
		</div>

		<button type="submit" class="btn btn-primary">수정</button>
		<button type="button" class="btn btn-secondary">삭제</button>
		<button type="button" class="btn btn-primary"><a href="/product/list">상품리스트</a></button>
	</fieldset>
</form>

<%@ include file="../include/footer.jsp"%>
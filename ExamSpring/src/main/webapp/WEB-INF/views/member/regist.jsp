<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>

<!-- Section-->
<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div
			class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

			<!-- 로그인 폼 -->
			<form action="/member/regist" method="post">
				<div class="mb-3">
					<label for="userid" class="form-label">User ID</label> 
					<input type="text" class="form-control"
						id="userid" name="m_id">
				</div>

				<div class="mb-3">
					<label for="userid" class="form-label">User Name</label> 
					<input type="text" class="form-control"
						id="userid" name="m_name">
				</div>
				
				<div class="mb-3">
					<label for="userpasswd" class="form-label">Password</label>
					<input type="password" class="form-control"
						id="userpasswd" name="m_passwd">
				</div>
				
				<button type="submit" class="btn btn-primary">회원가입</button>
				<a href="/member/login">이미 가입하셨나요?</a>
			</form>


		</div>
	</div>
</section>

<%@ include file="../include/footer.jsp"%>
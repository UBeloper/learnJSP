<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>

<div style="width:100%">
<button type="button" class="btn btn-light" style="float:right; margin:1rem 3rem;">
<a href="/product/insert">상품 등록</a></button>
</div>
<table class="table" style="text-align:center">
  <thead>
  	<tr>
      <th scope="col">상품코드</th>
      <th scope="col">상풍명</th>
      <th scope="col">상품가격</th>
      <th scope="col">상품등록일</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="list">
    <tr>
      <th scope="row">${list.p_code}</th>
      <td><a href="/product/view?p_code=${list.p_code}">${list.p_name}</a></td>
      <td>${list.p_price}</td>
      <td>${list.p_rdate}</td>
    </tr>
   </c:forEach>
  </tbody>
</table>

<%@ include file="../include/footer.jsp"%>
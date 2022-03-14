<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>

<div style="width:100%">
<button type="button" class="btn btn-light" style="float:right; margin:1rem 3rem;">유저리스트</button>
</div>
<table class="table" style="text-align:center">
  <thead>
  	<tr>
      <th scope="col">아이디</th>
      <th scope="col">이름</th>
      <th scope="col">등록일</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="list">
    <tr>
      <th scope="row">${list.m_id}</th>
      <td>${list.m_name}</td>
      <td>${list.m_rdate}</td>
      <td><a href="/member/delete?m_id=${list.m_id}">유저 삭제</a></td>
    </tr>
   </c:forEach>
  </tbody>
</table>

<%@ include file="../include/footer.jsp"%>
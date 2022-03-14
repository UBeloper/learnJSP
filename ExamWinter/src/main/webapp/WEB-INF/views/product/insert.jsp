<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>
<br>
<h1> 상품등록 </h1>
<div class="table-responsive">

                            <form method="post" action="/product/insert">
                            <br>

                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    	<label>상품명</label>
                                    	<input type="text" class="form-control" name="p_name">
                                    </div>
                                </div>
                                
								<div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                    	<label>상품가격</label>
                                        <input type="text" class="form-control" name="p_price">
                                    </div>
                                </div>
                                                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="submit" class="form-control" value="등록">
                                    </div>
                                </div>
                            </form>
                            </div>

<%@ include file="../include/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>TEST</title>
</head>
<body>

<h1>JSTL</h1>

<h3>==변수설정==</h3>
<%-- <c:set var="mynum" value="100"></c:set> --%>
<%-- <c:set .... /> 도 가능 --%> 

<h4>${mynum}</h4>
<h4><c:out value="${mynum}" /></h4> <!-- 결과 동일 -->


<h3>==제어구조==</h3>
<c:choose> 
	<c:when test="${mynum%2 == 0}"> 
		<h4>${mynum}은 짝수입니다.</h4>
	</c:when>
	<c:otherwise>
		<h4>${mynum}은 홀수입니다.</h4>
	</c:otherwise>
</c:choose>


<h3>==구구단==</h3>
<c:forEach var="i" begin="1" end="9">
	<c:forEach var="j" begin="1" end="9">
		${i} x ${j} = ${i * j} &nbsp;
	</c:forEach>
	<br>
</c:forEach>

<!-- 
JSTL은 에러가 나더라도 노출될 위험 X <- 스프링에서 JSTL을 사용하도록 권장
JSP은 에러가 나면 코드의 상황들이 노출이되기 때문에 보안상 위험이 있다. 
-->

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 자바 문법 적용 영역
	out.print("안녕하세요" + "<br>");
	out.print("웹프로그래밍입니다.<br>");
	out.print("&lt;br&gt;");
	out.print("<h1>JSP프로그래밍</h1>");
	int i;
	int total = 0;
	for (i = 1; i <= 10; i++) {
		total += i;
	}
	out.print("1~10까지의 합은 " + total + "<br>");
	
%>
</body>
</html>
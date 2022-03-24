<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form method="post" action="/check">
	<c:if test="${check.check == 1}">
		<input type="checkbox" name="check" value="1" checked>
	</c:if>
	<input type="checkbox" name="check" false-value="0" true-value="1">	
	<input type="submit" value="check">
</form>

<h1>${check}</h1>

</body>
</html>

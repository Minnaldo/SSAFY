<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${result }" var="sum" varStatus="cnt">
		# ${cnt.count }
		<label for="op1">a</label>
		<input id="op1" type="text" value="${sum.aaa }">
		+<label for="op2">b</label>
		<input id="op2" type="text" value="${sum.bbb }">
		<label for="sum">=</label>
		<input id="op2" type="text" value="${sum.sum }"> <br>
		
	</c:forEach>

</body>
</html>
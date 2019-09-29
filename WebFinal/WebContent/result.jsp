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
	<c:forEach items="${calc }" var="sum" varStatus="cnt">
	<label># ${cnt.count }</label>
	<label for="op1"></label>
		op1 <input type="number" id="op1" value="${sum.a }">
	<label for="op2"></label>	
		op2 <input type="number" id="op2" value="${sum.b }">
	<label for="sum"></label>		
		= sum <input type="number" id="sum" value="${sum.sum }"> <br>
	</c:forEach>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, edu.ssafy.Calc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- items 안 적어주면 에러남 -->
	<c:forEach items="${sum }" var="sum" varStatus="cnt">
		<c:if test="${sum.sum > 1 }">		<!-- lt : >  rt : < -->
			
			<label># ${cnt.count }</label>
			<label for="op1">op1</label>
			<!-- EL적용 -->
			<input id = "op1" type="number" value="${sum.op1 }" readonly = "readonly">
			+
			<label for = "op2">op2</label>
			<input id = "op2" type="number" value="${sum.op2 }" readonly = "readonly">
			=
			<input id = "sum" type="number" value="${sum.sum }" readonly = "readonly">
			<br>
		</c:if>
	</c:forEach>
</body>
</html>
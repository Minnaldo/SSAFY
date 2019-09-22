<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! %>
<% String result = (String)request.getAttribute("result"); 
	if(result == null)
	{
		result = request.getParameter("result");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 결 과 화 면 </title>
</head>
<body>
	<h1>상품 등록 결과</h1>
	<h2><%= result %></h2>
	
	<a href="index.html">초기화면</a>
	<a href="main.do?action=listmem">상품리스트</a>
</body>
</html>
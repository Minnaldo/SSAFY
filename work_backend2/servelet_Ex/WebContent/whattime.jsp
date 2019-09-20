<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

현재시간 : <%=new Date().getHours()%>:<%=new Date().getMinutes() %>:<%=new Date().getSeconds() %>
<p>

<%
	if(new Date().getHours() == 12)
	{
%>
		밥시간
<% 
	}
	else{
%>
	밥시간 아님ㅋ
<%
	}
%>

</body>
</html>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>

<%! String name = "홍길동";
	ArrayList list= new ArrayList();
	public String print(){
    return name;
	}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg = (String)request.getAttribute("msg");
		/* String passwd = (String)request.getAttribute("passwd"); */
	%>
	
	<h1> <%= msg %> </h1>
	<a href="login.html">login</a>
	<%-- <%= id %> <br>
	<%= passwd %> <br>
	<%= print() %> --%>
</body>
</html>
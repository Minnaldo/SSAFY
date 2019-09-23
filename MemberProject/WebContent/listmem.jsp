<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, edu.ssafy.model.MemVo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% ArrayList<MemVo> list = (ArrayList<MemVo>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
<style type="text/css">


body {
	width: 300px;
	margin: 0 auto;
}

table {
	border: 1px solid #000
	

}
</style>
<script type="text/javascript">
	function search() {
		var keyword = namefield.value;
		location.href = "main.do?action=namefind&keyword=" + keyword;
	};
	function logout() {
		location.href = "main.do?action=logout";
	};
</script>
</head>
<body>
	<jsp:include page="logout.jsp"></jsp:include>
	<div align="center">
		<h1>회원 목록</h1>
		
		<!-- border(테두리) -->
		<table border="1">
			<tr> <th>아이디 </th> 
				<th>이름 </th> 
				<th>주소 </th> 
				<th>나이 </th> 
				<th>전화번호 </th>  
			</tr>
			
		<%-- 	<% for(int i = 0; i < list.size(); i++) { %>
			<tr><td><%= list.get(i).getId()%></td>   
				<td><a href="main.do?action=meminfo&uid=<%= list.get(i).getId() %>"> <%=list.get(i).getName() %> </a></td>	
				<td><%=list.get(i).getAddr()%></td> 	
				<td><%=list.get(i).getAge()%></td>	
				<td><%=list.get(i).getTel()%></td>		
			</tr>
			<% } %> --%>
			
			<c:forEach items="${list}" var="memvo">
				<tr>
					<td>${memvo.id} </td>
					<td><a href="main.do?action=meminfo&uid=${memvo.id}">${memvo.name} </a> </td>
					<td>${memvo.addr } </td>
					<td>${memvo.age } </td>
					<td>${memvo.tel } </td>
				</tr>
			</c:forEach>
			
		</table>
		<input type="text" name="namefield" id="namefield"><input type="button" onclick="search()" value="검색"><br>
		<a href="index.html">초기화면</a>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, edu.ssafy.model.MemVo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% ArrayList<MemVo> list = (ArrayList<MemVo>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 조회</title>
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
	function deletemem() {
		var id = namefield.value;
		/* location.href = "main.do?action=deletemem?pid=" + id; */
		alert(id);
		location.href = "main.do?action=deletemem&uid=" + id;
	};
</script>
</head>
<body>
	<div align="center">
		<h1>상품 목록</h1>
		
		<!-- border(테두리) -->
		<table border="1">
			<tr> <th>상품번호 </th> 
				<th>상품명 </th> 
				<th>수량 </th> 
				<th>가격 </th> 
			</tr>
			<tr>
      			<td colspan="4" bgcolor="pink"></td>
	        </tr>
			<%-- <% for(int i = 0; i < list.size(); i++) { %>
			<tr><td><%= list.get(i).getId()%></td>   
				<td><a href="main.do?action=meminfo&uid=<%= list.get(i).getId() %>"> <%=list.get(i).getId() %> </a></td>	
				<td><%=list.get(i).getName()%></td> 	
				<td><%=list.get(i).getQuantity()%></td>	
				<td><%=list.get(i).getPrice()%></td>		
			</tr>
			<% } %> --%>
			<c:forEach items="${list}" var="mem">
		         <tr>
		            <td><a href="main.do?action=listmem&uid=${mem.id}">${mem.id}</a></td>
		            <td>${mem.name}</td>
		            <td>${mem.quantity}</td>
		            <td>${mem.price}</td>
		         </tr>
		    </c:forEach>
		</table>
		
		
		<td colspan="2">
			<input type="text" name="namefield" id="namefield" value = "${param.uid }">
			<input type="button" onclick="search()" value="검색">
			<input type="button" onclick="deletemem()" value="삭제">
		</td>
			<br> <a href="index.html">초기화면</a>
	</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="edu.ssafy.model.MemVo" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
	
<% MemVo mem = (MemVo)request.getAttribute("mem"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 조회</title>
<script type="text/javascript">
	function updatemem() {
		rform.submit();
	}
	function deletemem() {
		var id = pid.value;
		/* location.href = "main.do?action=deletemem?pid=" + id; */
		alert(id);
		location.href = "main.do?action=deletemem&pid="+id;
	}
</script>
</head>
<body>
	<div align="center">
		<h1>상품정보</h1>
		<form action="main.do?action=updatemem" method="post" id="rform">
			<table>
				<table>
			<tr>
				<td>아이디: </td>
				<td><input type="text" name="pid" id="pid"> </td>
			</tr>
			<tr>	
				<td>이름: </td>
				<td><input type="text" name="pname" id="pname"> </td>
			</tr>
			<tr>
				<td>수량: </td>
				<td><input type="text" name="pquantity" id="pquantity"> </td>
			</tr>
			<tr>
				<td>가격: </td>
				<td><input type="number" name="pprice" id="pprice"> </td>
			</tr>

				<tr>
					<td colspan="2"><input type="button" value="수정"
						onclick="updatemem()"><input type="button" value="삭제" onclick="deletemem()">
					</td>
				</tr>

			</table>

		</form>
		<a href="index.html">초기화면</a>
	</div>
</body>
</html>
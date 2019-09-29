<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#btn').on("click", function() {
		$.ajax({
			type : "post",
			url : "data.jsp",
			dataType : "xml",
			success : succ,
			error : err
		});
	});
	
	function succ(data) {
		var name = $("name", data).text();
		var age = $("age", data).text();
		console.log("asdfkalsdjflksaj");
		/* $("#dd").text(name+" "+age+" "+addr); */
		
		$("#op1").val(name);
		$("#op2").val(age);
	}
	function err() {
		
	}
	$("#aaa").on("click", function(){
		rform.submit();
	})
	
	$("#bbb").on("click", function() {
		rform.submit();
	})

})
</script>
</head>
<body>
	<button id="btn">눌러봐라</button>
	<form action="main.do?action=calc" method="post" name="rform">
		<!-- <div id="dd">	</div> -->	
		<input  id="op1" name="op1">	
		<input  id="op2" name="op2">	
		<!-- <input type = "submit" value="가자"> -->
		<input type="button" id="aaa" value="가자@@" onclick="aaa()">
	</form>
</body>
</html>
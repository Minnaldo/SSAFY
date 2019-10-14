<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	width: 500px;
	margin: 0 auto;
}

table {
	width: 450px;
	border: 1px solid #000;
}
</style>

<script type="text/javascript">
	function check() {

		rform.submit();
	}
</script>

</head>
<body>

	<form id="rform" action="main.do?action=loginmem" method="post">
		<div align="center">

			<h1>Login</h1>

			<table>
				<tr>
					<td>아이디:</td>
					<td><input type="text" name="pid" id="pid"></td>
				</tr>
				<tr>
					<td>비번:</td>
					<td><input type="password" name="ppw" id="ppw"></td>
				</tr>

				<tr>
					<td colspan="2"><input type="button" value="Login"
						onclick="check()"></td>
					<td>
			</table>
			<a href="registermem2.html">회원가입</a>
		</div>
	</form>
</body>
</html>
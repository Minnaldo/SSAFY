<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js"
    integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
    crossorigin="anonymous"></script>
<title>Insert title here</title>
<script type="text/javascript">
    $(document).ready(function() {
        var msg = "${msg}";
        if (msg == "success") {
            alert("탈퇴 성공.");
        } else if (msg == "fail") {
            alert("탈퇴 실패.");
        }
    });
    function updatemem() {
        location.href = "meminfo.jsp";   /* &pid="+id */
    }
    function deletemem() {
        location.href = "main.do?action=Delete&pid=${id}";
    }
    function goMain() {
        location.href = "main.jsp";
    }
</script>
</head>
<body>
    <tr>
        <td><input type="button" value="회원 수정" onclick="updatemem()">
            <br /> <input type="button" value="회원 탈퇴" onclick="deletemem()"></td>
        <br />
        <input type="button" value="메인 화면 돌아가기" onclick="goMain()">
        </td>
    </tr>
</body>
</html>
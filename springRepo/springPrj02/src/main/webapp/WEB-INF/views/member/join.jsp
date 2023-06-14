<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원가입</h1>
	
	<form action="/app/member/join" method="POST">
			ID : <input type="text" name="id">
			<br>
			PW : <input type="password" name="pwd">
			<br>
			NickName : <input type="text" name="nick">
			<br>
			<input type="submit" value="가입하기">
	</form>

</body>
</html>
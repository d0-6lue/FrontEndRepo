<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/app20/member/login" method="post">
		<fieldset>
			<legend><h1>로그인</h1></legend>
		
			아이디 &nbsp;&nbsp;&nbsp;: <input type="text" name="memberId"> <br>
			비밀번호 : <input type="password" name="memberPwd">
			<br>
			<input type="submit" value="로그인">
		
		</fieldset>
	</form>

</body>
</html>
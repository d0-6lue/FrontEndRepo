<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/app20/member/join" method="post">
	
		<fieldset>
			<legend><h1>회원가입</h1></legend>
		
			아이디 &nbsp;&nbsp; : <input type="text" name="memberId"> <br>
			비밀번호 : <input type="password" name="memberPwd"> <br>
			닉네임 &nbsp;&nbsp; : <input type="text" name="memberNick"> <br>
			<br>
			<input type="submit" value="회원가입">
		
		</fieldset>
	
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>

	<% String msg = (String)request.getAttribute("msg"); %>

	<h1><%= msg %></h1>
	
	<% if(msg.equals("회원가입 성공 !!")) {%>
		<a href="/app23/">홈으로 </a>
		<a href="/app23/member/login">로그인 </a>
	<%} else if(msg.equals("회원가입 실패 ..")) {%>
		<a href="/app23/">홈으로</a>
		<a href="/app23/member/join">회원가입 다시 </a>
	<%} %>

</body>
</html>
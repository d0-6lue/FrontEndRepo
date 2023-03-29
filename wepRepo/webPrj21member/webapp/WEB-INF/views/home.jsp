<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈화면</title>
</head>
<body>

	<% 
		// session = request.getSession();  jsp에서 이미 적용됨.
		String x = (String)session.getAttribute("nick"); 
		String y = (String)session.getAttribute("id"); 
	%>
	
	<% if(x != null) { %>
	
		<h1><%= x %> welcom~</h1>
		<a href="/app21/member/edit">마이페이지</a>
		<br>
		<a href="/app21/member/delete?id=<%= y %>">회원탈퇴</a>
		<br>
		<a href="/app21/member/logout">로그아웃</a>
		<br>
	
	<%} else { %>
	
		<h1>welcom~</h1>
		<a href="/app21/member/login">로그인</a>
		<br>
		<a href="/app21/member/join">회원가입</a>
		<br>
	
	<%} %>
	
	
	

</body>
</html>
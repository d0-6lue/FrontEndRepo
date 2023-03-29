<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>
</head>
<body>
	<% 
		/*session = request.getSession();*/
		//Map<String, String> member = (Map)request.getAttribute("loginMember");
		Map<String, String> member = (Map)session.getAttribute("loginMember");
		String nick = "";
		if( member != null){
			nick = member.get("dbNick");
		}
		
	%>
	<h1>INDEX</h1>

	<% if( member == null) {%>
	<ul>
		<li><a href="/app20/member/join">회원가입</a></li>
		<li><a href="/app20/member/login">로그인</a></li>
	</ul>
	<%} else { %>
	
	
	<ul>
		<li><h3><%= nick %> 님 환영합니다.</h3></li>
		<li><a href="/app20/member/logout">로그아웃</a></li>
	</ul>
	
	<%} %>
</body>
</html>
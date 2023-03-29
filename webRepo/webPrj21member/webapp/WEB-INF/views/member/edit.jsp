<%@page import="com.kh.app.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원 정보 수정</h1>

	<% 
		MemberVo loginMemeber = (MemberVo)request.getAttribute("loginMember");
	
		String loginId = loginMemeber.getMemberId();
		String loginPwd = loginMemeber.getMemberPwd();
		String loginNick = loginMemeber.getMemberNick();
	
	%>
	
	
	<form action="/app21/member/edit" method="post">
	
		아이디 <input type="text" name="memberId" value="<%= loginId %>" readonly>
		<br>
		비밀번호 <input type="password" name="memberPwd">
		<br>
		닉네임 <input type="text" name="memberNick" value="<%= loginNick %>">
		<br>
		<input type="submit" value="수정하기">
	</form>


</body>
</html>
<%@page import="com.kh.app.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
    #wrap{
        width: 400px;
        display: grid;
        grid-template-columns: 1fr 3fr;
    }
    #wrap > div:last-child{
        grid-column: span 2;
        display: flex;
        justify-content: center;
    }
    #wrap > div {
        display: flex;
        justify-content: center;
    }

    #wrap > div:last-child> iput{
        width: 60%;

    }
</style>
</head>
<body>


	<h1>마이 페이지</h1>
	
    <form action="/app23/member/edit" method="post">
        
        <div id="wrap">

			<% MemberVo dbMember = (MemberVo)request.getAttribute("dbMember"); %>
    
            <div>아이디</div>
            <div><input type="text" name="memberId" value="<%= dbMember.getId() %>" readonly></div>
            
            <div>비밀번호</div>
            <div><input type="password" name="memberPwd"></div>
            
            <div>닉네임</div>
            <div><input type="text" name="memberNick" value="<%= dbMember.getNick() %>"></div>
    
    
            <div><input type="submit" value="수정하기"></div>
    
        </div>

    </form>
    
    <a href="/app22/member/del">회원탈퇴</a>
	


</body>
</html>
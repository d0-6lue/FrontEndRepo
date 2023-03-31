<%@page import="com.kh.app.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    html, body{
        margin: 0;
        padding: 0;
    }
    .wrap{
        width: 80%;
        height: 100vh;
        margin: auto;
        background-color: lightblue;
    }
    header{
        display: flex;
        justify-content: center;
    }
    nav{
        display: flex;
        justify-content: space-between;
    }
    a{
        text-decoration: none;
        color: black;
    }
    a:hover{
        text-decoration: underline;
    }
</style>
</head>
<body>

    <div class="wrap">
        <header>
            <h1>홈페이지</h1>
        </header>
        <hr>
        <nav>
        
        	<% 
           		// HttpSession session = request.getSession(); 이미 자동으로 적용됨
           		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember"); 
            %>
        
            <div>
	            <% if(loginMember != null) { %>
	                <a href="/app23/board/write">게시글 작성</a>
	                <a href="/app23/board/list">게시글 목록</a>
	            <% } else { %>
	                <a href="/app23/board/list">게시글 목록</a>
	            <% } %>
            </div>
            <div>
            	
            	<% if(loginMember != null) { %>
                	<h2><%= loginMember.getNick() %> 님 환영합니다.</h2>
                	<!--  -->
                	<a href="/app23/member/edit">마이페이지</a>
                	<a href="/app23/member/logout">로그아웃</a>
                	<%
	            	//	if(loginMember != null) {
	            	//		if(loginMember.getId().equals("admin")){
	            	//			...
	            	//		}
	            	//	}
	            	// && 로 아래로 바꿀 수 있다. 앞의 조건문을 먼저 보고,
	            	// 앞의 값이 false면 뒤에 조건문은 실행되지 않기에 null pointer exception이 발생하지 않음.
	            	%>
	            	<%if(loginMember != null && loginMember.getId().equals("admin")) { %>
	            		<div><a href="/app23/member/list">회원 목록 조회</a><div>
	            	<%} %>
                <% } else { %>
                	<a href="/app23/member/login">로그인</a>
                	<a href="/app23/member/join">회원가입</a>
            	<% } %>
            	
            </div>
        </nav>
        

    </div>
    

    

</body>
</html>
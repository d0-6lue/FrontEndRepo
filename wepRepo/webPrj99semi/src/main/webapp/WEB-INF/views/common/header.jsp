<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/jstl-load.jsp" %>


<link rel="stylesheet" href="${root }/static/css/common/reset.css">
<link rel="stylesheet" href="${root }/static/css/common/header.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap" rel="stylesheet">

<c:if test="${alertMsg ne null }" >
	<script>
		alert("${alertMsg}");
	</script>
</c:if>
<c:remove var="alertMsg" scope="session" />

<header>
    <div></div>

    <div class="logo-area">
        <a href="${root }/home">
            <img height="77px" src="${root }/static/img/logo.png" alt="로고 이미지">
        </a>
    </div>

    <div class="member-area">
        <c:if test="${empty loginMember}" >
            <form action="${root }member/login" method="post">
                <input type="text" name="memberId" placeholder="아이디">
                <input type="password" name="memberPwd" placeholder="비밀번호">
                <input class="login-btn" type="submit" value="로그인">
            </form>
            <div class="member-util">
                <button class="join-btn" onclick="location.href='${root }/member/join'">회원가입</button>
                <button class="find-btn" onclick="location.href='${root }/member/find'">아이디/비밀번호 찾기</button>
            </div>
        </c:if>
        <c:if test="${not empty loginMember}" >
            ${loginMember.nick} 님 환영합니다.
            <br>
            <button /onclick="location.href='${rrot}/member/logout'">로그아웃</button>
        </c:if>
    </div>
</header>
<nav>
    <ul class="nav-list">
        <li><a href="${root }/notice/list">공지사항</a></li>
        <li><a href="${root }/board/list">갤러리</a></li>
        <li><a href="${root }/gallery/list">자유게시판</a></li>
        <li><a href="${root }/member/edit">마이페이지</a></li>
    </ul>
</nav>
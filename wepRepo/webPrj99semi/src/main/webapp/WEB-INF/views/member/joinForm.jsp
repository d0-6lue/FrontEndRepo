<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/jstl-load.jsp" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>toss</title>
<link rel="stylesheet" href="${root }/static/css/member/joinForm.css">
<script defer src="${root }/static/js/member/joinForm.js"></script>
</head>
<body>

        <div class="wrap">

            <%@ include file="/WEB-INF/views/common/header.jsp" %>
            <main>

                <form action="${root }/member/join" method="post" onsubmit="return checkValidation();" enctype="multipart/form-data" >

                    <div class="join-area">
                        <span>아이디</span><input type="text" name="memberId"> <button type="button">중복확인</button>
                        
                        <span>비밀번호</span><input type="password" name="memberPwd"> <div></div>
                        <span>비밀번호 확인</span><input type="password" name="memberPwd2"> <div class="pwd-error-msg"></div>
                        
                        <span>닉네임</span><input type="text" name="memberNick"> <button type="button">중복확인</button>
                        
                        <span>취미</span>
                        <div class="hobby-list">
                            <label>코딩<input type="checkbox" name="hobby" value="20"></label>
                            <label>게임<input type="checkbox" name="hobby" value="30"></label>
                            <label>운동<input type="checkbox" name="hobby" value="40"></label>
                            <label>요리<input type="checkbox" name="hobby" value="50"></label>
                        </div>
                        <div></div>
                        
                        <span>프로필 사진</span>
                        <input class="upload-img" value="첨부파일" placeholder="첨부파일">
                        <label for="memberProfile">파일찾기</label>
                        
                        <div class="thumbnail"></div>
                        <input type="submit" value="회원가입">
                        <input type="reset" value="초기화">
                        
                        <input type="file" id="memberProfile" name="memberProfile">
                        <div></div>
                        <div></div>
                    </div>

                </form>

            </main>

        </div>

</body>
</html>
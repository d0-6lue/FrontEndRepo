<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>100</title>
</head>
<body>

	<div class="wrap">

        <%@ include file="/WEB-INF/views/common/header.jsp" %>

        <main>
            <form action="" method="">
                <div class="join-form-area">
                    <input class="join-input-area" type="text" name="memberId" placeholder="아이디는 숫자,영대소문자 6자 이상 12자 이하로 입력하셔야합니다.">
                    <button class="join-btn-area id-duplicate-check-btn" type="button">중복확인</button>
                    <div class="profile-img">
                        프로필 사진
                    </div>

                    <div class="availability-alert check-id-availability"></div>
    
                    <input class="join-input-area" type="password" name="memberPwd1" placeholder="비밀번호는 숫자,영대소문자,특수문자 포함 12자 이상 22자 이하로 입력하셔야합니다."><div></div>
                    
                    <div class="availability-alert check-pwd1-availability"></div>
                    
                    <input class="join-input-area" type="password" name="memberPwd2" placeholder="비밀번호와 같은 값을 입력해주세요"><div></div>
                    <input type="file" name="memberProfile">
                    
                    <div class="availability-alert check-pwd2-availability"></div><div></div>

                    <input class="join-input-area" type="text" name="memberNick" placeholder="닉네임은 4자 이상 12자 이하로 입력하셔야합니다.">
                    <button class="join-btn-area" type="button">중복확인</button><div></div>
    
                    <div class="availability-alert check-nick-availability"></div><div></div>

                    <input class="join-input-area" type="email" name="memberEmail" placeholder="email"><div></div>
                    <div></div>
    
                    <div class="availability-alert check-email-availability"></div><div></div>

                    <input class="join-input-area" type="number" name="memberPhone" placeholder="연락처( - 없이 입력해주세요) ex)01012345678"><div></div>
                    <div></div>

                    <div class="availability-alert check-phone-availability"></div><div></div>

                    <div class="submit-div">
                        <input type="submit" value="회원가입">
                    </div>
                    <div class="availability-alert check-submit-availability"></div>
                </div>
            </form>
        </main>

    </div>

</body>
</html>
<link rel="stylesheet" href="${root }/resource/css/member/join-page.css">
<script defer src="${root }/resource/js/member/join-page.js"></script>
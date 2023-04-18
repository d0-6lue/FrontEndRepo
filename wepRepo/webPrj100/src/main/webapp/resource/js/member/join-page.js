
// 프로필 사진 미리보기
const fileTag = document.querySelector("input[name=memberProfile]");

fileTag.addEventListener("change", function() {

    const profileDiv = document.querySelector(".profile-img");

    if(fileTag.files.length > 0) {

        const fr = new FileReader();
        fr.readAsDataURL( fileTag.files[0] );

        fr.addEventListener("load" , function(event) {

            profileDiv.innerText = "";
            // 이미지를 새로 만들어서 appendChild로 div에 추가
            const profileThumbnail = new Image();
            profileThumbnail.src = event.target.result;
            profileThumbnail.width = "110";
            profileThumbnail.height = "110";
            profileThumbnail.style.margin = "5px 5px";
            profileDiv.appendChild(profileThumbnail);
        });

    }

});
//-----------------------------------------------------------------------------------
// 입력 유효성 검사


// 공백 - 정규 표현식
const spaceRegExp = /\s/g;
// 한글 자음만 -정규 표현식
const koreanConsonantsRegExp = /[ㄱ-ㅎ]/g;
// 한글 - 정규 표현식
const koreanRegExp = /[ㄱ-ㅣ가-힣]/g;
// 숫자로 시작 - 정규표현식
const startNumRegExp = /^\d.*/;
// 숫자 - 정규표현식
const numRegExp = /\d/g;
// 소문자 -
const smallLetterRegExp = /[a-z]/g;
// 대문자 -
const capitalLetterRegExp = /[A-Z]/g;
// 특수문자 - 정규표현식
const regExp1 = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g;



// 아이디 유효성 검사
const idInputArea = document.querySelector("input[name=memberId]");

idInputArea.addEventListener("change", function() {
    const idCheckAlter = document.querySelector(".check-id-availability");

    
    const idString = idInputArea.value;

    //길이
    if(idString.length < 6 ){
        idCheckAlter.innerText = "아이디가 6자 미만입니다."
    }
    else if(idString.length > 12){
        idCheckAlter.innerText = "아이디가 12자 보다 많습니다."
    }
    // 공백
    else if (spaceRegExp.test(idString) == true){
        idCheckAlter.innerText = "아이디에 공백문자는 사용 할 수 없습니다."
    }
    // 특수문자
    else if(regExp1.test(idString) == true){
        idCheckAlter.innerText = "아이디에 특수문자는 사용 할 수 없습니다."
    }
    // 한글
    else if(koreanRegExp.test(idString)){
        idCheckAlter.innerText = "아이디에는 한글을 사용 할 수 없습니다."
    }
    // 숫자로 시작
    else if(startNumRegExp.test(idString)){
        idCheckAlter.innerText = "아이디는 숫자로 시작 할 수 없습니다."
    }
    else {
        idCheckAlter.innerText = "";
    }
    idCheckAlter.style.color = "red";

});


// 아이디 중복 검사
function duplicateCheckId() {
	
    const memberId = document.querySelector("input[name=memberId]").value;

	const xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if(xhr.readyState === XMLHttpRequest.DONE) {
            if(xhr.status === 200){
                const result = xhr.response;
                console.log(result.result);
            }
            else {
                console.log('request에 뭔가 문제');
            }
        }
    };

    xhr.open('POST', '/member/join/checkId', true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(memberId);

};


// 비밀번호는 새로입력할 때마다 초기화
const pwd1InputArea = document.querySelector("input[name=memberPwd1]");

pwd1InputArea.addEventListener("focus", function() {
    pwd1InputArea.value = null;
})


// 비밀번호 유효성 검사
pwd1InputArea.addEventListener("change", function() {
    const pwd1CheckAlter = document.querySelector(".check-pwd1-availability");

    
    const pwd1String = pwd1InputArea.value;

    //길이
    if( pwd1String.length < 12 ){
        pwd1CheckAlter.innerText = "비밀번호가 12자 미만입니다."
    }
    else if( pwd1String.length > 22 ){
        pwd1CheckAlter.innerText = "비밀번호가 22자 보다 많습니다."
    }
    // 공백
    else if ( spaceRegExp.test(pwd1String) == true ){
        pwd1CheckAlter.innerText = "비밀번호에 공백문자는 사용 할 수 없습니다."
    }
    // 한글
    else if( koreanRegExp.test(pwd1String) ){
        pwd1CheckAlter.innerText = "비밀번호에 한글을 사용 할 수 없습니다."
    }
    // 특수문자 미포함
    else if( regExp1.test(pwd1String) == false ){
        pwd1CheckAlter.innerText = "비밀번호에는 특수문자를 포함해야 합니다."
    }
    // 숫자 미포함
    else if( numRegExp.test(pwd1String) == false ){
        pwd1CheckAlter.innerText = "비밀번호에는 숫자 포함해야 합니다."
    }
    // 영문 소문자 미포함
    else if( smallLetterRegExp.test(pwd1String) == false ){
        pwd1CheckAlter.in
        nerText = "비밀번호에는 영문 소문자를 포함해야 합니다."
    }
    // 영문 대문자 미포함
    else if( capitalLetterRegExp.test(pwd1String) == false ){
        pwd1CheckAlter.innerText = "비밀번호에는 영문 대문자를 포함해야 합니다."
    }
    else {
        pwd1CheckAlter.innerText = "";
    }
    pwd1CheckAlter.style.color = "red";

});



// 비밀번호 확인도 새로입력할 때마다 초기화
const pwd2InputArea = document.querySelector("input[name=memberPwd2]");

pwd2InputArea.addEventListener("focus", function() {
    pwd2InputArea.value = null;
})


// 비밀번호 확인 검사
pwd2InputArea.addEventListener("change", function() {
    const pwd1String = pwd1InputArea.value;
    const pwd2String = pwd2InputArea.value;

    const pwd2CheckAlter = document.querySelector(".check-pwd2-availability");

    if(pwd1String != pwd2String) {
        pwd2CheckAlter.innerText = "비밀번호와 값이 같지 않습니다."
    }
    else {
        pwd2CheckAlter.innerText = "";
    }
    pwd2CheckAlter.style.color = "red";
})


// 닉네임 중복 검사


// 닉네임 유효성 검사
const nickInputArea = document.querySelector("input[name=memberNick]");

nickInputArea.addEventListener("change", function() {
    const nickCheckAlter = document.querySelector(".check-nick-availability");

    
    const nickString = nickInputArea.value;

    //길이
    if(nickString.length < 4 ){
        nickCheckAlter.innerText = "닉네임이 4자 미만입니다."
    }
    else if(nickString.length > 12){
        nickCheckAlter.innerText = "닉네임이 12자 보다 많습니다."
    }
    // 공백
    else if (spaceRegExp.test(nickString) == true){
        nickCheckAlter.innerText = "닉네임에 공백문자는 사용 할 수 없습니다."
    }
    // 특수문자
    else if(regExp1.test(nickString) == true){
        nickCheckAlter.innerText = "닉네임에 특수문자는 사용 할 수 없습니다."
    }
    // 자음만 쓴 경우
    else if(koreanConsonantsRegExp.test(nickString) == true){
        nickCheckAlter.innerText = "닉네임에 자음만 사용 할 수 없습니다."
    }
    else {
        nickCheckAlter.innerText = "";
    }
    nickCheckAlter.style.color = "red";

});


// 이메일 유효성 검사
const emailRegExp = /[a-z0-9]+@[a-z]+\.[a-z]{2,3}/;

const emailInputArea = document.querySelector("input[name=memberEmail]");

emailInputArea.addEventListener("change", function(){
    const emailCheckAlter = document.querySelector(".check-email-availability");

    const emailString = emailInputArea.value;
    if(emailRegExp.test(emailString) != true) {
        emailCheckAlter.innerText = "이메일 형식에 맞게 작성해주세요."
    }
    else {
        emailCheckAlter.innerText = "";
    }
    emailCheckAlter.style.color = "red";
});


// 연락처 유효성 검사
const phoneRegExp = /(^01([0|1|6|7|8|9]))(\d{3,4})(\d{4}$)/;

const phoneInputArea = document.querySelector("input[name=memberPhone]");

phoneInputArea.addEventListener("change", function(){
    const phoneCheckAlter = document.querySelector(".check-phone-availability");

    const phoneString = phoneInputArea.value;
    if(phoneRegExp.test(phoneString) == false) {
        phoneCheckAlter.innerText = "연락처 형식에 맞게 작성해주세요."
    }
    else if(phoneString.length > 11) {
        phoneCheckAlter.innerText = "연락처 형식에 맞게 작성해주세요.";
    }
    else if(phoneString.length < 10) {
        phoneCheckAlter.innerText = "연락처 형식에 맞게 작성해주세요.";
    }
    else {
        phoneCheckAlter.innerText = "";
    }
    phoneCheckAlter.style.color = "red";
});








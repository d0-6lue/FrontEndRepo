function checkValidation() {
    const isIdOk = checkId();
    const isPwdOk = checkPwd();

    if(!isIdOk) {
        alert("아이디는 4글자 이상 작성해주세요.");
        return false;
    }
    else if(!isPwdOk) {
        alert("비밀번호를 다시 확인해주세요.");
        return false;
    }

    return isIdOk && isPwdOk;
}

// 아이디 길이 거마
function checkId(){
    const memberId = document.querySelector("main input[name=memberId]").value;
    if(memberId.length < 4){
        return false;
    }
    else {
        return true;
    }

}


//회원가입시 비밀번호 일치 여부 체크
function checkPwd(){
    const pwd1 = document.querySelector("main input[name=memberPwd]").value;
    const pwd2 = document.querySelector("main input[name=memberPwd2]").value;
    
    if( pwd1.length < 4 ){
        const errorMsg = document.querySelector(".pwd-error-msg");
        errorMsg.innerHTML = "비밀번호가 4글자 미만입니다."
        return false;
    }
    else if ( pwd1 == pwd2){
        return true;
    }
    else {
        const errorMsg = document.querySelector(".pwd-error-msg");
        errorMsg.innerHTML = "비밀번호가 일치하지 않습니다."
        return false;
    }
}

document.querySelector("#memberProfile").addEventListener('change',function(){
    let fileName = document.querySelector("#memberProfile").value;
    document.querySelector(".upload-img").value = fileName;
})


function setThumbnail(event){
    let reader = new FileReader();

    reader.onload = function(event){
        let img = document.createElement("img");
        img.setAttribute("src", event.target.result);
        img.setAttribute("class", "col-lg-6");
        document.querySelector(".thumbnail").appendChild(img);
    }
    reader.readAsDataURL(event.target.files[0]);
}
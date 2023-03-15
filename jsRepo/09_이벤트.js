// 고전 이벤트 모델
const btn1 = document.querySelector("#btn1");

btn1.onclick = function(){
    alert("고전 이벤트 모델...");
};

// 표준 이벤트 모델
const btn3 = document.querySelector("#btn3");
btn3.addEventListener("click", f01 ); // 괄호 없이 함수 이름만!!!
                                      // f01() 같이 괄호까지 넣으면 리턴값이 들어감.
function f01() {
    alert("표준 이벤트 모델");
}

// 이벤트가 발생한 요소에 접근하는 방법
const btn4 = document.querySelector("#btn4");
btn4.addEventListener("click", function(event){
    console.log(event);
    console.log(window.event);
    console.log(event.target);
    console.log(window.event.target);
    console.log(this);              // 화살표 함수 일 때는안됨.
});

// 기본 이벤트 제거
function checkPwd(){
    const pwd = document.querySelector("input[name = memberPwd]");
    pwdLength = pwd.value.length;

    if(pwdLength >= 4){
        return true;
    }
    else{
        alert("비밀번호가 너무 짧습니다.");
        return false;
    }
}
// 기본 이벤트 제거 2
const t = document.querySelector("#t2");
t.addEventListener("click", function(event){
    
    const idValue = document.querySelector("#temp").value;
    console.log(idValue);
    console.log(idValue.length);
    if(idValue.length == 0){
        event.preventDefault();
    }
});

// 이벤트 전파
const div01 = document.querySelector("#div01");
const div02 = document.querySelector("#div02");
const div03 = document.querySelector("#div03");

// 버블링 ( 기본값 false )
div01.addEventListener("click", clickHandler);
div02.addEventListener("click", clickHandler, false);
div03.addEventListener("click", clickHandler, false);

// 캡처링
// div01.addEventListener("click", clickHandler, true);
// div02.addEventListener("click", clickHandler, true);
// div03.addEventListener("click", clickHandler, true);



function clickHandler(event){
    console.log("----------------------------------");
    console.log(this);
    console.log(event.target);
    console.log(event.currentTarget);
    console.log("----------------------------------");
    // this.style.backgroundColor = 'black';
    event.target.style.backgroundColor = 'black';
    // event.currentTarget.style.backgroundColor = 'black';
    
    // event.stopPropagation(); // 전파 중단
}




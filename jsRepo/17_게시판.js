// const board = document.querySelector("#board")
// console.log(board);

// console.log(board.lastChild);

// console.log(board.lastChild.childNodes[0]);


const boardTable = document.querySelector("table#board");

// NodeList
const trList = document.querySelectorAll("tr");
console.log(trList);
// NodeList -> Array
// const trArr = Array.prototype.slice.call(trList);
const trArr = Array.from(trList);
// th 제거
const th = trArr.shift();
// th 제거된 trArr
console.log(trArr);


// 반복문으로 이벤트리스너 달기
// for(let tr of trArr){
//     tr.addEventListener("click", function(){
//         alert("asdf");
//     })
// }


const f = function(event){
        
    const no_ = event.target.parentNode.children[0].innerHTML;
    const no = Number(no_);

    // th가 제거 안되었을 경우
    if(!isNaN(no)){
        alert(`선택하신 글 번호는 ${no}입니다.`);   
    }

    // alert(`선택하신 글 번호는 ${no}입니다.`);
};

// forEach()
// trArr.forEach(function(tr){
//     tr.addEventListener("click", f);
// });

boardTable.addEventListener("click", f );









// const loginBtn = document.querySelector("#login-btn");
// loginBtr.addEventListener("click", loginCheck);

function loginCheck(){

    const userIdValue = document.querySelector("input[name=memberId]").value;
    const userPwValue = document.querySelector("input[name=memberPw]").value;

    userIdCheck = /^[a-zA-Z]{1,1}[a-zA-Z0-9]{3,11}$/.test(userIdValue);
    userPwCheck = /^[/w!@#$%^&*]{8,15}$/.test(userPwValue);


    if(userIdCheck && userPwdCheck){
        return true;
    }
    else{
        return false;
    }
}



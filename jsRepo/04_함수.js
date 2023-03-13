// 선언적 함수
function test01(){
    alert("test01 called..")
};

// 익명 함수 -> 변수에 할당
f01 = function(){
    alert("Anonymous function called..")
};

// 자동 실행 함수
// (   function()
//     {
//         alert("자동실행 함수 호출됨")
//     }
// )();

test4 = () => {
    alert("화살표 함수 호출됨");
    return 123;
};

// return 만 있을 경우 중괄호 생략 가능
// -> 처리할 라인이 하나라면 중괄호 생략가능
temp1 = () => 1;
// 매개변수 하나면 괄호 생략 가능
temp2 = x => x+1;

temp3 = (x, y) => x + y;

// function test2_1(a, b){
//     sum = a+ b;
//     alert( sum );
// }

// parameter
test2_1 = (a, b) => {
    sum = a + b;
    alert( sum );
};

// argumnets 모든 매개값
function test2_2(){
    arguments;
    sum = 0;
    for(x of arguments){
        console.log(x);
        sum += x;
        console.log(sum);
    }
    alert( sum );
}


// 일반적인 값 리턴
returnValue = () => 101;

function test3_1(){
    result = returnValue();
    console.log(result);
}

// 함수 리턴
returnFunc = () => {
   return ()=>alert("함수리턴임");
};

function test3_2(){
    result = returnFunc();
    console.log(result);
    result();
}

// Closure (클로저), Lexical Scope (렉시컬 스코프)
testClosureInner = () => {
    let temp = 1234;
    return ()=>alert(temp);
};

testClosureOutter = () => {
    result = testClosureInner();
    result();
}


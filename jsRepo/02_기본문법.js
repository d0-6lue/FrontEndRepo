// 1. 변수와 자료형


// 전역변수 : window 전역객체에 붙음.
// 전역변수 선언
s = "전역변수~"
console.log(s);
console.log(window.s);

// 함수 외부에서 선언한 var 변수
var s2 = 'var 로 선언한 전역변수';
console.log(s2);
console.log(window.s2);

function f01()
{
    // 지역변수
    var s = "지역변수";
    var s2 = "var 지역변수";
    var s3;

    console.log(s);
    console.log(s2);
    console.log(s3);

    // 전역변수 호출
    console.log(window.s);
    console.log(this.s2); // 특별한 경우 제외 지양

    /* ------------------------------------------ */
    console.log('---------------------------------------');
    // var , let , const

    // var : 중복 선언 허용. 나쁨.
    var x = 10;
    console.log(x);
    var x = 20;
    console.log(x);

    // let : 중복 선언 x. 재할당 o. 일반적인 변수

    // const : 중복 선언 x, 재할당 x.
    const z = 10;
    // z = 20;

    /* ---------------------------------------- */
    console.log('---------------------------------------');
// 2. 유효범위( scope )
// 자세한건 hoisting 검색. https://developer.mozilla.org/ko/docs/Glossary/Hoisting
// - 함수 안에서 var 키워드로 선언한 변수 : 함수 스코프
    if(true)
    {
        var temp = 10;
        console.log(temp);
    }
    console.log(temp); // 중괄호가 아닌 함수

// - 함수 안에서 let 키워드로 선언한 변수 : 블록 스코프
    if(true)
    {
        let temp2 = 20;
        console.log(temp2);
    }
    // console.log(temp2); // 중괄호

// - 함수 안에서 const 키워드로 선언한 변수 : 블록 스코프

    if(true)
        {
            const temp3 = 30;
            console.log(temp3);
        }
        // console.log(temp3); // 중괄호가 아닌 함수
}
// f01();

console.log('----------------------------------------------');

// 자료형
function f02()
{
    // string
    let name = "jarvis";

    console.log(typeof name);
    console.log(name);
    
    // number
    let x = 940819;

    console.log(typeof x);
    console.log(x);

    // boolean
    let b = true;

    console.log(typeof b);
    console.log(b);

    // object
    let o = new Object();
    let o2 = {};

    console.log(typeof o);
    console.log(o);
    console.log(typeof o2);
    console.log(o2);
    
    // function
    let f = function testFunc(){

        let result = 10 + 20 + 30;

    };

    let f2 = f01;

    console.log(typeof f);
    console.log(f);
    console.log(typeof f2);
    console.log(f2);

    // undefined
    let u;
    console.log(typeof u);
    console.log(u);
}

// 문자열과 숫자
function f03()
{
    let result1 = 1 + 1;
    console.log(typeof result1);
    console.log(result1);
    
    // string + number
    let result2 = '1' + 1;
    console.log(typeof result2);
    console.log(result2);

    let result3 = '1' + 1 + 1;
    // 앞에서 부터 실행되어서
    console.log(typeof result3);
    console.log(result3);
    
    let result4 = 1 + 1 + '1';
    console.log(typeof result4);
    console.log(result4);

    // string - number
    let result5 = '5' - 2;
    console.log(typeof result5);
    console.log(result5);
    
    // string * number
    let result6 = '5' * 2;
    console.log(typeof result6);
    console.log(result6);

    // string / number
    let result7 = '5' / 2;
    console.log(typeof result7);
    console.log(result7);
    
    // string % number
    let result8 = '5' % 2;
    console.log(typeof result8);
    console.log(result7);

    // NaN : not a number
    let result9 = 'a' % 2;
    console.log(typeof result9);
    console.log(result9);

}

// 강제 형변환
function f04()
{
    let result = Number('1') + 2;
    console.log(result);
    
    let result2 = String(1) + 2;
    console.log(result2);
}

// 연산자
function f05(){
    // ==
    let a =  10;
    let b = '10';
    let result = ( a == b );
    console.log(result);
    // ===
    let x =  10;
    let y = '10';
    let result2 = ( a === b );
    console.log(result2);
}

function multiply(number, multiplier)
{
    return number.map((num)=>num*multiplier);
}

multiply([2,3,4], 3);

// 제어문
function f06()
{
    let arr = [10, 20, 30];

    // in : 인덱스
    for(let x in arr)
    {
        console.log(arr[x]);
    }
    // of : 요소
    for(x of arr)
    {
        console.log(x);
    }

    arr.map(console.log)

}
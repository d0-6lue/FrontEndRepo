const btn01 = document.querySelector("#btn01");
btn01.addEventListener("click", f01);
function f01(){
    const x = new RegExp("script"); // Regular Expression
    const y = /___/;

    let str1 = "javascript"
    let str2 = "JavaScript"
    let str3 = "javascript___ORACLE___SPRING"

    let result = x.test(str1);
    console.log(result);
    result = x.test(str2);
    console.log(result);

    result = x.exec(str1);
    console.log(result);
    result = x.exec(str2);
    console.log(result);

    console.log('--------------------------------------');
    /*
        RegExt(정규표현식) 객체 메소드
        - 정규식.test(문자열) : 매칭 여부 판단하여 boolean 값 반환
        - 정규식.exec(문자열) : 매칭된 문자열 반환

        String 객체 메소드
        - 문자열.match(정규식)           : 정규식 패턴과 일치하는 값을 반환
        - 문자열.replace(정규식, 대체값) : 패턴과 일치하는 부분을 대체 값으로 변환 
        - 문자열.search(정규식)          : 패턴과 일치하는 부분의 시작 인덱스 반환         
        - 문자열.split(정규식)           : 패턴과 일치하는 값을 구분자로 하여 배열 생성
    */
   console.log('--------------------------------------');
    console.log('match()');
    result = str1.match(x);
    console.log(result);
    result = str2.match(x);
    console.log(result);
    
    console.log('replace()');
    result = str1.replace(x, '대체된 글자');
    console.log(result);
    result = str2.replace(x, '대체된 글자');
    console.log(result);
    
    console.log('search()');
    result = str1.search(x);
    console.log(result);
    result = str2.search(x);
    console.log(result);

    console.log('split()');
    result = str3.split(y);
    console.log(result);
};


const btn02 = document.querySelector("#btn02");
btn02.addEventListener("click", f02);
function f02(){

    let str = "JavaScript jQuery Ajax";

    let result = str.replace(/script/i, "매칭된 문자");
    // console.log(result);
    
    result = "abc123 abc a ABC AAA Ac".replace(/a/ig, "X");
    console.log(result);
    
    // result = str.replace(/script/i, "매칭된 문자");
    // console.log(result);

};


const btn03 = document.querySelector("#btn03");
btn03.addEventListener("click", f03);
function f03(){

    let str = "a aa aaa aaaa";

    /*
        반복 검색
        {a[, b]} : 앞선 패턴이 최소 a번 최대 b번 반복 되는 문자열
        +        : 앞선 패턴이 최소 1번 이상 반복되는 문자열 ( == {1, })
        ?        : 앞선 패턴이 최대 1번 이상 반복되는 문자열 ( == {0,1})
    */
    result = str.replace(/a{2,3}/g , "X");
    console.log(result);
    result = str.replace(/a{2,}/g , "X");
    console.log(result);
    result = str.replace(/a+/g , "X");
    console.log(result);
    result = str.replace(/a?/g , "X");
    console.log(result);

    /*
        문자열 앞 뒤 구분
        ^ : 문자열의 시작
        $ : 문자열의 마지막
    */


    let str2 = "Javascript\nJscriptquery\nShellscript\nAjax";

    result = str2.replace(/^j/igm, 'X');
    console.log(result);
    
    result = str2.replace(/script$/igm, 'X');
    console.log(result);

    /*
        OR 검색
        [...] 내의 문자들 중 하나라도 존재할 경우를 의미

        - : 범위 지정
        ^ : not
    */

    str = "123 Javascript Jquery Ajax Jo/Dohyeong";

    result  = str.replace(/[aj]/ig, 'X');
    console.log(result);
    
    result  = str.replace(/[^aj]/g, 'X');
    console.log(result);

    /*
        임의의 문자열 검색
        . : 임의의 문자 한개
    */

    result = str.replace(/./g , "X");
    console.log(result);

    /*
        \d : 숫자 
        \D : \d 가 아닌 문자
        \w : 알파벳, 숫자, 언더스코어(_)
        \W : \w 가 아닌 문자
        \s : 공백묹 ( 띄어쓰기, \n, \)t
        \S : \s가 아닌 문자
    */

    str = "A1 B2 C3 d_4 e:5 ` ffgg77--__--\t가\n나\n다라마마마마마"

    result = str.replace(/\d/g , 'X');
    console.log(result);
    
    result = str.replace(/\D/g , 'X');
    console.log(result);
    
    result = str.replace(/\s/g , 'X');
    console.log(result);
    
    result = str.replace(/\S/g , 'X');
    console.log(result);



};
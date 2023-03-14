const btn01 = document.querySelector("#btn01");
btn01.addEventListener("click", function(){

    // Object
    const x1 = new Object();
    const x2 = {};

    console.log(x1);
    console.log(x2);

    console.log(x1 instanceof Object);
    console.log(x2 instanceof Object);
});

const btn02 = document.querySelector("#btn02");
btn02.addEventListener("click", function(){

    let n1 = 1001;                  // 리터럴
    let n2 = Number(3.14);          //
    let n3 = new Number(109);

    console.log(n1 instanceof Number); // false // new Number()
    console.log(n2 instanceof Number); // false // 생성자를 사용했는지 검사 하는것
    console.log(n3 instanceof Number);
    
    console.log(typeof n1); // number
    console.log(typeof n2); // number
    console.log(typeof n3); // object

});

const btn03 = document.querySelector("#btn03");
btn03.addEventListener("click", function(){

    let str1 = "졸려 죽을것만 같다..."
    let str2 = new String("왜 이렇게 졸린걸까??");

    console.log(typeof str1);
    console.log(typeof str2);

    console.log(str1 instanceof String);
    console.log(str2 instanceof String);

});

const btn04 = document.querySelector("#btn04");
btn04.addEventListener("click", function(){

    // 객체 생성 방법
    const d1 = new Date();

    console.log(d1.getFullYear);
    // ...







});
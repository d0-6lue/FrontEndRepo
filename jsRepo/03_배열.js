// 배열 선언과 초기화
function f01()
{
    // let arr  = new Array();
    // let arr = new Array(5);
    // let arr = new Array("안녕" , "하세요", 20, true)
    /* ------------------------------------------------- */
    
    // let arr = [];
    let arr = ["ezkk", 111 , 3.25, false, function temp(){}];

    // var arr = [];
    // arr[0] = "키보드";
    // arr[1] = "마우스";
    // arr[5] = 3.14;
    console.log(arr);
}

// 배열의 메소드
function f_indexOf()
{
    let arr = ["동", "해", "물", "과"];
    let result = test_arr.indexOf('물'); 
    console.log(result);
}
function f_concat()
{
    let arr1 = ["동", "해", "물", "과"];
    let arr2 = ['백', '두', '산', '이']
    console.log(arr1);
    console.log(arr2);
    let result = arr1.concat(arr2)
    console.log(result);
}
function f_join()
{
    let arr = ["동", "해", "물", "과"];
    let result = arr.join("@");
    console.log(typeof result);
    console.log(result);
}
function f_reverse()
{
    let arr = ["동", "해", "물", "과"];
    arr.reverse();
    console.log(arr);
}
function f_sort()
{
    let arr = ["동", "해", "물", "과"];
    let result = arr.sort();
    console.log(result);
    console.log(arr);

    arr = [112, 22, 30, 7, 8998, 486];
    result = arr.sort();
    console.log(result);
    console.log(arr);

    arr = [112, 22, 30, 7, 8998, 486];
    result = arr.sort(function temp(elem1, elem2){
        return elem1 - elem2
    });
    console.log(result);
    console.log(arr);

    arr = [112, 22, 30, 7, 8998, 486];
    result = arr.sort(function temp(elem1, elem2){
        return elem2 - elem1
    });
    console.log(result);
    console.log(arr);
}
// push() , pop()
function f_pp()
{
    let arr = ["동", "해", "물", "과"];
    let result = arr.push("백두산");
    console.log(result);
    console.log(arr);
    result = arr.push("마르고");
    console.log(result);
    console.log(arr);

    result =arr.pop();
    console.log(result);
    console.log(arr);
}
// shift() , unshift()
function f_su()
{
    let arr = ["동", "해", "물", "과"];
    let result =arr.shift();
    console.log(result);
    console.log(arr);

    result = arr.unshift('백두산');
    console.log(result);
    console.log(arr);
    result = arr.unshift('마르고');
    console.log(result);
    console.log(arr);
}
// slice(), splice()
function f_ss()
{
    let arr = ["동", "해", "물", "과"];
    let result = arr.slice(2);
    console.log(result);
    result = arr.slice(1);
    console.log(result);
    result = arr.slice(1, 2);
    console.log(result);
    result = arr.slice(1, 3);
    console.log(result);
    console.log(arr);

    arr = ["동", "해", "물", "과", "백", "두", "산"];
    result = arr.splice(5);
    console.log(result);
    console.log(arr);
    arr = ["동", "해", "물", "과", "백", "두", "산"];
    result = arr.splice(4, 2);
    console.log(result);
    console.log(arr);
    arr = ["동", "해", "물", "과", "백", "두", "산"];
    result = arr.splice(3, 0);
    console.log(result);
    console.log(arr);
    arr = ["동", "해", "물", "과", "백", "두", "산"];
    result = arr.splice(3, 1, '글자임', '원플원');
    console.log(result);
    console.log(arr);
}
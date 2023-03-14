// window.open()
btn1 = document.querySelector("#btn1");
btn1.addEventListener("click", function(){

    // window.open();
    // window.open("https://www.naver.com");
    // window.open("https://www.naver.com", "tab1");
    window.open("https://www.naver.com", "tab1", "width=500", "height=800", "resizeable=none");

});

// setTimeout()
btn2 = document.querySelector("#btn2");
btn2.addEventListener("click", function(){
    
    // setTimeout(함수, 시간(ms));
    // setTimeout( () => {
    //     alert("3초 지남");
    // }, 3000);

    const newWindow = window.open();
    newWindow.alert("5초 뒤 이 창은 종료됩니다");
    const timer = setTimeout( ()=>{
        newWindow.close();
    }, 5000);

    clearTimeout(timer);

})

// setInterval()
btn3 = document.querySelector("#btn3");
btn3.addEventListener("click", function(){

    // setInterval(함수, 시간(ms));
    timer = setInterval( () => {
        const d =new Date();
        console.log(d);
    }, 1000);

});

btn4 = document.querySelector("#btn4");
btn4.addEventListener("click", function(){
    clearInterval(timer);
});

// location
btn01 = document.querySelector("#btn01");
btn01.addEventListener("click", function(){

    // location.reload(); // 새로고침
    // location.href = "https://www.naver.com";
    // location.assign("https://www.naver.com");
    // location.replace("https://www.naver.com");
    
});

// navigaor
btn02 = document.querySelector("#btn02");
btn02.addEventListener("click", function(){

    console.log(navigator);

})
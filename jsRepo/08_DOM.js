btn01 = document.querySelector("#btn01");
btn01.addEventListener("click", function(){
    
    // 요소 노드
    elemNode = document.createElement("h3");

    // 텍스트 노드
    const textNode = document.createTextNode("오늘 왜 이렇게 졸릴까");

    elemNode.appendChild(textNode);

    const result01 = document.querySelector("#result01");
    result01.appendChild(elemNode);

});

// 텍스트가 없는 노드 생성
const btn02 = document.querySelector("#btn02");
btn02.addEventListener("click", function(){

    const imgNode = document.createElement("img");
    imgNode.src = "https://res.klook.com/images/fl_lossy.progressive,q_65/c_fill,w_1200,h_630/w_80,x_15,y_15,g_south_west,l_Klook_water_br_trans_yhcmh3/activities/ype8x0zkqbv239asgx9p/IMG%20%EC%9B%94%EB%93%9C%20%EC%98%A4%EB%B8%8C%20%EC%96%B4%EB%93%9C%EB%B2%A4%EC%B2%98%20%EC%9E%85%EC%9E%A5%EA%B6%8C.jpg";
    // imgNode.width = "300";
    // imgNode.height = "200";
    // imgNode.atk = "999"; // 추가안됨.
    // imgNode.setAttribute("width", "100%");
    // imgNode.setAttribute("height", "100%");
    // imgNode.setAttribute("def", "320"); // 추가됨.

    const temp = {
        'width' : '100%',
        'height' : '100%',
        'def' : '320'
    }
    for(x in temp){
        imgNode.setAttribute(x , temp[x]);
    }
    
    const result02 = document.querySelector("#result02")
    result02.appendChild(imgNode);
});
// 다른 방식
const btn03 = document.querySelector("#btn03");
btn03.addEventListener("click", function(){

    const result02 = document.querySelector("#result02");

    // result02.innerHTML = '<img src="https://res.klook.com/images/fl_lossy.progressive,q_65/c_fill,w_1200,h_630/w_80,x_15,y_15,g_south_west,l_Klook_water_br_trans_yhcmh3/activities/ype8x0zkqbv239asgx9p/IMG%20%EC%9B%94%EB%93%9C%20%EC%98%A4%EB%B8%8C%20%EC%96%B4%EB%93%9C%EB%B2%A4%EC%B2%98%20%EC%9E%85%EC%9E%A5%EA%B6%8C.jpg" width = "100" height = "100">';
    result02.innerHTML += '<img src="https://res.klook.com/images/fl_lossy.progressive,q_65/c_fill,w_1200,h_630/w_80,x_15,y_15,g_south_west,l_Klook_water_br_trans_yhcmh3/activities/ype8x0zkqbv239asgx9p/IMG%20%EC%9B%94%EB%93%9C%20%EC%98%A4%EB%B8%8C%20%EC%96%B4%EB%93%9C%EB%B2%A4%EC%B2%98%20%EC%9E%85%EC%9E%A5%EA%B6%8C.jpg" width = "100" height = "100">';
});

// Node 객체 삭제
const btn04 = document.querySelector("#btn04");
btn04.addEventListener("click", function(){

    const t = document.querySelector("#target");
    t.remove();

});
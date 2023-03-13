// 화면이 모두 로딩된 후에 실행.
window.onload = function(){

    const h1 = document.querySelector('h1');
    h1.addEventListener('click', (event)=>{
        alert(event.target.innerText);
    })


    // 객체 선언
    const btn01 = document.querySelector('#btn01');
    btn01.addEventListener('click', ()=>{
        // 객체 선언
        // const x = new Object();
        const x = { // (속성명 : 속성값) - key : value 형태로 객체의 property 를 생성
            name : '홍킬동',
            age : 15,
            hobby : ['fps', 'rpg', 'indie'],
            hello : ()=>alert(`반갑다.`),       // method : 객체의 속성(property) 중 자료형이 함수인 속성 (독립적으로 존재한다면 그냥 함수)
            "favorite color" : 'white'
        };


        let tempStr = 'age'
        console.log(x.name);
        console.log(x['name']);
        console.log(x[tempStr]);
        console.log(x.hobby);
        console.log(x.hobby[0]);
        console.log(x.hello);
        console.log(x.hello());
        console.log(x["favorite color"]);
    });

    const btn02 = document.querySelector('#btn02');
    btn02.addEventListener('click', ()=>{
        const p = {
            nick : 'asdf',
            age : 18,
            atk : 150,
            def : 70,
            // attack : (enemy)=>{
            //     console.log(`${this.nick}이 ${enemy}에게 ${this.atk}의 데미지를 입혔다.`);
            // }
            // 에러남. this가 다르게 작동함.
            attack : function(enemy){
                console.log(`${this.nick}이 ${enemy}에게 ${this.atk}의 데미지를 입혔다.`);
            }
        }

        p.attack('슬라임');

    });

}
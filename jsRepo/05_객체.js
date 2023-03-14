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
        // console.log(x."favorite color"); // . 으로 접근 안됨
        console.log(x["favorite color"]);
    });

    // 객체 메소드
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

    // 객체와 반복문
    const btn03 = document.querySelector("#btn03");
    btn03.addEventListener("click", function(){
        const p = {
            nick : "dragon",
            age : 20,
            atk : 100,
            def : 50
        }

        for(let k in p){
            console.log(`${k} : ${p[k]}`);;
        }

        // 객체의 value는 iterable 하지 않으므로 접근 불가
        // for(let v of p){
        //     console.log(v);
        // }

    })

    // 객체의 속성 추가 및 제거
    const btn04 = document.querySelector("#btn04");
    btn04.addEventListener("click", function(){
        const p = {
            
        }

        p.atk = 123;
        p.def = 33;
        p["speed"] = 88;
        p.attack = () => {
            console.log("공격");
        };

        console.log(p);
        p.attack();

        delete(p.speed);
        console.log(p);
    })

    // 객체 배열
    const btn05 = document.querySelector("#btn05");
    btn05.addEventListener("click", function(){

        const arr = [];

        const s1 = {naeme : '홍길동', java : 99, sql : 89};
        const s2 = {naeme : '전우치', java : 73, sql : 68};
        const s3 = {naeme : '심청이', java : 100, sql : 100};

        // arr[0] = s1;
        // arr[1] = s2;
        // arr[2] = s3;

        arr.push(s1);
        arr.push(s2);
        arr.push(s3);
        arr.push({naeme : '흥부', java : 50, sql : 50});

        console.log(arr);
    });

    // 생성자 함수
    const btn06 = document.querySelector("#btn06");
    btn06.addEventListener("click", function(){

        function Pokemon(name, atk, def){
            this.name = name;
            this.atk = atk;
            this.def = def;

            // 메소드
            // this.getName = ()=>{ return this.name; };
            // this.setName = ( name )=>{ this.name = name; };
        }; 
        console.log(Pokemon);
        console.log(Pokemon.prototype);

        Pokemon.prototype.getName = function(){ return this.name; };
        Pokemon.prototype.setName = function( name ){ this.name = name }
        Pokemon.prototype.age = 2;
        Pokemon.prototype.name = "pokemon";

        const x = new Pokemon("리자몽", 100, 88);
        console.log(x);

        console.log(x.getName());
        x.setName("파이리");
        console.log(x.getName());
        console.log(x);

        console.log(x.age);
        console.log(x.name);

        console.log(x.__proto__.name); // 옛, 편법, 지원중단
        console.log(Object.getPrototypeOf(x)); // 더 나은 새로운

    });


    // 캡슐화
    const btn07 = document.querySelector("#btn07");
    btn07.addEventListener("click", function(){

        function Person(n, a){
            let name = n;
            let age = a;

            this.getName = function(){ return name; }; 
            this.setName= function(str){ name = str;};
            this.getAge = function(){ return age;};
            this.setAge = function(num){ age = num; };
        }

        const p = new Person('홍길동', 15);
        console.log(p);
        console.log( p.getName() );
        console.log( p.getAge() );
        p.setName('전우치');
        p.setAge(20);
        console.log( p.getName() );
        console.log( p.getAge() );

    });


}; // onload function
fetch("/app100/chat/loadchatroom")
.then( (response) => response.json() )
.then( (data) => {
    console.log(data);
    
    const chatroomList = document.querySelector(".chatroom-list");

    for(i in data){
        const chatroom = document.createElement("div");
        chatroom.classList.add("chatroom");

        const chatRoomName = document.createElement("div");
        chatRoomName.innerHTML = data[i].roomName;
        chatroom.appendChild(chatRoomName);

        const chatRoomCurrentPersonnel = document.createElement("span");
        chatRoomCurrentPersonnel.innerHTML = data[i].roomCurrentPersonnel;
        chatroom.appendChild(chatRoomCurrentPersonnel);

        chatroom.append("/");

        const chatRoomTotalPersonnel = document.createElement("span");
        chatRoomTotalPersonnel.innerHTML = data[i].roomTotalPersonnel;
        chatroom.appendChild(chatRoomTotalPersonnel);

        const br = document.createElement("br");
        chatroom.appendChild(br);

        const joinBtn = document.createElement("a");
        joinBtn.href = "/app100/chat/room?roomNo="+data[i].roomNo;
        joinBtn.innerText = '참가하기';
        chatroom.appendChild(joinBtn);

        const participantBtn = document.createElement("a");
        participantBtn.innerText = '참가자';
        chatroom.appendChild(participantBtn);


        chatroomList.appendChild(chatroom);
    }
})
.catch( err => {
    console.log('Fetch Error', err);
})

// 새로고침 버튼
const reloadBtn = document.querySelector(".chatroom-main-reload");
reloadBtn.addEventListener("click", function() {

    fetch("/app100/chat/loadchatroom")
    .then( (response) => response.json() )
    .then( (data) => {
        console.log(data);
        
        const chatroomList = document.querySelector(".chatroom-list");

        chatroomList.replaceChildren();

        for(i in data){
            const chatroom = document.createElement("div");
            chatroom.classList.add("chatroom");

            const chatRoomName = document.createElement("div");
            chatRoomName.innerHTML = data[i].roomName;
            chatroom.appendChild(chatRoomName);

            const chatRoomCurrentPersonnel = document.createElement("span");
            chatRoomCurrentPersonnel.innerHTML = data[i].roomCurrentPersonnel;
            chatroom.appendChild(chatRoomCurrentPersonnel);

            chatroom.append("/");

            const chatRoomTotalPersonnel = document.createElement("span");
            chatRoomTotalPersonnel.innerHTML = data[i].roomTotalPersonnel;
            chatroom.appendChild(chatRoomTotalPersonnel);

            const br = document.createElement("br");
            chatroom.appendChild(br);

            const joinBtn = document.createElement("a");
            joinBtn.href = "/app100/chat/room?roomNo="+data[i].roomNo;
            joinBtn.innerText = '참가하기';
            chatroom.appendChild(joinBtn);

            const participantBtn = document.createElement("a");
            participantBtn.innerText = '참가자';
            chatroom.appendChild(participantBtn);


            chatroomList.appendChild(chatroom);
        }
    })
    .catch( err => {
        console.log('Fetch Error', err);
    })

});


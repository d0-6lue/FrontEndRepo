const roomNo = (new URLSearchParams(location.search).get('roomNo'));

fetch("/app100/chat/room", {
    method: "POST",
    headers: {
        "Content-Type": "application/json",
    },
    body : JSON.stringify({
        roomNo : roomNo
    })
} )
.then( (response) => response.json() )
.then( (data) => {
    console.log(data);
    
    const chatArea = document.querySelector(".chat-area");

    for(i in data){
        const ChatBox = document.createElement("div");

        const sender = document.createElement("span");
        sender.innerText = data[i].chatSender;
        const chatContent = document.createElement("span");
        chatContent.innerText = data[i].chatContent;
    
        ChatBox.appendChild(sender);
        ChatBox.appendChild(chatContent);

        chatArea.appendChild(ChatBox);
    }

    }
)
.catch( err => {
    console.log('Fetch Error', err);
})

setInterval(()=>{
    fetch("/app100/chat/room", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body : JSON.stringify({
            roomNo : roomNo
        })
    } )
    .then( (response) => response.json() )
    .then( (data) => {
        console.log(data);
        
        const chatArea = document.querySelector(".chat-area");

        for(i in data){
            const ChatBox = document.createElement("div");

            const sender = document.createElement("span");
            sender.innerText = data[i].chatSender;
            const chatContent = document.createElement("span");
            chatContent.innerText = data[i].chatContent;
        
            ChatBox.appendChild(sender);
            ChatBox.appendChild(chatContent);

            chatArea.appendChild(ChatBox);
        }

        }
    )
    .catch( err => {
        console.log('Fetch Error', err);
    })
}, 1000)
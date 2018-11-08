var ws;

function connect() {
    var username = document.getElementById("username").value;
    ws = new WebSocket("ws://" + document.location.host + "/chat/" + username);
    ws.onmessage = function(event) {
        var log = document.getElementById("log");
        var editor = document.getElementById("emoji");
        console.log(event.data);
        var message = JSON.parse(event.data);

        /*log.innerHTML += message.from + " : " + message.content + "\n";*/
        editor.innerHTML += message.from + " : " + message.content + "\n" +"<br/>";
    };
}

function send() {
    var content = document.getElementById("msg").value;
    var content1 = document.getElementsByClassName("emojionearea-editor");
    for (var i = 0; i < content1.length; i++) {
        var content = content1[i].innerHTML;
    }
    var json = JSON.stringify({
        "content":content
    });

    ws.send(json);
}

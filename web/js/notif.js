/**
 * Created by Jude on 3/23/2016.
 */


function postMessage() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "Notifications?t="+new Date(), false);
    xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    var nameText = escape(document.getElementById("status").value);
    var messageText = escape(document.getElementById("message").value);
    document.getElementById("message").value = "";
    xmlhttp.send("status="+"${productBean.product_name}"+"&message="+"SOLD");
    if(parseInt("${productBean.quantity}")<=5){
        xmlhttp.send("status="+"${productBean.product_name}"+"&message="+"KOKONTI NA LANG HUY!!");
    }
}
var messagesWaiting = false;
function getMessages(){
    if(!messagesWaiting){
        messagesWaiting = true;
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange=function(){
            if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                messagesWaiting = false;
                var contentElement = document.getElementById("content");
                contentElement.innerHTML = xmlhttp.responseText + contentElement.innerHTML;
            }
        }
        xmlhttp.open("GET", "Notifications?t="+new Date(), true);
        xmlhttp.send();
    }
}
//https://html5.digi.ninja

if (typeof(SERVER_DOMAIN) === 'undefined') {
	window.location.replace("/unconfigured.html");
}

const RECEIVE_URL = SERVER_DOMAIN + "/s_child.html" + "?origin=" + get_domain();

var window_ref = null;

function send_message(destination) {
	message = document.getElementById("message").value;
	receiver.contentWindow.postMessage(message, SERVER_DOMAIN);
}

function get_domain() {
	var url = window.location.href
	var arr = url.split("/");
	return arr[0] + "//" + arr[2]
}

var receiver = document.getElementById("s_iframe");
receiver.src = RECEIVE_URL;

const sendMessageButton = document.getElementById("send_message_button");
sendMessageButton.addEventListener("click", send_message, false);

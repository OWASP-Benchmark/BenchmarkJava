function receiveMessage(message) {
	let tokenSpan = document.getElementById("token");
	if (message.data == null) {
		tokenSpan.innerText = "<Unset>";
	} else {
		tokenSpan.innerText = message.data;
	}
}

window.addEventListener("message", receiveMessage, false);

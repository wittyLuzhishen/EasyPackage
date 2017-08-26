var logLevel = 1;

function logd() {
	if (logLevel > 1) {
		return;
	}
	for (var i = 0; i < arguments.length; i++) {
		console.debug(arguments[i]);
	}
}
function logi() {
	if (logLevel > 2) {
		return;
	}
	for (var i = 0; i < arguments.length; i++) {
		console.info(arguments[i]);
	}
}
function logw() {
	if (logLevel > 3) {
		return;
	}
	for (var i = 0; i < arguments.length; i++) {
		console.warn(arguments[i]);
	}
}
function loge() {
	if (logLevel > 4) {
		return;
	}
	for (var i = 0; i < arguments.length; i++) {
		console.error(arguments[i]);
	}
}
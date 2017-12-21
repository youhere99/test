(function(){
	userAgent = window.navigator.userAgent;
	var device_ext={};
	device_ext.os=function(){
	var OSName="UnKnown";
	// extract operating system name from user agent
	if (userAgent.indexOf("Windows") >= 0) {
		if (userAgent.indexOf("Windows Phone") >= 0) {
			OSName = "Windows Phone";
		} else {
			OSName = "Windows";
		}
	}
	
	if (userAgent.indexOf("OS X") >= 0 && userAgent.indexOf("Android") === -1) {
		OSName = "OS X";
	}
	
	if (userAgent.indexOf("Linux") >= 0) {
		OSName = "Linux";
	}
	
	if (userAgent.indexOf("like Mac OS X") >= 0) {
		OSName = "iOS";
	}
	
	if ((userAgent.indexOf("Android") >= 0 || userAgent.indexOf("Adr") >= 0) && userAgent.indexOf("Windows Phone") === -1) {
		OSName = "Android";
	}
	
	if (userAgent.indexOf("BB10") >= 0) {
		OSName = "BlackBerry";
	}
	
	if (userAgent.indexOf("RIM Tablet OS") >= 0) {
		OSName = "BlackBerry Tablet OS";
	}
	
	if (userAgent.indexOf("BlackBerry") >= 0) {
		OSName = "BlackBerryOS";
	}
	return OSName;
};
}).call(this);
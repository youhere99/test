<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaScript获取客户端IP</title>
<script language="javascript" src="/js/jquery-1.11.1.js"></script>
<script language="javascript" src="/js/detect.js"></script>
<script language="javascript" src="/js/device_extend.js"></script>
<script language="javascript" src="/js/index.js"></script>
<script language="javascript" src="/js/device.js"></script>
<script language="javascript" src="/js/detectmobilebrowser.js"></script>

</head>
<body>
<span id="latitude"></span>
<span id="longitude"></span>
<span id="address"></span>
<script language="javascript">
jQuery(function($){
	$.getJSON("http://chaxun.1616.net/s.php?type=ip&output=json&callback=?&_="+Math.random(), function(data){
		console.info(data);
	});
// 	$.getJSON( "http://smart-ip.net/geoip?callback=?",function(data){
// 		console.info(data);
// 	});
	$.getJSON("http://ip.chinaz.com/getip.aspx?callback=?", function(data){
		console.info(data);
	});
	
	//device type
	console.info(jQuery.browser.mobile);
//Get screen width in pixels.
console.info(detect.screenWidth());

// Get screen height in pixels.
console.info(detect.screenHeight());

// Get viewport (browser window minus any toolbars etc) width in pixels.
console.info(detect.viewportWidth());

// Get viewport (browser window minus any toolbars etc) height in pixels.
console.info(detect.viewportHeight());

// Get latitude from GPS & update html conent of ID element passed.
// Null, if GPS unavailable.
console.info(detect.latitude("latitude"));

// Get longitude from GPS & update html conent of ID element passed.
// Null, if GPS unavailable.
console.info(detect.longitude("longitude"));

// Get address from GPS & update html conent of ID element passed.
// Null, if GPS unavailable.
console.info(detect.address("address"));

});
</script>
    <script type="text/javascript">
      console.log("device.portrait() === %s", device.portrait());
      console.log("device.landscape() === %s", device.landscape());
      console.log("device.mobile() === %s", device.mobile());
      console.log("device.tablet() === %s", device.tablet());
      console.log("device.ipad() === %s", device.ipad());
      console.log("device.ipod() === %s", device.ipod());
      console.log("device.iphone() === %s", device.iphone());
      console.log("device.android() === %s", device.android());
      console.log("device.androidTablet() === %s", device.androidTablet());
      console.log("device.blackberryTablet() === %s", device.blackberryTablet());
      console.log("device.fxos() === %s", device.fxos());
      console.log("device.fxosPhone() === %s", device.fxosPhone());
      console.log("device.fxosTablet() === %s", device.fxosTablet());
      console.log("device.meego() === %s", device.meego());
      console.log("device.television() === %s", device.television());
      console.log("device_ext.os() === %s", device_ext.os());

      var devicejs = device.noConflict();

      console.log ("device.noConflict() [previous]", window.device);
      console.log ("device.noConflict() [device.js]", devicejs.iphone());
    </script>
</body>
</html>

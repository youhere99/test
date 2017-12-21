package controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HttpServletRequset 常用方法总结
 * Title.<br> 
 * Description.
 * <p>
 * Copyright: Copyright (c) 2015年11月17日 下午2:29:05
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * @author ZhaoMingxing
 * @version 1.0
 */
@Controller
@RequestMapping("/request/*")
public class RequestParameterController {

	@RequestMapping("info.do")
	public void requestInfo(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException,
	        ServletException {
		//		Check for valid session: isRequestedSessionIdValid() vs getSession(false)
		String localAddr = request.getLocalAddr();
		System.err.println(localAddr);
		String localName = request.getLocalName();
		Integer localPort = request.getLocalPort();
		Locale locale = request.getLocale();
		Enumeration<Locale> enum_local = request.getLocales();
		String remoteAddr = request.getRemoteAddr();
		System.err.println(remoteAddr);
		String remoteHost = request.getRemoteHost();
		String remoteUser = request.getRemoteUser();
		Integer remotePort = request.getRemotePort();
		String protocol = request.getProtocol();
		String method = request.getMethod();
		String secheme = request.getScheme();
		String serverName = request.getServerName();
		Integer serverPort = request.getServerPort();

		String authType = request.getAuthType();
		String contentType = request.getContentType();
		Integer contentLength = request.getContentLength();
		String pathTranslated = request.getPathTranslated();
		String pathInfo = request.getPathInfo();
		String queryString = request.getQueryString();
		String requestedSessionId = request.getRequestedSessionId();
		String requestURI = request.getRequestURI();
		String requestURL = request.getRequestURL().toString();
		String servletPath = request.getServletPath();
		String characterEncoding = request.getCharacterEncoding();
		Collection parts = request.getParts(); //获取上传的文件集合
		Boolean isSecure = request.isSecure();
		Boolean requestedSessionIdValid = request.isRequestedSessionIdValid();
		Principal principal = request.getUserPrincipal();

	}
}

package test;

import java.net.URI;
import java.net.URL;

import org.junit.Test;

/**
 * 
 * Title.<br> 
 * Description. 正则求得域名
 * <p>
 * Copyright: Copyright (c) 2015年8月26日 上午11:28:32
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * @author ZhaoMingxing
 * @version 1.0
 */
public class GetDomainName {

	private final String url = "http://www.baidu.com/test/";

	@Test
	public void testOne() throws Exception {
		URI u = new URI(url);
		System.out.println(u.getHost());
		URL l = new URL(url);
		System.out.println(l.getHost());
		System.err.println(l.getAuthority());
		System.err.println(l.getContent().toString());
		System.err.println(l.getDefaultPort());
		System.err.println(l.getFile());
		System.err.println(l.getHost());
		System.err.println(l.getPath());
		System.err.println(l.getPort());
		System.err.println(l.getProtocol());
		System.err.println(l.getQuery());
		System.err.println(l.getRef());
		System.err.println(l.getUserInfo());
		System.err.println(l.toExternalForm());
		System.err.println(l.toURI());
	}

}

package ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * Title.<br> 获取本地主机的局域网和外网IP
 * Description.
 * <p>
 * Copyright: Copyright (c) 2015年11月2日 下午2:06:11
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * @author ZhaoMingxing
 * @version 1.0
 */
public class LocalHostIP {

	public static void main(String[] args) {
		try {
			String ip = getOpenNet_IP();
			System.out.println("OpenNet_IP:" + ip);
			ip = getLAN_IP();
			System.out.println("LAN_IP:" + ip);
			System.out.println("IP.length:" + "255.255.255.255".length());
			test_IP();
			search();
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private static String getOpenNet_IP() throws IOException {
		InputStream ins = null;
		try {
			URL url = new URL("http://ip.cn");
			URLConnection con = url.openConnection();
			ins = con.getInputStream();
			InputStreamReader isReader = new InputStreamReader(ins, "UTF-8");
			BufferedReader bReader = new BufferedReader(isReader);
			StringBuffer webContent = new StringBuffer();
			String str = null;
			while ((str = bReader.readLine()) != null) {
				webContent.append(str);
			}
			int startIndex = webContent.indexOf("<code>");
			int endIndex = webContent.indexOf("</code>");
			String ip = webContent.substring(startIndex + 5, endIndex);
			parse(webContent.toString());
			return ip;
		}
		finally {
			if (ins != null) {
				ins.close();
			}
		}
	}

	private static String getLAN_IP() throws IOException {
		InetAddress address = InetAddress.getLocalHost();
		return address.getHostAddress();
	}

	private static void test_IP() throws UnknownHostException {
		String serverName = "www.baidu.com";
		InetAddress address = InetAddress.getLocalHost();
		printInfo(address);
		address = InetAddress.getLoopbackAddress();
		printInfo(address);
		address = InetAddress.getByName(serverName);
		printInfo(address);

		InetAddress[] name = InetAddress.getAllByName(serverName);
		for (InetAddress i : name) {
			printInfo(i);
		}
	}

	private static void printInfo(InetAddress address) {
		System.out.println("主机名：" + address.getHostName());
		System.out.println("ip地址：" + address.getHostAddress());
		System.out.println("完全限定域名：" + address.getCanonicalHostName());
		System.err.println("======================================");
	}

	/**
	 * 使用正则表达式解析返回的HTML文本,得到本机外网地址
	 * @param html
	 */
	private static void parse(String html) {
		Pattern pattern = Pattern.compile("(\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(html);
		while (matcher.find()) {
			System.err.println(matcher.group(0));
		}
	}

	//使用InetAddress查找局域网内所有的主机名和ip地址，如下：
	private static void search() {
		for (int num = 0; num <= 255; num++) {
			final String host = "192.168.2." + num;
			new Thread() {

				@Override
				public void run() {
					try {
						InetAddress hostAddress = InetAddress.getByName(host);
						if (!hostAddress.getHostName().equalsIgnoreCase(hostAddress.getHostAddress()))
							System.out.println(hostAddress.getHostName() + ":" + host);
					}
					catch (UnknownHostException e) {
						e.printStackTrace();
					}
				}
			}.start();
		}
	}
}

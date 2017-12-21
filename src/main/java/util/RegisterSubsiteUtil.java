package util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

/**
 * Title.<br>
 * Description.注册用户中心相关的子站用户
 * <p>
 * Copyright: Copyright (c) 2015年7月22日 下午6:57:06
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * 
 * @author ZhaoMingxing
 * @version 1.0
 */
public class RegisterSubsiteUtil {

	private static String ENCODING = "UTF-8";

	public static void exectueRegister(String url, String username, String password, String email) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", new String(username.getBytes(ENCODING)));
		map.put("password", new String(password.getBytes(ENCODING)));
		map.put("email", new String(email.getBytes(ENCODING)));
		Response response = null;
		try {
			response = Jsoup.connect(url).data(map).method(Method.POST).ignoreHttpErrors(true).timeout(50000).execute();
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new Exception("正在努力加载中...");
		}
		if (response.statusCode() == 200) {
		}

	}
}

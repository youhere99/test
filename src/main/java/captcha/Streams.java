package captcha;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * Title.<br> IO工具类
 * Description.
 * <p>
 * Copyright: Copyright (c) 2015年11月10日 上午9:19:39
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * @author ZhaoMingxing
 * @version 1.0
 */
public class Streams {

	/**
	 * 关闭输入流
	 * @param in 输入流
	 */
	public static void close(InputStream in) {
		if (in != null) {
			try {
				in.close();
			}
			catch (IOException ioex) {
				// ignore
			}
		}
	}

	/**
	 * 关闭输出流
	 * @param out 输出流
	 */
	public static void close(OutputStream out) {
		if (out != null) {
			try {
				out.flush();
			}
			catch (IOException ioex) {
				// ignore
			}
			try {
				out.close();
			}
			catch (IOException ioex) {
				// ignore
			}
		}
	}
}

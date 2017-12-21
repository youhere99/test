package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/**
 * Title.<br>
 * Description.对文件字符串加密
 * <p>
 * Copyright: Copyright (c) 2015年7月8日 下午2:25:58
 * <p>
 * Company: 北京中电翔云科技有限公司
 * <p>
 * 
 * @author ZhaoMingxing
 * @version 1.0
 */
public class MD5Util {

	public static void main(String[] args) {

		// 对字符加密
		String password = MD5Util.getStringMD5("admin");
		System.out.println(password);
	}

	public static String getStringMD5(String str) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			return new String(encode(digest.digest(str.getBytes())));
		}
		catch (Exception e) {
			throw new RuntimeException("md5 digest fail:", e);
		}
	}

	public static String getFileMD5(File file) {
		FileInputStream in = null;
		try {
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest digest = MessageDigest.getInstance("MD5");
			if (!file.isFile()) {
				throw new RuntimeException("md5 digest fail: file not exists!");
			}
			byte buffer[] = new byte[1024];
			int len;
			in = new FileInputStream(file);
			while ((len = in.read(buffer, 0, 1024)) != -1) {
				digest.update(buffer, 0, len);
			}
			return new String(encode(digest.digest()));
		}
		catch (Exception e) {
			throw new RuntimeException("md5 digest fail:", e);
		}
		finally {
			if (in != null) {
				try {
					in.close();
				}
				catch (IOException e) {
				}
			}
		}
	}

	private static final char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	// 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
	public static char[] encode(byte[] bytes) {
		final int nBytes = bytes.length;
		char[] result = new char[2 * nBytes];

		int j = 0;
		for (int i = 0; i < nBytes; i++) {
			// Char for top 4 bits
			result[j++] = HEX[(0xF0 & bytes[i]) >>> 4];
			// Bottom 4
			result[j++] = HEX[(0x0F & bytes[i])];
		}

		return result;
	}

}

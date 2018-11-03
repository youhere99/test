package encrypt;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Util {

	// 转码
	public static String encode(String str) throws UnsupportedEncodingException {
		return encodeToString(str);
	}

	public static String encodeToString(String str) throws UnsupportedEncodingException {
		return Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
	}

	// 解码
	public static String decode(String str) throws UnsupportedEncodingException {
		return decodeToString(str);
	}

	public static String decodeToString(String str) throws UnsupportedEncodingException {
		return new String(Base64.getDecoder().decode(str.getBytes("utf-8")));
	}
}

package encrypt;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.SysConstant;

/**
 * 
 * description:JAVA DES加密和解密工具类<br>
 * https://my.oschina.net/kkrgwbj/blog/655215<br/>
 * 
 * @author zhaomingxing 2018年11月3日
 *
 */
public class DESUtils {

	private static final Logger log = LoggerFactory.getLogger(DESUtil.class);
	private final static String DES = "DES";

	// 测试
	public static void main(String[] args) throws Exception {

		String data = "http://127.0.0.1:8771/receivesys/home";
		String key = "535a270a5f76443e811555226bbd1886";
		System.err.println("密钥:" + key);
		System.err.println("加密前:" + data);
		System.err.println("加密后:" + encryptURL(data, key));
		System.err.println("解密后:" + decryptURL(encryptURL(data, key), key));

	}

	public static String encrypt(String data, String key) {
		try {
			byte[] bt = encrypt(data.getBytes(SysConstant.UTF8), key.getBytes(SysConstant.UTF8));
			data = Base64.getEncoder().encodeToString(bt);
			return data;
		} catch (Exception e) {
			log.error("-----------加密异常----------", e);
			return "";
		}
	}

	public static String decrypt(String data, String key) {
		try {
			if (data == null)
				return null;
			byte[] buf = Base64.getDecoder().decode(data.getBytes(SysConstant.UTF8));
			byte[] bt = decrypt(buf, key.getBytes(SysConstant.UTF8));
			return new String(bt);
		} catch (Exception e) {
			log.error("-----------解密异常----------", e);
			return "";
		}
	}

	/**
	 * Description 根据键值进行加密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	public static String encryptURL(String data, String key) {
		try {
			data = encrypt(data, key);
			data = URLEncoder.encode(data, SysConstant.UTF8);
			return data;
		} catch (Exception e) {
			log.error("-----------加密异常----------", e);
			return "";
		}
	}

	/**
	 * Description 根据键值进行解密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static String decryptURL(String data, String key) {
		try {
			if (data == null)
				return null;
			data = URLDecoder.decode(data, SysConstant.UTF8);
			data = decrypt(data, key);
			return data;
		} catch (Exception e) {
			log.error("-----------解密异常----------", e);
			return "";
		}
	}

	/**
	 * Description 根据键值进行加密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}

	/**
	 * Description 根据键值进行解密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(DES);

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}
}

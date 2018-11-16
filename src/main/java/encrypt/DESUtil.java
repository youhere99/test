package encrypt;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JAVA DES加密和解密工具类:https://my.oschina.net/kkrgwbj/blog/655215<br/>
 * description:
 * 
 * @author zhaomingxing 2018年11月3日
 *
 */
public class DESUtil {
	private static final Logger log = LoggerFactory.getLogger(DESUtil.class);
	private final static String DES = "DES";
	private final static String UTF_8 = "UTF-8";

	// 测试
	public static void main(String[] args) throws Exception {

		String data = "http://127.0.0.1:8771/receivesys/home";
		String key = "535a270a5f76443e811555226bbd1886";
		String encrypt = "FIJyU1ypK2PMtXfS_61SSIELaykL9UD5Vj4P2sZ5n776dc6Eq-D2Sw==";
		System.err.println("加密前:" + data);
		System.err.println("加密后:" + encrypt(data, key));
		System.err.println("解密后:" + decrypt(encrypt, key));

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
	public static String encrypt(String data, String key) {
		try {
			byte[] bt = encrypt(data.getBytes(UTF_8), key.getBytes(UTF_8));
			String strs = Base64.getUrlEncoder().encodeToString(bt);
			return strs;
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
	public static String decrypt(String data, String key) {
		try {
			if (data == null)
				return null;
			byte[] buf = Base64.getUrlDecoder().decode(data.getBytes(UTF_8));
			byte[] bt = decrypt(buf, key.getBytes(UTF_8));
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

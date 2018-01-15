package encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * 一 、MD5算法
 * 散列算法之一（又译哈希算法、摘要算法等），主流编程语言普遍已有MD5的实现。将数据（如一段文字）运算变为另一固定长度值，是散列算法的基础原理。（
 * 以上是百度百科介绍）。扯那么多也是空的，反正就感觉读大学的时候觉得这种加密是最常见的，所以实现起来也比较简单，但是md5我们还是需要去了解下：
 * 对MD5算法简要的叙述可以为：MD5以512位分组来处理输入的信息，且每一分组又被划分为16个32位子分组，经过了一系列的处理后，
 * 算法的输出由四个32位分组组成，将这四个32位分组级联后将生成一个128位散列值。下面来看代码的实现：
 */

public class MD5Util {

	/**
	 * MD5加密 生成32位md5码
	 * 
	 * @param 待加密字符串
	 * @return 返回32位md5码
	 */
	public static String md5Encode(String inStr) throws Exception {
		MessageDigest md5 = null;// 消息摘要算法类
		try {
			md5 = MessageDigest.getInstance("MD5");// 可以传入一个参数获得实例（参数可以为MD2，MD5，SHA(JDK自带的)，然后也可以用bcprov里面可以带的MD4等）
		}
		catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		byte[] byteArray = inStr.getBytes("UTF-8");
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = (md5Bytes[i]) & 0xff;// 转化成为16进制的字节
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();// 返回的hash
	}

	/**
	 * 测试主函数
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		String str = new String("000000");
		System.out.println("原始：" + str);
		System.out.println("MD5后：" + md5Encode(str));
	}

	@Test
	public void testMD5Encode() {
		String textPlain = "000000";
		MessageDigest md5 = null;// 消息摘要算法类
		try {
			md5 = MessageDigest.getInstance("MD5");// 可以传入一个参数获得实例（参数可以为MD2，MD5，SHA(JDK自带的)，然后也可以用bcprov里面可以带的MD4等）
			byte[] md5Bytes = md5.digest(textPlain.getBytes("UTF-8"));

			String cipherText = Hex.encodeHexString(md5Bytes, true);
			System.err.println(cipherText);
			cipherText = Hex.encodeHexString(md5Bytes, false);
			System.err.println(cipherText);
			// 另一种方法
			cipherText = DigestUtils.md5Hex(textPlain);
			System.err.println(cipherText);
		}
		catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

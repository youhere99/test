package asserts;

import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestAssertFoo {

	public static void main(String args[]) {
		// 断言1结果为true，则继续往下执行
		assert true;
		System.out.println("断言1没有问题，Go！");

		System.out.println("\n-----------------\n");

		// 断言2结果为false,程序终止
		assert false : "断言失败，此表达式的信息将会在抛出异常的时候输出！";
		System.out.println("断言2没有问题，Go！");
	}

	private static String zipRegEx = "^\\d{5}([\\-]\\d{4})?$";

	private static Pattern pattern;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pattern = Pattern.compile(zipRegEx);
	}

	@Test
	public void verifyGoodZipCode() throws Exception {
		Matcher mtcher = pattern.matcher("22101");
		boolean isValid = mtcher.matches();
		assertTrue("Pattern did not validate zip code", isValid);

	}
}

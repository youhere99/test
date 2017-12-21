package test;

import java.math.BigDecimal;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

public class TestMath {

	private final String testField = null;

	@Test
	public void testOne() {
		double d = 10;
		int i = 3;
		double dou = i / d;
		System.out.println((double) Math.round(0.8888 * 100) / 100);

		BigDecimal bd = new BigDecimal("1.238761976E-10");
		System.out.println(bd.toPlainString());
		System.out.println(1E3);
	}

	@Test
	public void testNumberUtils() {
		System.out.println(NumberUtils.INTEGER_MINUS_ONE);
		System.out.println(NumberUtils.FLOAT_MINUS_ONE);
		System.out.println(NumberUtils.FLOAT_ONE);
		System.out.println(NumberUtils.FLOAT_ZERO);

		/* 1.NumberUtils.isNumber():判断字符串是否是数字 */
		NumberUtils.isNumber("5.96");// 结果是true
		NumberUtils.isNumber("s5");// 结果是false
		NumberUtils.isNumber("0000000000596");// 结果是true

		/* 2.NumberUtils.isDigits():判断字符串中是否全为数字 */
		NumberUtils.isDigits("0000000000.596");// false
		NumberUtils.isDigits("0000000000596");// true

		/* 3.NumberUtils.toInt():字符串转换为整数 */
		NumberUtils.toInt("5");
		NumberUtils.toLong("5");
		NumberUtils.toByte("3");
		NumberUtils.toFloat("3.2");
		NumberUtils.toDouble("4");
		NumberUtils.toShort("3");

		/* 4.NumberUtils.max():找出最大的一个 */
		NumberUtils.max(3, 1, 7);// 结果是7

		/* 5.NumberUtils.min():找出最小的一个 */
		NumberUtils.min(3, 1, 7);// 结果是1

		/*
		 * 6.NumberUtils.createBigDecimal()通过字符串创建BigDecimal类型，支持long、int、float、
		 * double、number等数值
		 */
		NumberUtils.createBigDecimal("1");
		NumberUtils.createLong("1");
		NumberUtils.createInteger("1");
	}
}

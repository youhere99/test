package test;

import org.junit.Test;

public class Exchange_Variable_Value {

	@Test
	public void testTempVar() {
		int x = 10;
		int y = 20;
		int temp = x;
		x = y;
		y = temp;
		System.out.println(x);
		System.out.println(y);
	}

	@Test
	public void testPlusMinus() {
		int x = 10;
		int y = 20;
		x = x + y;
		y = x - y;
		x = x - y;

		System.out.println(x);
		System.out.println(y);
	}

	@Test
	public void testXor() {
		int x = 10;
		int y = 20;
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println(x);
		System.out.println(y);
	}

	//算法的原理就是：任何数异或0值不变，任何数与自己异或值为0。
	@Test
	public void xor() {
		int[] arr = { 3, 9, 9, 2, 4, 2, 5, 5, 4 };
		int res = 0;//初始值 
		for (int i = 0; i < arr.length; i++) {
			res ^= arr[i];
		}
		System.out.println(res);
	}
}

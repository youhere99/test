package test;

import org.junit.Test;

public class TestDouble {

	@Test
	public void round() {
		System.out.println(0.05 + 0.01);

		System.out.println(1.0 - 0.42);

		System.out.println(4.015 * 100);

		System.out.println(123.3 / 100);
		System.out.println(Math.round(4.015 * 100) / 100.0);
	}

	@Test
	public void testString() {
		String a = "ab";
		String b = "a" + new String("b");
		String c = "ab";
		String d = new String("ab");
		System.out.println("------------a==b-------" + (a == b));
		System.err.println("------------a==c-------" + (a == c));
		System.out.println("------------a==d-------" + (a == d));
		System.err.println("------------a.equals(b)-------" + (a.equals(b)));
		System.err.println("------------a.equals(d)-------" + (a.equals(d)));
	}
}

package java8;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.Stream;

/**
 * 
 * description: Lambda&Java多核编程-4-Lambda变量捕获<br>
 * https://www.cnblogs.com/hwding/p/6485751.html
 * 
 * @author zhaomingxing 2018年10月15日
 *
 */
public class Bar {

	private static String lamdar = "lamdar";
	private String lamdar2 = "lamdar2";

	public static void main(String[] args) {
		DoubleUnaryOperator doubleUnaryOperator = x -> Math.abs(x);
		Stream.of(-0.1, 0.2, -0.3, 0.4, -0.5).map(e -> doubleUnaryOperator.applyAsDouble(e))
				.forEach(e -> System.out.println(e));

		// final double a = 3.141592;
		// double b = 3.141592;
		//
		// DoubleUnaryOperator anotherDoubleUnaryOperator = x -> {
		// a = 2;
		// b = 3;
		// return 0.0;
		// };

		final double[] a = { 3.141592 };
		final double[] b = { 3.141592 };
		// 不能修改地址,可以修改引用地址的内容
		DoubleUnaryOperator anotherDoubleUnaryOperator = x -> {
			a[0] = 2;
			b[0] = 3;
			Bar.lamdar = "lambda.change";
			new Bar().lamdar2 = "lambda2.change";

			return 0.0;
		};

		final int[] sum = { 0 };
		Stream.of(0, 1, 2, 3, 4, 5).forEach(e -> sum[0] += e);
		System.out.println(sum[0]);

		sum[0] = Stream.of(0, 1, 2, 3, 4, 5).parallel().mapToInt(e -> Integer.valueOf(e)).sum();
		System.out.println(sum[0]);

		new AClass().aMethod();
	}

	private static class AClass {
		private String aString = "Animal Farm";

		void aMethod() {
			new Thread(() -> aString = aString.concat(" is good.")).run();
			System.out.println(aString);
		}
	}
}
package beanutils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 
 * description:类型转换
 * 
 * @author zhaomingxing 2018年11月16日
 *
 */
public class TypeCastUtil {

	public static String objectToString(Object value) {
		if (String.class.isInstance(value)) {
			return "--" + (String) value;
		} else if (Integer.class.isInstance(value)) {
			return "--" + ((Integer) value).toString();
		} else if (BigDecimal.class.isInstance(value)) {
			return ((BigDecimal) value).toPlainString();
		} else {
			return value.toString();
		}
	}

	/**
	 * 测试
	 * 
	 * 2018年11月16日 zhaomingxing
	 */

	@Test
	public void test() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("String", String.CASE_INSENSITIVE_ORDER);
		map.put("BigDecimal", BigDecimal.ONE);
		map.put("Integer", Integer.MIN_VALUE);
		map.values().forEach(x -> {
			System.err.println(TypeCastUtil.objectToString(x));
		});
	}

	/**
	 * Java编程学习中instanceof和isInstance区别详解
	 * 
	 * 2018年11月17日 zhaomingxing
	 */
	// https://www.jianshu.com/p/ab95c3d7877e
	@Test
	public void testC() {

		Y y = new Y();

		X x = new X();

		X yx = new Y();

		System.out.println("=======1=======");

		System.out.println(y instanceof Y);

		System.out.println(y instanceof X);

		System.out.println(yx instanceof X);

		System.out.println(yx instanceof Y);

		System.out.println(x instanceof Y);

		System.out.println(y instanceof Object);

		System.out.println("=======2=======");

		System.out.println(y.getClass().isInstance(y));

		System.out.println(y.getClass().isInstance(x));

		System.out.println("=======3=======");

		System.out.println(x.getClass().isInstance(yx));

		System.out.println(y.getClass().isInstance(yx));

		System.out.println("=======4=======");

		System.out.println(X.class.isInstance(x));

		System.out.println(X.class.isInstance(y));

		System.out.println(X.class.isInstance(yx));

		System.out.println("=======5=======");

		System.out.println(Y.class.isInstance(x));

		System.out.println(Y.class.isInstance(y));

		System.out.println(Y.class.isInstance(yx));

		System.out.println("=======6=======");

		System.out.println(Object.class.isInstance(y));

	}
}

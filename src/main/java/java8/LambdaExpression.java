package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 * Title.<br>
 * Description.Lambda表达式
 * <p>
 * Copyright: Copyright (c) 2016年9月26日 下午5:07:59
 * <p>
 * Company: 北京传奇创世信息技术有限公司
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class LambdaExpression {

	@Test
	public void testComparator() {
		List<String> names = Arrays.asList("peter222", "anna3334444", "mike22442", "xenia");
		// 旧的写法
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}

		});
		System.err.println(names); // [xenia, peter222, mike22442, anna3334444]

		// lambda写法
		Collections.sort(names, (s1, s2) -> s1.length() - s2.length());
		System.err.println(names);
	}
}

package guava;

import java.util.Set;

import org.junit.Test;

import com.google.common.base.Optional;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2017年5月17日 下午3:05:42
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class OptionalTest {

	@Test
	public void testMethodReturn() {
		Optional<Long> value = method();
		if (value.isPresent() == true) {
			System.out.println("获得返回值: " + value.get());
		} else {

			System.out.println("获得返回值: " + value.or(-12L));
		}

		System.out.println("获得返回值 orNull: " + value.orNull());

		Optional<Long> valueNoNull = methodNoNull();
		if (valueNoNull.isPresent() == true) {
			Set<Long> set = valueNoNull.asSet();
			System.out.println("获得返回值 set 的 size : " + set.size());
			System.out.println("获得返回值: " + valueNoNull.get());
		} else {
			System.out.println("获得返回值: " + valueNoNull.or(-12L));
		}

		System.out.println("获得返回值 orNull: " + valueNoNull.orNull());
	}

	private Optional<Long> method() {
		return Optional.fromNullable(null);
	}

	private Optional<Long> methodNoNull() {
		return Optional.fromNullable(15L);
	}
}

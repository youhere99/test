package java8;

import java.util.Objects;
import java.util.function.Predicate;

import org.junit.Test;
import org.springframework.core.convert.converter.Converter;

class Lambda4 {
	static int outerStaticNum;
	int outerNum;

	void testScopes() {

		Converter<Integer, String> stringConverter1 = (from) -> {
			outerNum = 23;
			return String.valueOf(from);
		};

		Converter<Integer, String> stringConverter2 = (from) -> {
			outerStaticNum = 72;
			return String.valueOf(from);
		};
	}

	@Test
	public void testa() {
		Predicate<String> predicate = (s) -> (s).length() > 0;
		System.err.println(predicate.test("foo")); // true);

		System.err.println(predicate.negate().test("foo")); // false

		Predicate<Object> nonNull = Objects::nonNull;
		Predicate<Object> isNull = Objects::isNull;

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
	}
}
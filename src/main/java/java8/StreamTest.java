package java8;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// import java.util.stream.Collectors;
// import java.util.stream.IntStream;
// import java.util.stream.Stream;

/**
 * Title.<br>
 * Description.Stream语法详解
 * <p>
 * Copyright: Copyright (c) 2016年9月28日 上午9:51:39
 * <p>
 * Company: 北京传奇创世信息技术有限公司
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class StreamTest {
//你好吊的样子 --master
//你好吊的样子 --dev
	@Test
	public void testA() {
		List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
		Stream<Integer> stream = nums.stream();
		stream = stream.filter(num -> num != null);
		stream = stream.distinct();
		IntStream intStream = stream.mapToInt(num -> num * 2);
		intStream = intStream.peek(System.out::println);
		intStream = intStream.skip(2);
		intStream = intStream.limit(4);
		System.err.println(intStream.sum());
	}

	@Test
	public void testB() {
		List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
		List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null)
		        .collect(() -> new ArrayList<Integer>(), (list, item) -> list.add(item), (list1, list2) -> list1.addAll(list2));
		System.err.println(numsWithoutNull);

		numsWithoutNull = nums.stream().filter(num -> num != null).collect(Collectors.toList());
		System.err.println(numsWithoutNull);
	}
}

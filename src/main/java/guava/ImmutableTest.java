package guava;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2017年5月17日 下午3:22:42
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class ImmutableTest {

	// Collections.unmodifiableList实现的不是真正的不可变集合，当原始集合修改后，不可变集合也发生变化。不可变集合不可以修改集合数据，当强制修改时会报错，实例中的最后两个add会直接抛出不可修改的错误。
	@Test
	public void testJDKImmutable() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");

		System.out.println(list);

		List<String> unmodifiableList = Collections.unmodifiableList(list);

		System.out.println(unmodifiableList);

		List<String> unmodifiableList1 = Collections.unmodifiableList(Arrays.asList("a", "b", "c"));
		System.out.println(unmodifiableList1);

		String temp = unmodifiableList.get(1);
		System.out.println("unmodifiableList [0]：" + temp);

		list.add("baby");
		System.out.println("list add a item after list:" + list);
		System.out.println("list add a item after unmodifiableList:" + unmodifiableList);

		unmodifiableList1.add("bb");
		System.out.println("unmodifiableList add a item after list:" + unmodifiableList1);

		unmodifiableList.add("cc");
		System.out.println("unmodifiableList add a item after list:" + unmodifiableList);
	}

	@Test
	public void testGuavaImmutable() {

		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println("list：" + list);

		ImmutableList<String> imlist = ImmutableList.copyOf(list);
		System.out.println("imlist：" + imlist);

		ImmutableList<String> imOflist = ImmutableList.of("peida", "jerry", "harry");
		System.out.println("imOflist：" + imOflist);

		ImmutableSortedSet<String> imSortList = ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
		System.out.println("imSortList：" + imSortList);

		list.add("baby");
		System.out.println("list add a item after list:" + list);
		System.out.println("list add a item after imlist:" + imlist);

		ImmutableSet<Color> imColorSet = ImmutableSet.<Color> builder().add(new Color(0, 255, 255)).add(new Color(0, 191, 255)).build();

		System.out.println("imColorSet:" + imColorSet);
	}
}

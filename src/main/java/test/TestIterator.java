package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;
import org.apache.commons.collections4.map.HashedMap;

/**
 * 迭代器的扩展 1.MapIterator 以后不再使用map.keySet.iterator访问 借助接口IterableMap的实现类HashedMap
 * 2.UniqueFilterIterator 去重迭代器 3.FilterIterator 自定义过滤 + Predicate 4.new
 * LoopingIterator() 循环迭代器 5.new ArrayListIterator() 数组迭代器
 */

public class TestIterator {

	public static void main(String[] args) {
		testMapIt();
		testUniqueIt();
		testFilterIt();
		testLoopingIt();
		testArrayListIt();
	}

	/**
	 * map迭代器
	 */
	public static void testMapIt() {
		System.out.println("============map迭代器====================");
		IterableMap<String, String> map = new HashedMap<String, String>();
		map.put("a", "abcd");
		map.put("b", "is");
		map.put("c", "good");
		// 使用MapIterator
		MapIterator<String, String> it = map.mapIterator();
		while (it.hasNext()) {
			// 一定要it.next() 移动游标
			/**
			 * it.next() String key = it.getKey();
			 */
			String key = it.next();
			String value = it.getValue();
			System.out.println(key + "-->>" + value);
		}
	}

	/**
	 * 去重迭代器
	 */
	public static void testUniqueIt() {
		System.out.println("=========去重迭代器=================");
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("a");
		// 去除重复的过滤器
		Iterator<String> it = new UniqueFilterIterator(list.iterator());
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	/**
	 * 自定义过滤迭代器
	 */
	public static void testFilterIt() {
		System.out.println("=========自定义过滤迭代器=================");
		List<String> list = new ArrayList<String>();
		list.add("refer");
		list.add("dad");
		list.add("abcd");
		list.add("moon");
		// 自定义条件判断
		Predicate<String> pre = new Predicate<String>() {

			@Override
			public boolean evaluate(String value) {
				// 回文判断
				return new StringBuilder(value).reverse().toString().equals(value);
			}
		};
		// 回文的过滤器
		Iterator<String> it = new FilterIterator(list.iterator(), pre);
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	/**
	 * 循环迭代器
	 */
	public static void testLoopingIt() {
		System.out.println("=========循环迭代器=================");
		List<String> list = new ArrayList<String>();
		list.add("refer");
		list.add("dad");
		list.add("abcd");
		list.add("moon");

		Iterator<String> it = new LoopingIterator(list);
		for (int i = 0; i < 6; i++) {
			System.out.println(it.next());
		}
	}

	/**
	 * 数组迭代器
	 */
	public static void testArrayListIt() {
		System.out.println("=========数组迭代器=================");
		int[] arr = { 1, 2, 3, 4, 5 };
		Iterator<Integer> it1 = new ArrayListIterator<Integer>(arr);
		System.out.println("不指定索引，打印全部元素：");
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		// 指定起始索引和结束索引
		Iterator<Integer> it2 = new ArrayListIterator<Integer>(arr, 1, 3);
		System.out.println("指定起始索引和结束索引：");
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
	}
}

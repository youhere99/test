package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.bag.TreeBag;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.apache.commons.collections.iterators.ArrayListIterator;
import org.apache.commons.collections.iterators.FilterIterator;
import org.apache.commons.collections.iterators.LoopingIterator;
import org.apache.commons.collections.iterators.UniqueFilterIterator;
import org.apache.commons.collections.map.MultiValueMap;
import org.junit.Test;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2016年11月21日 下午1:52:23
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class TestApacheCommonCollections {

	/**
	 * 功能：使用MultiMap实现一键存储多个值 <br/>
	 * 2016年11月21日下午2:06:18 zhaomingxing
	 */
	@Test
	public void testMultiMap() {
		MultiMap map = new MultiValueMap();
		map.put("key", "value1");
		map.put("key", "value2");
		map.put("key", "value2");
		System.out.println(map.get("key"));
	}

	/**
	 * 功能： 使用BidiMap实现根据值检索键 <br/>
	 * 2016年11月21日下午2:07:26 zhaomingxing
	 */
	@Test
	public void testBidiMap() {
		BidiMap map = new DualHashBidiMap();
		map.put("key1", "value");
		System.out.println(map.get("key1"));
		System.out.println(map.inverseBidiMap().get("value"));
	}

	/**
	 * 功能：循环迭代器LoopingIterator <br/>
	 * 2016年11月21日下午1:52:32 zhaomingxing
	 */
	@Test
	public void testLoopingIterator() {
		List<String> books = new ArrayList<String>();
		books.add("EnglishBook");
		books.add("Commons Cookbook");
		books.add("Who Moved My Cheese");
		// 当迭代到最后的元素后，再返回第一个元素重新循环，直至达到迭代次数为止
		LoopingIterator iterator = new LoopingIterator(books);
		for (int i = 0; i < 5; i++) {
			String book = (String) iterator.next();
			System.out.println(book + ";");
		}
	}

	/**
	 * 功能： ArrayList迭代器ArrayListIterator 可以自定义范围地遍历<br/>
	 * 2016年11月21日下午1:56:40 zhaomingxing
	 */
	@Test
	public void testArrayListIterator() {
		String[] arrays = new String[] { "a", "b", "c", "d", "f" };
		// 遍历下标为1到4的元素
		Iterator<String> iterator = new ArrayListIterator(arrays, 1, 4);
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + "; ");
		}
	}

	/**
	 * 功能：筛选迭代器FilterIterator <br/>
	 * 2016年11月21日下午2:00:43 zhaomingxing
	 */
	@Test
	public void testFilterIterator() {
		List<String> list = new ArrayList(Arrays.asList(new Integer[] { 7, 9, 35, 67, 88 }));

		// 过滤出大于30的元素
		Predicate predicate = new Predicate() {

			@Override
			public boolean evaluate(Object object) {
				int num = ((Integer) object).intValue();
				return num > 30;
			}
		};
		Iterator<String> iterator = new FilterIterator(list.iterator(), predicate);
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + "; ");
		}
	}

	/**
	 * 功能：过滤重复的元素UniqueFilterIterator <br/>
	 * 2016年11月21日下午2:01:55 zhaomingxing
	 */
	@Test
	public void testUniqueFilterIterator() {
		List list = new ArrayList(Arrays.asList(new String[] { "a", "b", "c", "b", "a" }));

		Iterator iterator = new UniqueFilterIterator(list.iterator());
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + "; ");
		}
	}

	/**
	 * 功能：TreeBag可以保存加入元素的顺序 <br/>
	 * 2016年11月21日下午2:04:00 zhaomingxing
	 */
	@Test
	public void testTreeBag() {
		Bag bag1 = new TreeBag();
		bag1.add("book1", 2);
		bag1.add("book2", 1);
		bag1.add("book3", 2);
		bag1.add("book4", 1);
		bag1.add("book5", 1);

		Iterator iterator = bag1.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}

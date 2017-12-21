package guava;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * Title.<br>
 * Description.Ordering犀利的比较器
 * <p>
 * Copyright: Copyright (c) 2017年5月17日 下午2:23:05
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class OrderingTest {

	@Test
	public void testStaticOrdering() {
		List<String> list = Lists.newArrayList();
		list.add("peida");
		list.add("jerry");
		list.add("harry");
		list.add("eva");
		list.add("jhon");
		list.add("neron");

		System.out.println("list:" + list);

		Ordering<String> naturalOrdering = Ordering.natural();
		Ordering<Object> usingToStringOrdering = Ordering.usingToString();
		Ordering<Object> arbitraryOrdering = Ordering.arbitrary();

		System.out.println("naturalOrdering:" + naturalOrdering.sortedCopy(list));
		System.out.println("usingToStringOrdering:" + usingToStringOrdering.sortedCopy(list));
		System.out.println("arbitraryOrdering:" + arbitraryOrdering.sortedCopy(list));
	}

	@Test
	public void testOrdering() {
		List<String> list = Lists.newArrayList();
		list.add("peida");
		list.add("jerry");
		list.add("harry");
		list.add("eva");
		list.add("jhon");
		list.add("neron");

		System.out.println("list:" + list);

		Ordering<String> naturalOrdering = Ordering.natural();
		System.out.println("naturalOrdering:" + naturalOrdering.sortedCopy(list));

		List<Integer> listReduce = Lists.newArrayList();
		for (int i = 9; i > 0; i--) {
			listReduce.add(i);
		}

		List<Integer> listtest = Lists.newArrayList();
		listtest.add(1);
		listtest.add(1);
		listtest.add(1);
		listtest.add(2);

		Ordering<Integer> naturalIntReduceOrdering = Ordering.natural();

		System.out.println("listtest:" + listtest);
		System.out.println(naturalIntReduceOrdering.isOrdered(listtest));
		System.out.println(naturalIntReduceOrdering.isStrictlyOrdered(listtest));

		System.out.println("naturalIntReduceOrdering:" + naturalIntReduceOrdering.sortedCopy(listReduce));
		System.out.println("listReduce:" + listReduce);

		System.out.println(naturalIntReduceOrdering.isOrdered(naturalIntReduceOrdering.sortedCopy(listReduce)));
		System.out.println(naturalIntReduceOrdering.isStrictlyOrdered(naturalIntReduceOrdering.sortedCopy(listReduce)));

		Ordering<String> natural = Ordering.natural();

		List<String> abc = ImmutableList.of("a", "b", "c");
		System.out.println(natural.isOrdered(abc));
		System.out.println(natural.isStrictlyOrdered(abc));

		System.out.println("isOrdered reverse :" + natural.reverse().isOrdered(abc));

		List<String> cba = ImmutableList.of("c", "b", "a");
		System.out.println(natural.isOrdered(cba));
		System.out.println(natural.isStrictlyOrdered(cba));
		System.out.println(cba = natural.sortedCopy(cba));

		System.out.println("max:" + natural.max(cba));
		System.out.println("min:" + natural.min(cba));

		System.out.println("leastOf:" + natural.leastOf(cba, 2));
		System.out.println("naturalOrdering:" + naturalOrdering.sortedCopy(list));
		System.out.println("leastOf list:" + naturalOrdering.leastOf(list, 3));
		System.out.println("greatestOf:" + naturalOrdering.greatestOf(list, 3));
		System.out.println("reverse list :" + naturalOrdering.reverse().sortedCopy(list));
		System.out.println("isOrdered list :" + naturalOrdering.isOrdered(list));
		System.out.println("isOrdered list :" + naturalOrdering.reverse().isOrdered(list));
		list.add(null);
		System.out.println(" add null list:" + list);
		System.out.println("nullsFirst list :" + naturalOrdering.nullsFirst().sortedCopy(list));
		System.out.println("nullsLast list :" + naturalOrdering.nullsLast().sortedCopy(list));
	}
}

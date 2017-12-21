package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class TestCheckedList {

	@Test
	public void checkedList() {
		String[] str_array = new String[] { "one", "two", "three", "four" };
		List<String> list = Arrays.asList(str_array);
		for (String s : list) {
			System.out.println(s);
		}
		List<String> checkedList = Collections.checkedList(list, String.class);
		for (String s : checkedList) {
			System.out.println(s);
		}
	}

	@Test
	public void copyCollections() {
		String[] str = new String[] { "one", "two", "three", "four" };
		List<String> list = Arrays.asList(str);
		System.out.println(str);// [Ljava.lang.String;@1ee148b
		System.out.println(list);// [one, two, three, four]
		List<String> copylist = Arrays.asList(str);
		boolean bool = Collections.disjoint(list, copylist);// 如果没有相同的元素则返回true
		System.out.println(bool);
		Collections.fill(list, "four");//
		// 使用指定元素替换指定列表中的所有元素。此时str[]={"four","four","four","four"}
		int thisNUM = Collections.frequency(list, "four");// 返回指定 collection
		// 中等于指定对象的元素数。
		System.out.println(thisNUM);
		copylist = copylist.subList(1, 3);
		// thisNUM = Collections.indexOfSubList(list, );
		System.out.println(thisNUM);

		List<String> listNew = new ArrayList<String>(list);
		System.out.println(listNew);
		List<String> listCopy = new ArrayList<String>(list);
		Collections.copy(listCopy, listNew);
		System.out.println(listCopy);

	}

	@Test
	public void testArrays() {
		String[] str = new String[] { "one", "two", "three", "four" };
		String[] strNew = Arrays.copyOf(str, 10);// 新地址[one, two, three, four,
		// null, null, null, null,
		// null, null]
		for (String s : strNew) {
			System.out.println(s);
		}
		System.out.println(Arrays.toString(str));// [one, two, three, four]
		System.err.println(strNew);
		System.out.println(Arrays.deepEquals(str, strNew));
		System.err.println("===================================================");
		String str2 = "1,2,";
		String[] str_s = StringUtils.split(str2);
		System.err.println(Arrays.toString(str_s));// [1,2,]
		str_s = StringUtils.split(str2, ",");
		System.err.println(Arrays.toString(str_s));// [1, 2]
		System.err.println(StringUtils.join(str_s, ","));// 1,2
		System.err.println(StringUtils.join(str_s));// 12
	}

	@Test
	public void testArrayUtils() {
		String[] str = new String[] { "one", "two", "three", "four" };
		String[] strNew = ArrayUtils.clone(str);
		System.out.println(Arrays.deepToString(str));
		System.out.println(Arrays.deepToString(strNew));

		int[] arrayInt = new int[] { 1, 3, 5 };
		int index = ArrayUtils.indexOf(arrayInt, 3, 2);
		System.out.println(index);
	}

	@Test
	public void testEquals() {
		Object o[] = { "Rose", "India", "Net", "Limited", "Rohini" };
		// Object o1[]={"Rose","India","Net","Limited","Rohini"};
		Object o1[] = { "Rohini", "Limited", "Net", "India", "Rose" };
		boolean b = Arrays.deepEquals(o, o1);
		boolean a = Arrays.equals(o, o1);
		System.out.println("Array are equal:-" + b);
		System.out.println(a);

	}

	@Test
	public void testDeepEquals() {
		String[][] ticTacToe1 = { { " O ", " O ", " X " }, { " O ", " X ", " X " }, { " X ", " O ", " O " } };
		String[][] ticTacToe2 = { { " O ", " O ", " X " }, { " O ", " X ", " X " }, { " X ", " O ", " O " } };
		System.out.println(Arrays.equals(ticTacToe1, ticTacToe2));// false
		System.out.println(Arrays.deepEquals(ticTacToe1, ticTacToe2));// true

		String[] ticTacToe3 = { " O ", " O ", " X " };
		String[] ticTacToe4 = { " O ", " O ", " X " };

		System.out.println(Arrays.equals(ticTacToe3, ticTacToe4)); // true

	}

	@Test
	public void deepEquals() {
		String[][] b = new String[3][4];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				b[i][j] = "A" + j;
			}

		}
		String content = Arrays.deepToString(b);
		System.out.println("Hello World!: " + content);
		String content1 = Arrays.toString(b);
		System.out.println("Hello World!: " + content1);
		String[] ticTacToe3 = { " O ", " O ", " X " };
		System.out.println(ticTacToe3);
		System.out.println(ticTacToe3.toString());
		System.out.println(Arrays.toString(ticTacToe3));
	}

	@Test
	public void testCopyOnWriteArrayList() {
		String[] str = { "one", "two", "three", "four" };
		List<String> list = new CopyOnWriteArrayList<String>(Arrays.asList(str));
		for (String s : list) {
			System.out.println(s);
			list.add("99999999");
		}
		System.err.println("---------------------");
		// list = new ArrayList<String>(Arrays.asList(str));
		for (String s : list) {
			System.out.println(s + "-------");
		}
	}

	@Test
	public void testList() {
		List<String> l1 = new ArrayList<String>();
		List<Integer> l2 = new ArrayList<Integer>();
		System.out.println(l1.getClass() == l2.getClass());
	}
}

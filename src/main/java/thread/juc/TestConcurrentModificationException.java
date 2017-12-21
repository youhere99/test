package thread.juc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2017年6月14日 上午9:41:27
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class TestConcurrentModificationException {

	@Test
	public void test() {
		List<String> myList = new ArrayList<String>();
		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");
		// remove(myList);
		// removeA(myList);
		// removeB(myList);
		// myList = new CopyOnWriteArrayList<String>(myList);
		// removeC(myList);
		removeD(myList);
		System.out.println(Arrays.deepToString(myList.toArray()));
	}

	public void remove(List<String> myList) {
		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String value = it.next();
			if (value.equals("3")) {
				myList.remove(value); // error
			}
		}
	}

	// 1 使用Iterator提供的remove方法，用于删除当前元素
	public void removeA(List<String> myList) {
		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String value = it.next();
			if (value.equals("3")) {
				it.remove(); // ok
			}
		}

	}

	// 2 建一个集合，记录需要删除的元素，之后统一删除
	public void removeB(List<String> myList) {
		List<String> templist = new ArrayList<String>();
		for (String value : myList) {
			if (value.equals("3")) {
				templist.add(value);
			}
		}
		// 可以查看removeAll源码，其中使用Iterator进行遍历
		myList.removeAll(templist);
	}

	// 3. 使用线程安全CopyOnWriteArrayList进行删除操作
	public void removeC(List<String> myList) {
		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String value = it.next();
			if (value.equals("3")) {
				myList.remove("4");
				myList.add("6");
				myList.add("7");
			}
		}
	}

	// 4. 不使用Iterator进行遍历，需要注意的是自己保证索引正常
	public void removeD(List<String> myList) {
		for (int i = 0; i < myList.size(); i++) {
			String value = myList.get(i);
			if (value.equals("3")) {
				myList.remove(value); // ok
				// i--; // 因为位置发生改变，所以必须修改i的位置???????????
			}
		}
	}
}

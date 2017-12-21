package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.apache.commons.beanutils.BeanPropertyValueChangeClosure;
import org.apache.commons.beanutils.BeanPropertyValueEqualsPredicate;
import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import entity.User;

public class CollectionsTest {

	@Test
	public void testMap() {
		Map<Long, String> map = new HashMap<Long, String>();
		map.put(1L, "A");
		map.put(2L, "B");
		map.put(3L, "C");
		map.put(4L, "D");
		map.put(5L, "E");
		map.put(6L, "F");
		map.put(7L, "G");
		map.put(8L, "H");
		System.out.print(map.get(1));
		System.out.print(map.get(1L));
	}

	@Test
	public void newSetFromMap_() {
		// create map
		Map<String, Boolean> map = new WeakHashMap<String, Boolean>();

		// create a set from map
		Set<String> set = Collections.newSetFromMap(map);

		// add values in set
		set.add("Java");
		set.add("C");
		set.add("C++");

		// set and map values are
		System.out.println("Set is: " + set);
		System.out.println("Map is: " + map);

	}

	@Test
	public void rotate_() {

		String[] str = { "1", "2", "3", "4", "5", "6" };
		List<String> list = Arrays.asList(str);
		System.out.println(list);
		Collections.rotate(list, 1);
		System.out.println(list);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void singleton_() {
		// create an array of string objs
		String init[] = { "One", "Two", "Three", "One", "Two", "Three" };

		// create two lists
		List list1 = new ArrayList(Arrays.asList(init));
		List list2 = new ArrayList(Arrays.asList(init));
		System.out.println(list1);
		// remove from list1
		list1.remove("One");
		System.out.println("List1 value: " + list1);

		list2.remove(Collections.singleton("One"));
		System.out.println("The SingletonList is :" + list2);

		// remove from list2 using singleton
		list2.removeAll(Collections.singleton("One"));
		System.out.println("The SingletonList is :" + list2);

	}

	/**
	 * 功能：
	 * <P>
	 * 2017年12月11日下午3:07:57 zhaomingxing
	 */
	@Test
	public void testA() {
		List<User> userList = new ArrayList<User>();
		User u1 = new User();
		u1.setUserId(1l);
		u1.setUsername("chenpi1");
		u1.setGender(true);
		User u2 = new User();
		u2.setUserId(2l);
		u2.setUsername("chenpi2");
		u2.setGender(true);
		User u3 = new User();
		u3.setUserId(3l);
		u3.setUsername("chenpi3");
		u3.setGender(false);
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);

		// 批量修改集合
		BeanPropertyValueChangeClosure closure = new BeanPropertyValueChangeClosure("username", "updateName");

		CollectionUtils.forAllDo(userList, closure);

		for (User tmp : userList) {
			System.out.println(tmp.getUsername());
		}

		BeanPropertyValueEqualsPredicate predicate = new BeanPropertyValueEqualsPredicate("gender", Boolean.TRUE);

		// 过滤集合
		CollectionUtils.filter(userList, predicate);
		for (User tmp : userList) {
			System.out.println(tmp);
		}

		// 创建transformer
		BeanToPropertyValueTransformer transformer = new BeanToPropertyValueTransformer("userId");

		// 将集合中所有你user的id传输到另外一个集合上
		Collection<?> idList = CollectionUtils.collect(userList, transformer);
		for (Object id : idList) {
			System.out.println(id);
		}
		// CollectionUtils.filter(userList, new Predicate() {
		//
		// @Override
		// public boolean evaluate(User arg0) {
		// // TODO Auto-generated method stub
		// return false;
		// }
		//
		// });
	}

	@Test
	public void whenFilterWithIterables_thenFiltered() {
		List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
		Iterable<String> result = Iterables.filter(names, Predicates.containsPattern("a"));
	}
}

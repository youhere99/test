/*
 * File Name: BeanUtilsTest.java
 * Description: 
 * Author: http://www.cnblogs.com/chenpi/
 * Create Date: 2017年5月30日
 */
package beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import entity.User;

/**
 * 
 * @author https://www.cnblogs.com/chenpi/p/6920896.html
 * @version 2017年5月30日
 */

public class BeanUtilsTest {

	@Test
	public void test()
			throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", "001");
		// map.put("address", "hz");
		map.put("age", "100");
		map.put("state", false);
		map.put("others", "others");

		User u = new User();
		BeanUtils.populate(u, map);
		System.out.println("BeanUtils.populate(u, map):::" + u);

		User u1 = new User();
		// 深克隆
		BeanUtils.copyProperties(u1, u);

		u.setAge(120);
		System.out.println("BeanUtils.copyProperties(u1, u):::" + u1);

		System.err.println("u.equals(u1):::" + u.equals(u1));

		Object cloneBean = BeanUtils.cloneBean(u1);

		System.err.println("BeanUtils.cloneBean(u1):::" + cloneBean);

	}
}
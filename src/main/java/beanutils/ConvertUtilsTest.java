package beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.StringConverter;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import entity.User;

/**
 * https://www.cnblogs.com/chenpi/p/6920896.html<br>
 * description:类型转换工具类
 * 
 * @author zhaomingxing 2018年11月15日
 *
 */
public class ConvertUtilsTest {

	@Test
	public void testA() {

		Integer value = new Integer(500);
		System.err.println("ConvertUtils.convert(value):::" + ConvertUtils.convert(value));

		System.err.println("ConvertUtils.convert(value.toString(), String.class):::"
				+ ConvertUtils.convert(value.toString(), String.class));

		ConcurrentMap<String, Object> newConcurrentMap = Maps.newConcurrentMap();
		newConcurrentMap.put("valueInteger", value);
		System.err.println("ConvertUtils.convert(newConcurrentMap.get(\"valueInteger\")):::"
				+ ConvertUtils.convert(newConcurrentMap.get("valueInteger")));

		System.err.println("ConvertUtils.convert(newConcurrentMap.get(\"valueInteger\"), Integer.class):::"
				+ ConvertUtils.convert(newConcurrentMap.get("valueInteger"), Integer.class));

		System.err.println("ConvertUtils.convert(newConcurrentMap.get(\"valueInteger\"), String.class):::"
				+ ConvertUtils.convert(newConcurrentMap.get("valueInteger"), String.class));

		Double convert = (Double) ConvertUtils.convert(newConcurrentMap.get("valueInteger"), Double.class);
		System.err.println("ConvertUtils.convert(newConcurrentMap.get(\"valueInteger\"), Double.class):::" + convert);

		String[] arr = { "1", "2", "3", "4", "5", "6" };

		Integer[] list = (Integer[]) ConvertUtils.convert(arr, Integer[].class);
		System.err.println("ConvertUtils.convert(arr, Integer[].class):::");
		Lists.newArrayList(list).forEach(System.out::println);

		StringConverter stringConverter = new StringConverter("3");
		System.err.println(
				" stringConverter.convert(Integer.class, \"5\"):::" + stringConverter.convert(Integer.class, "5"));
		System.err.println(
				"(stringConverter.convert(Integer.class, \"aa\"):::" + stringConverter.convert(Integer.class, "aa"));

	}

	@Test
	public void testB() throws IllegalAccessException, InvocationTargetException {

		ConvertUtils.register(new CustomStringConverter(), String.class);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", "001");
		map.put("address", "hz");
		map.put("age", 100);
		map.put("gender", true);

		User u = new User();
		BeanUtils.populate(u, map);

		System.out.println(u);
	}

}

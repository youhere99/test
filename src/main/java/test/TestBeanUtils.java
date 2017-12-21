package test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;

import entity.User;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2017年12月5日 上午10:34:01
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class TestBeanUtils {

	private Person person;

	@Before
	public void initPerson() {
		person = new Person();
		person.setUserName("A");
		person.setBirthDay(new Date());
		person.setAddress(new String[] { "cc", "dd" });
		Son son = new Son();
		son.setUserName("AB");
		son.setBirthDay(new java.sql.Date(new Date().getTime()));
		person.setSon(son);
	}

	@Test
	public void testBeanUtils() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

		Person clone = (Person) BeanUtils.cloneBean(person);
		System.err.println(person == clone);
		System.err.println(person.getSon() == clone.getSon());

		Son son = (Son) BeanUtils.cloneBean(person.getSon());
		clone.setSon(son);
		System.err.println(person.getSon() == clone.getSon());

		Person person = new Person();
		BeanUtils.copyProperty(person, "userName", "cloneA");

		BeanUtils.copyProperties(this.person, person);

		person.setSon(son);
		BeanUtils.copyProperties(this.person, person);

		Map<String, String> map = BeanUtils.describe(person);
		System.err.println(map);
		String[] s = BeanUtils.getArrayProperty(clone, "userName");
		System.err.println(s);

		String ss = BeanUtils.getIndexedProperty(clone, "address[0]");
		System.err.println(ss);
		ss = BeanUtils.getIndexedProperty(clone, "address", 1);
		System.err.println(ss);

		ss = BeanUtils.getNestedProperty(clone, "son.userName");
		System.err.println(ss);
		Map<String, String> m = new HashMap<String, String>();
		m.put("a", "aaaaaaaaa");
		m.put("userName", "aaaaaaaaa");
		m.put("birthDay", "2010-10-10");
		// 没有给Date注册转换器，抛出ConversionException异常
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.populate(clone, m);
		System.err.println(m);
		BeanUtils.copyProperties(this.person, clone);
		System.err.println(this.person);
		// ConvertUtils除了给指定类型注册转换器外，还可以将数据转换为指定类型
		String age = "21";
		Long ageLong = (Long) ConvertUtils.convert(age, long.class);
		System.err.println(ageLong);
		BigDecimal ageBigDecimal = (BigDecimal) ConvertUtils.convert(age, BigDecimal.class);
		System.err.println(ageBigDecimal);

		Date date = (Date) ConvertUtils.convert("2010-10-10", Date.class);
		System.err.println(date);
		Converter longConverter = new LongConverter();
		ConvertUtils.register(longConverter, Long.TYPE); // Native type
		ConvertUtils.register(longConverter, Long.class); // Wrapper class
		Converter doubleConverter = new DoubleConverter();
		ConvertUtils.register(doubleConverter, Double.TYPE); // Native type
		ConvertUtils.register(doubleConverter, Double.class); // Wrapper class
		// dozer
		Mapper mapper = new DozerBeanMapper();
		User user = mapper.map(clone, User.class);
		System.err.println(user);
	}

}

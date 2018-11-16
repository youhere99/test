package beanutils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.LazyDynaBean;

/**
 * Title.<br>
 * Description.动态地生成类，并设置值和取得值，，，，https://www.cnblogs.com/chenpi/p/6919343.html
 * <p>
 * Copyright: Copyright (c) 2014-10-30 上午10:36:05
 * <p>
 * Company: 北京金瑞帆科技有限公司
 * <p>
 * 
 * @author zhaomx
 * @version 1.0
 */
public class LazyDynaBeanExample {

	public static void main(String[] args) {
		try {
			LazyDynaBean person = new LazyDynaBean();
			person.set("name", "deng");
			person.set("password", "123");
			System.out.println(person.get("name"));
			System.out.println(person.get("password"));
			// System.err.println(new Gson().toJson(person));

			System.out.println(BeanUtils.getProperty(person, "name"));
			System.out.println(BeanUtils.getProperty(person, "password"));
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// public void test

}

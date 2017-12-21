package com.reflect;

import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;
import org.springframework.util.ReflectionUtils.FieldFilter;

/**
 * 
 * Title.<br> 
 * Description.spring 反射工具类
 * <p>
 * Copyright: Copyright (c) 2015年11月19日 下午9:49:39
 * <p>
 * Company: 北京金瑞帆科技有限公司
 * <p>
 * @author zhaomingxing
 * @version 1.0
 */

public class SpringReflectionUtils {

	public static void main(String args[]) {
		ReflectionUtils.doWithFields(Persons.class, new FieldCallback() {

			@Override
			public void doWith(Field arg0) throws IllegalArgumentException, IllegalAccessException {
				System.err.println(arg0);

			}

		});
		ReflectionUtils.doWithFields(Persons.class, new FieldCallback() {

			@Override
			public void doWith(Field arg0) throws IllegalArgumentException, IllegalAccessException {
				System.err.println(arg0);

			}

		}, new FieldFilter() {

			@Override
			public boolean matches(Field arg0) {

				return arg0.getName() == "age" ? true : false;
			}

		});

		Field field = ReflectionUtils.findField(Persons.class, "age");
		System.err.println(field.getName());

	}
}

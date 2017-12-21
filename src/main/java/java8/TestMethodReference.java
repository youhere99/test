package java8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

import java8.Person.Sex;

/**
 * Title.<br>
 * Description.Java8之方法引用
 * <p>
 * Copyright: Copyright (c) 2017年5月25日 下午4:31:43
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class TestMethodReference {

	// 引用静态方法
	@Test
	public void testA() {
		Person[] persons = new Person[2];
		persons[0] = new Person("A", LocalDate.now(), Sex.MALE, "a");
		persons[1] = new Person("B", LocalDate.now(), Sex.FEMALE, "b");
		// 使用匿名类
		Arrays.sort(persons, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.birthday.compareTo(o2.birthday);
			}
		});

		// 使用lambda表达式
		Arrays.sort(persons, (o1, o2) -> o1.birthday.compareTo(o2.birthday));

		// 使用lambda表达式和类的静态方法
		Arrays.sort(persons, (o1, o2) -> Person.compareByAge(o1, o2));

		// 使用方法引用
		// 引用的是类的静态方法
		Arrays.sort(persons, Person::compareByAge);
	}
}

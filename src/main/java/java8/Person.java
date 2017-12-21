package java8;

import java.time.LocalDate;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2017年5月25日 下午4:30:28
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	String name;

	LocalDate birthday;

	Sex gender;

	String emailAddress;

	public String getEmailAddress() {
		return emailAddress;
	}

	public Sex getGender() {
		return gender;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public String getName() {
		return name;
	}

	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}

	public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}

	public Person() {
		super();
	}

}

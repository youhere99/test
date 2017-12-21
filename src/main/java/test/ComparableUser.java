package test;

import java.util.Arrays;

public class ComparableUser implements Comparable<ComparableUser> {

	private String id;

	private int age;

	public ComparableUser(String id, int age) {
		this.id = id;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 测试方法
	 */
	public static void main(String[] args) {
		ComparableUser[] users = new ComparableUser[] { new ComparableUser("u1001", 25), new ComparableUser("u1002", 20),
		        new ComparableUser("u1003", 21) };
		Arrays.sort(users);
		for (int i = 0; i < users.length; i++) {
			ComparableUser user = users[i];
			System.out.println(user.getId() + " " + user.getAge());
		}
	}

	public int compareTo(ComparableUser o) {
		return this.age - o.getAge();
	}

}

package test;

import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.io.FileUtils;

import entity.User;

public class UserComparator implements Comparator<User> {

	/**
	 * 测试方法
	 */
	public static void main(String[] args) {
		User[] users = new User[] { new User("u1001", 25), new User("u1002", 20), new User("u1003", 21) };
		Arrays.sort(users, new UserComparator());
		for (int i = 0; i < users.length; i++) {
			User user = users[i];
			System.out.println(user.getUsername() + " " + user.getAge());
		}
		System.out.println(FileUtils.getTempDirectoryPath());
		System.out.println(FileUtils.getUserDirectoryPath());
	}

	public int compare(User o1, User o2) {
		return o1.getAge() - o2.getAge();
	}
}

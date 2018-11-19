package entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class User implements Serializable {

	/**
	 * serialVersionUID上午10:01:27
	 */
	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private boolean gender;

	private int age;

	private Long userId;

	private Profile profile;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public User(String username, int age) {
		super();
		this.username = username;
		this.age = age;
	}

	public User() {
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}

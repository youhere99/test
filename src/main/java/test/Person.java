package test;

import java.io.Serializable;
import java.util.Date;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2017年12月5日 上午10:51:36
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class Person implements Serializable {

	private String userName;

	private Date birthDay;

	private Son son;

	private String[] address;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Son getSon() {
		return son;
	}

	public void setSon(Son son) {
		this.son = son;
	}

	public String[] getAddress() {
		return address;
	}

	public void setAddress(String[] address) {
		this.address = address;
	}

}

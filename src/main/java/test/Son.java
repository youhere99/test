package test;

import java.io.Serializable;
import java.sql.Date;

/**
 * Title.<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2017年12月5日 上午11:21:44
 * <p>
 * Company: 翡翠教育
 * <p>
 * 
 * @author zhaomingxing
 * @version 1.0
 */
public class Son implements Serializable {

	private String userName;

	private Date birthDay;

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

}

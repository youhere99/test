package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class Profile implements Serializable {

	private String email;

	private Date birthDate;

	private Address[] address;

	private Map<String, String> phone;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Address[] getAddress() {
		return address;
	}

	public void setAddress(Address[] address) {
		this.address = address;
	}

	public Map<String, String> getPhone() {
		return phone;
	}

	public void setPhone(Map<String, String> phone) {
		this.phone = phone;
	}
}
package entity;

import java.io.Serializable;

public class Address implements Serializable {

	private String country;

	private String city;

	private String addr;

	private String postcode;

	public Address(String country, String city, String addr, String postcode) {
		this.country = country;
		this.city = city;
		this.addr = addr;
		this.postcode = postcode;
	}

	public Address() {
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}

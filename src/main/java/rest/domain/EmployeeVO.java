package rest.domain;

import java.io.Serializable;


public class EmployeeVO implements Serializable {

	private  Integer id;
	private  String name;
	private  String ident;
	private  String email;
	
	private Address address;
	

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmployeeVO(Integer id, String name, String ident, String email) {
		super();
		this.id = id;
		this.name = name;
		this.ident = ident;
		this.email = email;
	}
	public EmployeeVO() {
		super();
	}
	
	
}

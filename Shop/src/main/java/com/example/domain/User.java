package com.example.domain;

public class User {

	private String id;
	private String userId;
	private String passwd;
	private String name;
	private String address;
	private String tel;
	private String email;
	private String authority;
	
	public User() {
	}

	public User(String id, String userId, String passwd, String name, String address, String tel, String email,
			String authority) {
		super();
		this.id = id;
		this.userId = userId;
		this.passwd = passwd;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.authority = authority;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", passwd=" + passwd + ", name=" + name + ", address="
				+ address + ", tel=" + tel + ", email=" + email + ", authority=" + authority + "]";
	}
	
}

package com.scit.oracleTest.VO;

public class User {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private String birthdate;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}


	public User(String id, String pw, String name, String phone, String email, String birthdate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birthdate = birthdate;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", birthdate=" + birthdate
				+ "]";
	}

	
}
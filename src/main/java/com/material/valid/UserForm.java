package com.material.valid;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class UserForm {
	
	@NotBlank(message="user.account.empty")
	private String account;
	
	@NotBlank(message="user.username.empty")
	private String username;
	
	@Size(min=9, max=9, message="user.studentid.empty")
	private String studentid;
	
	@NotBlank(message="user.password.empty")
	private String password;
	
	@Size(min=10, max=12, message="user.phone.empty")
	private String phone;
	
	@NotBlank(message="user.email.empty")
	@Email(message = "user.emailA.empty") 
	private String email;
	
	@NotBlank(message="user.classes.empty")
	private String classes;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}
	
	
}

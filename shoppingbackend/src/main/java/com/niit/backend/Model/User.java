package com.niit.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;
	@NotNull(message="name cannot left blank")
	private String username;
	@NotNull(message="emailid cannot left blank")
	private String email;
	@NotNull(message="phone cannot left blank")
	private String phno;
	@NotNull(message="password cannot left blank")
	private String password;
	@Transient
	@NotNull(message="confirm password cannot left blank")
	private String cpassword;
	@NotNull(message="enabled cannot left blank")
	private String enabled;
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	

}

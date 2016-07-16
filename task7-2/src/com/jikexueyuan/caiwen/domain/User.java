package com.jikexueyuan.caiwen.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "USERS")
public class User extends BaseDomain implements Serializable {
	private Integer id;
	private String username;
	private String password;
	private String realName;
	private Integer age;
	private String phoneNum;
	private String address;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	@Column(name="USER_NAME")
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	@Column(name="REAL_NAME")
	public String getRealName() {
		return realName;
	}
	public Integer getAge() {
		return age;
	}
	@Column(name="PHONE_NUM")
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getAddress() {
		return address;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}

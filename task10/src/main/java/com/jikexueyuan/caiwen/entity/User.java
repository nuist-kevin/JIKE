package com.jikexueyuan.caiwen.entity;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;

  @Enumerated(EnumType.STRING)
  private Auth auth;

  private String username;
  private String realName;
  private String password;
  private String pwdQuestion;
  private String pwdQuestionAnswer;
  private String address;
  private String phoneNo;
  private String email;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer id) {
    this.userId = id;
  }

  public Auth getAuth() {
    return auth;
  }

  public void setAuth(Auth auth) {
    this.auth = auth;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPwdQuestion() {
    return pwdQuestion;
  }

  public void setPwdQuestion(String pwdQuestion) {
    this.pwdQuestion = pwdQuestion;
  }

  public String getPwdQuestionAnswer() {
    return pwdQuestionAnswer;
  }

  public void setPwdQuestionAnswer(String pwdQuestionAnswer) {
    this.pwdQuestionAnswer = pwdQuestionAnswer;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


}

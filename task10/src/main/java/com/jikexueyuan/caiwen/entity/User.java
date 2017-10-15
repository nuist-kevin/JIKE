package com.jikexueyuan.caiwen.entity;

import java.io.Serializable;
import javax.persistence.*;
/**
 * @author caiwen
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ROLE_ID")
  private Role role;

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

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
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

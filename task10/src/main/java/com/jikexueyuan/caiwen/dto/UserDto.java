package com.jikexueyuan.caiwen.dto;

import com.jikexueyuan.caiwen.entity.Auth;
import com.jikexueyuan.caiwen.entity.User;

import java.io.Serializable;

public class UserDto implements Serializable{
    private static final long serialVersionUID = 165703863807L;
    private Integer id;
    private Auth auth;
    private String userName;
    private String realName;
    private String password;
    private String pwdQuestion;
    private String pwdQuestionAnswer;
    private String address;
    private String phoneNo;
    private String email;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public User toUser(User user) {
        user.setUserName(this.userName);
        user.setRealName(this.realName);
        user.setPassword(this.password);
        user.setPhoneNo(this.phoneNo);
        user.setEmail(this.email);
        user.setAddress(this.address);
        user.setPwdQuestion(this.pwdQuestion);
        user.setPwdQuestionAnswer(this.pwdQuestionAnswer);
        return user;
    }
}

package com.jikexueyuan.caiwen.entity;

import javax.persistence.*;

@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer categoryId;
  private String categoryName;

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer id) {
    this.categoryId = id;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

}

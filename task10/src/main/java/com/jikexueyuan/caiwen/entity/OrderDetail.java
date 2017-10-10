package com.jikexueyuan.caiwen.entity;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
public class OrderDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer orderDetailId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORDER_ID")
  private Order order;

  private String goodsName;
  private String categoryName;
  private String imgUrl;
  private BigDecimal price;
  private Integer num;
  private String description;

  public Integer getOrderDetailId() {
    return orderDetailId;
  }

  public void setOrderDetailId(Integer orderDetailId) {
    this.orderDetailId = orderDetailId;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Integer getNum() {
    return num;
  }

  public void setNum(Integer num) {
    this.num = num;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}

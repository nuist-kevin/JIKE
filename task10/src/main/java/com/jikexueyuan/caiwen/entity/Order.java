package com.jikexueyuan.caiwen.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer orderId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
  private User user;
  @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  private List<OrderDetail> orderDetails;

  private Integer totalAmount;
  private BigDecimal sums;
  private LocalDateTime createTime;

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Integer getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Integer totalAmount) {
    this.totalAmount = totalAmount;
  }

  public BigDecimal getSums() {
    return sums;
  }

  public void setSums(BigDecimal sums) {
    this.sums = sums;
  }

  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }

  public List<OrderDetail> getOrderDetails() {
    return orderDetails;
  }

  public void setOrderDetails(List<OrderDetail> orderDetails) {
    this.orderDetails = orderDetails;
  }

}

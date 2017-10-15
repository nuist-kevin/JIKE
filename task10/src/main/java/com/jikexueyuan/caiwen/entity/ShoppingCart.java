package com.jikexueyuan.caiwen.entity;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Formula;

/**
 * @author caiwen
 */

@Entity
public class ShoppingCart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer shoppingCartId;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_ID", updatable = false)
  private User user;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "shoppingCart", cascade = CascadeType.REMOVE)
  private List<ShoppingCartDetail> shoppingCartDetail;

  private Integer totalAmount;
  private BigDecimal subtotal;

  public Integer getShoppingCartId() {
    return shoppingCartId;
  }

  public void setShoppingCartId(Integer shoppingCartId) {
    this.shoppingCartId = shoppingCartId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<ShoppingCartDetail> getShoppingCartDetail() {
    return shoppingCartDetail;
  }

  public void setShoppingCartDetail(List<ShoppingCartDetail> shoppingCartDetail) {
    this.shoppingCartDetail = shoppingCartDetail;
  }

  public Integer getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Integer totalAmount) {
    this.totalAmount = totalAmount;
  }

  public BigDecimal getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(BigDecimal subtotal) {
    this.subtotal = subtotal;
  }

}

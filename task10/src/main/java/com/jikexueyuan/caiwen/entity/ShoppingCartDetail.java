package com.jikexueyuan.caiwen.entity;

import javax.persistence.*;

@Entity
public class ShoppingCartDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer shoppingCartDetailId;

  @ManyToOne
  @JoinColumn(name = "SHOPPING_CART_ID")
  private ShoppingCart shoppingCart;

  @ManyToOne
  @JoinColumn(name = "GOODS_ID")
  private Goods goods;
  private Integer num;

  public Integer getShoppingCartDetailId() {
    return shoppingCartDetailId;
  }

  public void setShoppingCartDetailId(Integer shoppingCartDetailId) {
    this.shoppingCartDetailId = shoppingCartDetailId;
  }

  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
  }


  public Goods getGoods() {
    return goods;
  }

  public void setGoods(Goods goods) {
    this.goods = goods;
  }

  public Integer getNum() {
    return num;
  }

  public void setNum(Integer num) {
    this.num = num;
  }

}

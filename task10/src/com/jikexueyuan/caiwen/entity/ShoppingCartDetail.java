package com.jikexueyuan.caiwen.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by caiwen on 2016/8/12.
 */
@Entity
@Table(name = "SHOPPING_CART_DETAIL")
public class ShoppingCartDetail implements Serializable{

    private static final long serialVersionUID = 34534299234l;
    private Integer id;
    private ShoppingCart shoppingCart;
    private Goods goods;
    private Integer num;

    @Id
    @Column(name = "SHOPPINGCART_DETAIL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "SHOPPINGCART_ID")
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GOODS_ID")
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

    @Override
    public String toString() {
        return "ShoppingCartDetail{" +
                "id=" + id +
                ", goods=" + goods +
                ", num=" + num +
                ", shoppingCart=" + shoppingCart.getId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCartDetail that = (ShoppingCartDetail) o;

        if (!id.equals(that.id)) return false;
        if (!goods.equals(that.goods)) return false;
        return num.equals(that.num);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + goods.hashCode();
        result = 31 * result + num.hashCode();
        return result;
    }
}

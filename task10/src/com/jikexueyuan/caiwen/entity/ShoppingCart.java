package com.jikexueyuan.caiwen.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "SHOPPING_CART")
public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 33432251908L;
	private Integer id;
	private User user;
	private List<ShoppingCartDetail> shoppingCartDetail;
	private Integer goodsNum;
	private BigDecimal subtotal;
	
	@Id
	@Column(name = "SHOPPINGCART_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", updatable = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shoppingCart", cascade = CascadeType.REMOVE)
	public List<ShoppingCartDetail> getShoppingCartDetail() {
		return shoppingCartDetail;
	}

	public void setShoppingCartDetail(List<ShoppingCartDetail> shoppingCartDetail) {
		this.shoppingCartDetail = shoppingCartDetail;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

}

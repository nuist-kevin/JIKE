package com.jikexueyuan.caiwen.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

@Entity
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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "shoppingCart", cascade = CascadeType.REMOVE)
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

//	@Override
//	public String toString() {
//		return "ShoppingCart{" +
//				"id=" + id +
//				", user=" + user +
//				", shoppingCartDetail=" + shoppingCartDetail +
//				", goodsNum=" + goodsNum +
//				", subtotal=" + subtotal +
//				'}';
//	}
//
//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//
//		ShoppingCart that = (ShoppingCart) o;
//
//		if (!id.equals(that.id)) return false;
//		if (!user.equals(that.user)) return false;
//		if (shoppingCartDetail != null ? !shoppingCartDetail.equals(that.shoppingCartDetail) : that.shoppingCartDetail != null)
//			return false;
//		if (!goodsNum.equals(that.goodsNum)) return false;
//		return subtotal.equals(that.subtotal);
//
//	}
//
//	@Override
//	public int hashCode() {
//		int result = id.hashCode();
//		result = 31 * result + user.hashCode();
//		result = 31 * result + (shoppingCartDetail != null ? shoppingCartDetail.hashCode() : 0);
//		result = 31 * result + goodsNum.hashCode();
//		result = 31 * result + subtotal.hashCode();
//		return result;
//	}
}

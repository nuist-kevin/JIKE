package com.jikexueyuan.caiwen.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name="ORDERS_DETAILS")
public class OrderDetail implements Serializable{

	private static final long serialVersionUID = 6015749977406248432L;
	private Integer id;
	private Order order;
	private String goodsName;
	private BigDecimal price;
	private Integer num;

	@Id
	@Column(name = "ORDER_DETAIL_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

	@Column(name = "GOODS_NAME")
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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
}

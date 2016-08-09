package com.jikexueyuan.caiwen.entity;

import javax.persistence.Table;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="GOODS")
public class Goods {
	private Integer id;
	private String goodsname;
	private String description;
	private BigDecimal price;
	private Category category;
	private String imgUrl;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@ManyToOne
	@JoinColumn(name="CATEGORYID")
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Goods goods = (Goods) o;
		if (!id.equals(goods.id)) return false;
		if (!goodsname.equals(goods.goodsname)) return false;
		if (description != null ? !description.equals(goods.description) : goods.description != null) return false;
		if (!price.equals(goods.price)) return false;
		if (!category.equals(goods.category)) return false;
		return imgUrl != null ? imgUrl.equals(goods.imgUrl) : goods.imgUrl == null;

	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + goodsname.hashCode();
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + price.hashCode();
		result = 31 * result + category.hashCode();
		result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Goods{" +
				"id=" + id +
				", goodsname='" + goodsname + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", category=" + category +
				", imgUrl='" + imgUrl + '\'' +
				'}';
	}
}

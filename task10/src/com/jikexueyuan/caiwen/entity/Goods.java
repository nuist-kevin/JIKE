package com.jikexueyuan.caiwen.entity;

import com.jikexueyuan.caiwen.dto.GoodsDto;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="GOODS")
public class Goods implements Serializable{

	private static final long serialVersionUID = 12342664472251908L;
	private Integer id;
	private String goodsName;
	private String description;
	private BigDecimal price;
	private Category category;
	private String imgUrl;
	
	@Id
	@Column(name = "GOODS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "GOODS_NAME")
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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

	@OneToOne
	@JoinColumn(name="CATEGORY_ID")
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

	public GoodsDto toDto() {
		GoodsDto goodsDto = new GoodsDto();
		BeanUtils.copyProperties(this, goodsDto, "category");
		goodsDto.setCategoryId(this.getCategory().getId());
		goodsDto.setCategoryName(this.getCategory().getCategoryName());
		return goodsDto;
	}
}

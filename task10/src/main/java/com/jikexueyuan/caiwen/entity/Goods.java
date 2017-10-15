package com.jikexueyuan.caiwen.entity;

import static javax.persistence.CascadeType.PERSIST;

import com.jikexueyuan.caiwen.dto.GoodsDto;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author caiwen
 */

@Entity
public class Goods {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer goodsId;

  @ManyToOne(cascade = PERSIST, fetch = FetchType.LAZY) // 如果 category 不存在，先持久化 category
  @JoinColumn(name = "CATEGORY_ID")
  private Category category;
  private String goodsName;
  private String description;
  private BigDecimal price;
  private String imgUrl;

  public Integer getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Integer id) {
    this.goodsId = id;
  }

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
    goodsDto.setCategoryId(this.getCategory().getCategoryId());
    goodsDto.setCategoryName(this.getCategory().getCategoryName());
    return goodsDto;
  }
}

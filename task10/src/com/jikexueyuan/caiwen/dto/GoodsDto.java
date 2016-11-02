package com.jikexueyuan.caiwen.dto;

import com.jikexueyuan.caiwen.entity.Category;
import com.jikexueyuan.caiwen.entity.Goods;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

/**
 * Created by caiwen on 2016/8/20.
 */
public class GoodsDto {

    private Integer id;
    private String goodsName;
    private String description;
    private BigDecimal price;
    private Integer categoryId;
    private String categoryName;
    private String imgUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void toGoods(Goods goods) {
        BeanUtils.copyProperties(this, goods, "category");
        Category category = new Category();
        category.setId(this.categoryId);
        goods.setCategory(category);
    }
}

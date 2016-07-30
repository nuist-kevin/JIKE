package com.jikexueyuan.caiwen.command;

import java.math.BigDecimal;
/**
 * Consume所需的组件属性
 */
public class CommodityCommand {
    private Integer commodityId;
    private String commodityName;
    private BigDecimal price;

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}

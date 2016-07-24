package com.jikexueyuan.caiwen.action;

import com.jikexueyuan.caiwen.domain.Commodity;
import com.jikexueyuan.caiwen.service.impl.jpa.CommodityService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by caiwen on 2016/7/24.
 * 商品Action类，用于商品添加和查询
 */
public class CommodityAction extends ActionSupport {

    private CommodityService commodityService;
    private Commodity commodity;
    private Integer id;
    private List<Commodity> commodities;

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(List<Commodity> commodities) {
        this.commodities = commodities;
    }

    public CommodityService getCommodityService() {
        return commodityService;
    }

    @Autowired
    public void setCommodityService(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String addView() throws Exception {
        return SUCCESS;
    }

    public String doAdd() throws Exception {
        commodityService.add(commodity);
        return SUCCESS;
    }

    public String list() throws Exception {
        commodities = commodityService.findAll();
        return SUCCESS;
    }
}

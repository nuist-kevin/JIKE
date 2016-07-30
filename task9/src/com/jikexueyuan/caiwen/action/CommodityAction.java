package com.jikexueyuan.caiwen.action;

import com.jikexueyuan.caiwen.domain.Commodity;
import com.jikexueyuan.caiwen.service.CommodityService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by caiwen on 2016/7/24.
 * 商品Action类，用于商品添加和查询
 */
public class CommodityAction extends ActionSupport {


    private CommodityService commodityService;
    private Commodity commodity;
    //列表查看请求的页码
    private Integer page;
    //列表查看页所需的总页数
    private Long totalPages;
    //用于响应json格式列表请求
    private Map<String, Object> pageData = new HashMap<>();

    /*查询方法所需的几个参数*/
    private Integer id;
    private String name;
    private BigDecimal upAgio;
    private BigDecimal lowAgio;
    private BigDecimal lowPrice;
    private BigDecimal upPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUpAgio() {
        return upAgio;
    }

    public void setUpAgio(BigDecimal upAgio) {
        this.upAgio = upAgio;
    }

    public BigDecimal getLowAgio() {
        return lowAgio;
    }

    public void setLowAgio(BigDecimal lowAgio) {
        this.lowAgio = lowAgio;
    }

    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    public BigDecimal getUpPrice() {
        return upPrice;
    }

    public void setUpPrice(BigDecimal upPrice) {
        this.upPrice = upPrice;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Map<String, Object> getPageData() {
        return pageData;
    }

    public void setPageData(Map<String, Object> pageData) {
        this.pageData = pageData;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
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

    /**
     * 添加页面处理方法
     * @return 返回添加页面
     * @throws Exception
     */
    public String addView() throws Exception {
        return SUCCESS;
    }

    /**
     * 添加商品请求处理方法
     * @return 添加成功返回商品列表
     * @throws Exception
     */
    public String doAdd() throws Exception {
        commodityService.add(commodity);
        return SUCCESS;
    }

    /**
     * 列表页处理方法
     * @return 返回列表页面
     * @throws Exception
     */
    public String list() throws Exception {
        return SUCCESS;
    }

    /**
     * 列表数据异步动态查询方法，借助struts-json插件，result的type为json
     * @return json格式的查询结果，json格式为{dataList:[……], totalPages: x}
     * @throws Exception
     */
    public String jsonList() throws Exception {
        Page<Commodity> commodityPage;
        commodityPage = commodityService.query(id, name, lowPrice, upPrice, lowAgio, upAgio, page);
        pageData.put("dataList",commodityPage.getContent());
        pageData.put("totalPages",commodityPage.getTotalPages());
        return SUCCESS;
    }
}

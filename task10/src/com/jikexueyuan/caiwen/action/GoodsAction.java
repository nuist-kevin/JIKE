package com.jikexueyuan.caiwen.action;

import com.jikexueyuan.caiwen.dto.GoodsDto;
import com.jikexueyuan.caiwen.entity.Category;
import com.jikexueyuan.caiwen.entity.Goods;
import com.jikexueyuan.caiwen.service.CategoryService;
import com.jikexueyuan.caiwen.service.GoodsService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsAction extends ActionSupport {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CategoryService categoryService;
    private GoodsDto goodsDto = new GoodsDto();
    private Map<String, String> conditions;
    private Integer page;
    private List<Goods> goodsList;

    //用于响应json格式列表请求
    private Map<String, Object> pageData = new HashMap<>();

    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public GoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    public GoodsDto getGoodsDto() {
        return goodsDto;
    }

    public void setGoodsDto(GoodsDto goodsDto) {
        this.goodsDto = goodsDto;
    }

    public Map<String, String> getConditions() {
        return conditions;
    }

    public void setConditions(Map<String, String> conditions) {
        this.conditions = conditions;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public Map<String, Object> getPageData() {
        return pageData;
    }

    public void setPageData(Map<String, Object> pageData) {
        this.pageData = pageData;
    }

    public String list() throws Exception {
        goodsList = goodsService.getGoodsByConditionMap(conditions, 1);
        return SUCCESS;
    }

    public String jsonList() throws Exception {
        goodsList = goodsService.getGoodsByConditionMap(conditions, 1);
        pageData.put("goodsList", goodsList);
        pageData.put("totalPages", 2);
        return SUCCESS;
    }

    public String add() throws Exception {
        categoryList = categoryService.getAllCategories();
        return SUCCESS;
    }

    public String doAdd() throws Exception {
        Goods goods = new Goods();
        goodsDto.toGoods(goods);
        goodsService.add(goods);
        return SUCCESS;
    }

    public String view() throws Exception {
        Goods goods = goodsService.getGoodsById(goodsDto.getId());
        goodsDto = goods.toDto();
        return SUCCESS;
    }
}

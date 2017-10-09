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
    private GoodsDto goodsDto;
    private Map<String, String> conditions;
    private Integer page;
    private Integer recordPerPage;

    public Integer getRecordPerPage() {
        return recordPerPage;
    }

    public void setRecordPerPage(Integer recordPerPage) {
        this.recordPerPage = recordPerPage;
    }

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

    public Map<String, Object> getPageData() {
        return pageData;
    }

    public void setPageData(Map<String, Object> pageData) {
        this.pageData = pageData;
    }

    public String list() throws Exception {
        return SUCCESS;
    }

    public String jsonList() throws Exception {
        pageData = goodsService.getGoodsByConditionMap(conditions, page, recordPerPage);
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
        Goods goods = goodsService.getGoodsById(goodsDto.getGoodsId());
        goodsDto = goods.toDto();
        return SUCCESS;
    }

    public String edit() throws Exception {
        categoryList = categoryService.getAllCategories();
        Goods goods = goodsService.getGoodsById(goodsDto.getGoodsId());
        goodsDto = goods.toDto();
        return SUCCESS;
    }

    public String doEdit() throws Exception {
        Goods goods = new Goods();
        goodsDto.toGoods(goods);
        goodsService.update(goods);
        return SUCCESS;
    }

    public String delete() throws Exception {
        goodsService.delete(goodsDto.getGoodsId());
        return SUCCESS;
    }
}

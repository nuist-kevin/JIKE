package com.jikexueyuan.caiwen.action;

import com.jikexueyuan.caiwen.dto.GoodsDto;
import com.jikexueyuan.caiwen.entity.Category;
import com.jikexueyuan.caiwen.service.CategoryService;
import com.jikexueyuan.caiwen.service.GoodsService;
import com.jikexueyuan.caiwen.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingAction extends ActionSupport {

    private Map<String, String> conditions;
    private GoodsDto goodsDto;
    private Integer page;
    private Integer recordPerPage;
    private Map<String, Object> pageData = new HashMap<>();

    public GoodsDto getGoodsDto() {
        return goodsDto;
    }

    public void setGoodsDto(GoodsDto goodsDto) {
        this.goodsDto = goodsDto;
    }

    public Map<String, Object> getPageData() {
        return pageData;
    }

    public void setPageData(Map<String, Object> pageData) {
        this.pageData = pageData;
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

    public Integer getRecordPerPage() {
        return recordPerPage;
    }

    public void setRecordPerPage(Integer recordPerPage) {
        this.recordPerPage = recordPerPage;
    }

    @Autowired
    GoodsService goodsService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public String view() throws Exception {
        categoryList = categoryService.getAllCategories();
        return SUCCESS;
    }

    public String jsonResult() throws Exception {
        if (recordPerPage == null) {
            recordPerPage = 20;
        }
        pageData = goodsService.getGoodsByConditionMap(conditions, page, recordPerPage);
        return SUCCESS;
    }

    public String edit() throws Exception {
        goodsDto = goodsService.getGoodsById(goodsDto.getId()).toDto();
        return SUCCESS;
    }
}

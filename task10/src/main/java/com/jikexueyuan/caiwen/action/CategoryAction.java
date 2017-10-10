package com.jikexueyuan.caiwen.action;

import com.jikexueyuan.caiwen.entity.Category;
import com.jikexueyuan.caiwen.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import org.springframework.data.domain.Page;

public class CategoryAction extends ActionSupport {

  @Autowired
  private CategoryService categoryService;
  private Category category;
  private Integer page;
  private Map<String, Object> jsonResult = new HashMap<>();

  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public CategoryService getCategoryService() {
    return categoryService;
  }

  public void setCategoryService(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Map<String, Object> getJsonResult() {
    return jsonResult;
  }

  public void setJsonResult(Map<String, Object> jsonResult) {
    this.jsonResult = jsonResult;
  }

  public String list() {
    return SUCCESS;
  }

  public String add() {
    categoryService.add(category.getCategoryName());
    jsonResult.put("result", "1");
    return SUCCESS;
  }

  public String delete() {
    categoryService.delete(category.getCategoryId());
    jsonResult.put("result", "1");
    return SUCCESS;
  }

  public String edit() {
    categoryService.update(category);
    jsonResult.put("result", "1");
    return SUCCESS;
  }

  public String getAll() {
    Page<Category> queryResult = categoryService.pagedQuery(page, 5);
    jsonResult.put("categories", queryResult.getContent());
    jsonResult.put("totalPages", queryResult.getTotalPages());
    return SUCCESS;
  }

}

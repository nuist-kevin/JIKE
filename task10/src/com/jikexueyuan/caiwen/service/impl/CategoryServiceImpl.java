package com.jikexueyuan.caiwen.service.impl;

import com.jikexueyuan.caiwen.dao.CategoryDao;
import com.jikexueyuan.caiwen.entity.Category;
import com.jikexueyuan.caiwen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public Category add(String categoryName) {
        Category result = new Category();
        result.setCategoryName(categoryName);
        Integer id = categoryDao.save(result);
        result.setId(id);
        return result;
    }

    @Override
    public void delete(Integer id) {
        categoryDao.delete(id);
    }

    @Override
    public void update(Category category) {
        categoryDao.saveOrUpdate(category);
    }


    @Override
    public List<Category> getAllCategories() {
        return categoryDao.findAll();
    }

    @Override
    public Integer getTotalPages() {
        return categoryDao.totalPages(10);
    }

    @Override
    public Map pagedQuery(Integer page, Integer recordPerPage) {
        return categoryDao.pagedQuery(page,recordPerPage);
    }


}

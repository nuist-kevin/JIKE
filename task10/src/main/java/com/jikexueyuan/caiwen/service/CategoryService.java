package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.entity.Category;

import java.util.List;
import org.springframework.data.domain.Page;

/**
 * @author caiwen
 */
public interface CategoryService {

  /**
   * 添加一个产品目录
   *
   * @param categoryName 产品目录名称
   * @return 返回添加好的产品目录
   */
  Category add(String categoryName);

  /**
   * 根据目录ID删除一个目录，如果目录下还有产品，则不可删除
   *
   * @param id 目录ID
   */
  void delete(Integer id);

  /**
   * 更新目录信息
   *
   * @param category 待更新的目录
   */
  void update(Category category);

  /**
   * 获取所有有效的目录
   *
   * @return 目录列表
   */
  List<Category> getAllCategories();

  /**
   * 分页查询所有目录
   *
   * @param page 页码
   * @param recordPerPage 每页目录数量
   * @return 返回分页信息，包括每页数量和实际的内容
   */
  Page<Category> pagedQuery(Integer page, Integer recordPerPage);
}

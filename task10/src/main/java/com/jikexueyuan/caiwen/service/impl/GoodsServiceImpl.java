package com.jikexueyuan.caiwen.service.impl;

import com.jikexueyuan.caiwen.dao.GoodsDao;
import com.jikexueyuan.caiwen.dto.GoodsDto;
import com.jikexueyuan.caiwen.entity.Category;
import com.jikexueyuan.caiwen.entity.Goods;
import com.jikexueyuan.caiwen.repository.GoodsRepository;
import com.jikexueyuan.caiwen.service.GoodsService;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

  @Autowired
  private GoodsDao goodsDao;

  @Autowired
  private GoodsRepository goodsRepository;

  @Override
  @Transactional
  public Goods add(Goods goods) {
    return goodsRepository.save(goods);
  }

  @Override
  @Transactional
  public void update(Goods goods) {
    goodsRepository.save(goods);
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    goodsRepository.delete(id);
  }

  @Override
  public Goods getGoodsById(Integer id) {
    return goodsRepository.findOne(id);
  }

  @Override
  public Integer getTotalPages() {
    return goodsDao.totalPages(5);
  }

  @Override
  public List<Goods> getAll() {
    return goodsRepository.findAll();
  }

  @Override
  public Map<String, Object> getGoodsByConditionMap(Map condition, Integer page,
      Integer recordPerPage) {
    return goodsDao.conditionQuery(condition, page, recordPerPage);
  }

  public Page<Goods> getPagedGoodsListByCondition(GoodsDto goodsDto, Integer page,
      Integer pageSize) {
    Pageable pageable = new PageRequest(page, pageSize);

    return goodsRepository.findAll(
        (root, query, cb) -> {
          List<Predicate> predicates = new ArrayList<>();
          if (goodsDto.getGoodsName() != null) {
            predicates.add(
                cb.like(root.get("goodsName").as(String.class),
                    "%" + goodsDto.getGoodsName() + "%"));
          }
          if (goodsDto.getCategoryName() != null) {
            Join<Goods, Category> goodsCategoryJoin = root.join("category");
            predicates.add(
                cb.like(goodsCategoryJoin.get("categoryName").as(String.class),
                    "%" + goodsDto.getCategoryName() + "%"));
          }
          if (goodsDto.getDescription() != null) {
            predicates.add(
                cb.like(root.get("description").as(String.class),
                    "%" + goodsDto.getDescription() + "%"));
          }
          if (goodsDto.getPriceFrom() != null) {
            predicates.add(
                cb.ge(root.get("price").as(BigDecimal.class), goodsDto.getPriceFrom()));
          }
          if (goodsDto.getPriceTo() != null) {
            predicates.add(
                cb.le(root.get("price").as(BigDecimal.class), goodsDto.getPriceTo()));
          }
          return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        },
        pageable);

  }
}

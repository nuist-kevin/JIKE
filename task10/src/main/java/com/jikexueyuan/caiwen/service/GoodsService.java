package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.dto.GoodsDto;
import com.jikexueyuan.caiwen.entity.Goods;

import java.util.List;
import org.springframework.data.domain.Page;

/**
 * @author caiwen
 */
public interface GoodsService {

  Goods getGoodsById(Integer id);

  Goods add(Goods goods);

  void update(Goods goods);

  void delete(Integer id);

  List<Goods> getAll();

  Page<Goods> getPagedGoodsListByCondition(GoodsDto goodsDto, Integer page,
      Integer pageSize);

}

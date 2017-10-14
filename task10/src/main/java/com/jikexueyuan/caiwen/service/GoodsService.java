package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.dto.GoodsDto;
import com.jikexueyuan.caiwen.entity.Goods;

import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;

/**
 * Created by caiwen on 2016/8/20.
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

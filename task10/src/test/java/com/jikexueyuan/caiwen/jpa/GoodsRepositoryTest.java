package com.jikexueyuan.caiwen.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.jikexueyuan.caiwen.dto.GoodsDto;
import com.jikexueyuan.caiwen.entity.Category;
import com.jikexueyuan.caiwen.entity.Goods;
import com.jikexueyuan.caiwen.repository.GoodsRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class GoodsRepositoryTest extends BasicJpaTest {

  @Autowired
  private GoodsRepository goodsRepository;


  @Test
  public void test() {
    Category category = new Category();
    category.setCategoryName("Clothes");

    Goods goods = new Goods();
    goods.setCategory(category);
    goods.setGoodsName("连衣裙");
    goods.setDescription("女式连衣裙");
    goods.setPrice(BigDecimal.valueOf(499.99));
    goods.setImgUrl("http://image.caiwen.com/goods/jjger.jpg");

    goodsRepository.save(goods);
    Goods dbGoods = goodsRepository.findOne(goods.getGoodsId());
    assertThat(dbGoods).isNotNull();
    assertThat(dbGoods).isEqualToComparingFieldByField(goods);

  }

  @Test
  public void specificationTest() {
    GoodsDto goodsDto = new GoodsDto();
    goodsDto.setGoodsName("iPhone 8");
    goodsDto.setPriceFrom(BigDecimal.valueOf(5999.99));
    goodsDto.setPriceTo(BigDecimal.valueOf(7999.99));
    goodsDto.setCategoryName("phone");

    Goods goods1 = new Goods();
    BeanUtils.copyProperties(goodsDto, goods1);
    goods1.setPrice(BigDecimal.valueOf(6500));

    goodsRepository.save(goods1);

    List<Goods> goodsList = goodsRepository.findAll((root, query, cb) -> {
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
    });

    assertThat(goodsList).hasSize(1).contains(goods1);


  }
}

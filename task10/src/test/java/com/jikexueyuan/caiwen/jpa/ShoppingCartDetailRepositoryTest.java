package com.jikexueyuan.caiwen.jpa;

import static org.assertj.core.api.Java6Assertions.assertThat;

import com.jikexueyuan.caiwen.entity.Goods;
import com.jikexueyuan.caiwen.entity.ShoppingCart;
import com.jikexueyuan.caiwen.entity.ShoppingCartDetail;
import com.jikexueyuan.caiwen.repository.GoodsRepository;
import com.jikexueyuan.caiwen.repository.ShoppingCartDetailRepository;
import com.jikexueyuan.caiwen.repository.ShoppingCartRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

public class ShoppingCartDetailRepositoryTest extends BasicJpaTest {

  @Autowired
  private ShoppingCartDetailRepository shoppingCartDetailRepository;
  @Autowired
  private ShoppingCartRepository shoppingCartRepository;
  @Autowired
  private GoodsRepository goodsRepository;

  @Sql(statements = {
      "insert into role (role_id, role_name) values (1, 'ADMIN')",
      "insert into users (user_id, role_id, password, username) values(1, 1, '123456', 'caiwen')",
      "insert into shopping_cart(shopping_cart_id, user_id) values(1, 1)",
      "insert into category values (1, 'clothes')",
      "insert into goods (goods_id, goods_name, price, category_id) values (1, '连衣裙', 299, 1)"})
  @Test
  public void saveTest() {
    ShoppingCart shoppingCart = shoppingCartRepository.findOne(1);
    ShoppingCartDetail shoppingCartDetail = new ShoppingCartDetail();
    shoppingCartDetail.setShoppingCart(shoppingCart);
    shoppingCartDetail.setGoods(goodsRepository.findOne(1));
    shoppingCartDetail.setNum(2);
    shoppingCartDetailRepository.save(shoppingCartDetail);

    ShoppingCartDetail dbShoppingCartDetail = shoppingCartDetailRepository
        .findOne(shoppingCartDetail.getShoppingCartDetailId());
    assertThat(dbShoppingCartDetail).isNotNull();
    assertThat(dbShoppingCartDetail.getNum()).isEqualTo(2);
    assertThat(dbShoppingCartDetail.getGoods().getGoodsName()).isEqualToIgnoringCase("连衣裙");
  }


}

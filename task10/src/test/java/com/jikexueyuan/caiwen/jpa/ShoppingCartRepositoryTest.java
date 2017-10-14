package com.jikexueyuan.caiwen.jpa;

import static org.assertj.core.api.Java6Assertions.assertThat;

import com.jikexueyuan.caiwen.entity.ShoppingCart;
import com.jikexueyuan.caiwen.repository.ShoppingCartRepository;
import com.jikexueyuan.caiwen.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

public class ShoppingCartRepositoryTest extends BasicJpaTest {

  @Autowired
  private ShoppingCartRepository shoppingCartRepository;
  @Autowired
  private UserRepository userRepository;

  @Sql(statements = {
      "insert into role (role_id, role_name) values (1, 'ADMIN')",
      "insert into users (user_id, role_id, password, username) values(1, 1, '123456', 'caiwen')"})
  @Test
  public void saveTest() {
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.setUser(userRepository.findOne(1));
    shoppingCartRepository.save(shoppingCart);

    ShoppingCart dbShoppingCart = shoppingCartRepository.findOne(shoppingCart.getShoppingCartId());
    assertThat(dbShoppingCart).isNotNull();
    assertThat(dbShoppingCart.getUser().getUsername()).isEqualToIgnoringCase("caiwen");
  }


}

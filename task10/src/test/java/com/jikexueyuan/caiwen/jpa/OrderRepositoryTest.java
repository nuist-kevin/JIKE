package com.jikexueyuan.caiwen.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.jikexueyuan.caiwen.entity.Order;
import com.jikexueyuan.caiwen.entity.OrderDetail;
import com.jikexueyuan.caiwen.repository.OrderDetailRepository;
import com.jikexueyuan.caiwen.repository.OrderRepository;
import com.jikexueyuan.caiwen.repository.UserRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

public class OrderRepositoryTest extends BasicJpaTest {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private OrderDetailRepository orderDetailRepository;

  @Sql(statements = {
      "insert into users (user_id, role_id, password, username) values(1, 1, '123456', 'caiwen')"})
  @Test
  public void saveTest() {
    Order order = new Order();
    order.setCreateTime(LocalDateTime.now());
    order.setTotalAmount(5);
    order.setSums(BigDecimal.valueOf(1234.12));
    order.setUser(userRepository.findOne(1));

    OrderDetail orderDetail = new OrderDetail();
    orderDetail.setCategoryName("cloth");
    orderDetail.setGoodsName("连衣裙1");
    orderDetail.setNum(2);
    orderDetail.setPrice(BigDecimal.valueOf(155.21));
    orderDetail.setOrder(order);

    OrderDetail orderDetail2 = new OrderDetail();
    orderDetail2.setCategoryName("cloth");
    orderDetail2.setGoodsName("连衣裙2");
    orderDetail2.setNum(1);
    orderDetail2.setPrice(BigDecimal.valueOf(133.21));
    orderDetail2.setOrder(order);

    List<OrderDetail> orderDetailList = new ArrayList<>();
    orderDetailList.add(orderDetail);
    orderDetailList.add(orderDetail2);
    order.setOrderDetails(orderDetailList);

    orderRepository.save(order);
    assertThat(orderRepository.findOne(order.getOrderId()).getOrderDetails()).hasSize(2);
  }

  @Sql(statements = {
      "insert into orders (order_id, create_time, sums, total_amount, username)  values (1, sysdate(), 222.12, 15, 'caiwen')",
      "insert into order_detail (order_detail_id, category_name, description, goods_name, img_url, num, order_id, price) values (1, 'cloth', 'desc', '连衣裙1', 'http://www.baidu.com', 2, 1, 12.12 )",
      "insert into order_detail (order_detail_id, category_name, description, goods_name, img_url, num, order_id, price) values (2, 'cloth', 'desc2', '连衣裙2', 'http://www.sina.com', 3, 1, 13.13 )"
  })
  @Test
  public void deleteTest() {
    orderRepository.delete(1);
    assertThat(orderRepository.findOne(1)).isNull();
    assertThat(orderDetailRepository.findOne(1)).isNull();
  }
}

package com.jikexueyuan.caiwen.service.impl;

import com.jikexueyuan.caiwen.dao.UserDao;
import com.jikexueyuan.caiwen.entity.ShoppingCart;
import com.jikexueyuan.caiwen.entity.User;
import com.jikexueyuan.caiwen.service.ShoppingCartService;
import com.jikexueyuan.caiwen.service.UserService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.mockito.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests{

    @InjectMocks
    @Autowired
    UserService userService;

    @Mock
    UserDao userDao;

    @Mock
    ShoppingCartService shoppingCartService;

    @BeforeClass
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setUserName("cc");
        // 假设用户不存在
        when(userDao.findByUserName(user.getUserName())).thenReturn(null);
        // 假设入库返回的 id 是 1
        when(userDao.save(user)).thenReturn(1);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(2);
        // 假设生成的购物车就是这里的 shoppingCart，id 为 2
        when(shoppingCartService.generateShoppingCartForUser(user)).thenReturn(shoppingCart);
        // 用模拟的中间结果运行 addUser 方法
        User result = userService.addUser(user);
        // 检查结果
        assertThat(result.getUserId(), is(1));
        assertThat(result.getShoppingCart().getId(), is(2));
    }

    @Test
    public void testGetUserById() throws Exception {

    }

    @Test
    public void testGetUserByUserName() throws Exception {

    }

    @Test
    public void testValidateUser() throws Exception {

    }
}
package com.jikexueyuan.caiwen.dao.impl;

import javax.annotation.Resource;

import com.jikexueyuan.caiwen.dao.UserDao;
import com.jikexueyuan.caiwen.entity.*;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import com.jikexueyuan.caiwen.dao.ShoppingCartDao;
import org.testng.annotations.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;

public class ShoppingCartDaoTest extends BaseDaoTest {

    @Resource
    ShoppingCartDao shoppingCartDao;
    @Resource
    private UserDao userDao;

    @Sql("classpath:/sql/ShoppingCartDaoTest/testSave.sql")
    @Test(dependsOnMethods = "testFindOne")
//    @Rollback(false)
    public void testSave() {

        User user = new User();
        user.setUserName("caiwen");
        user.setPassword("123456");
        user.setRealName("蔡文");
        user.setPwdQuestion("老婆的名字");
        user.setPwdQuestion("宋晓娇");
        user.setEmail("nuist_kevin@163.com");
        user.setAddress("南京托乐嘉");
        user.setPhoneNo("18094200522");

        Integer userId = userDao.save(user);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(1);
        shoppingCart.setGoodsNum(5);
        shoppingCart.setSubtotal(BigDecimal.valueOf(15332.32));
        shoppingCart.setUser(user);
//        Integer shoppingCartId = shoppingCartDao.save(shoppingCart);

        Category flower = new Category();
        flower.setId(1);
        flower.setCategoryName("鲜花");
        Category cellphone = new Category();
        cellphone.setId(2);
        cellphone.setCategoryName("手机");

        Goods rose = new Goods();
        rose.setId(1);
        rose.setCategory(flower);
        rose.setGoodsName("玫瑰花");
        rose.setDescription("爱之花");
        rose.setPrice(BigDecimal.valueOf(199.99));
        rose.setImgUrl("img/flower/rose.jpg");

        Goods iphone = new Goods();
        iphone.setId(2);
        iphone.setCategory(cellphone);
        iphone.setGoodsName("iPhone 6s");
        iphone.setDescription("苹果最新一代手机");
        iphone.setPrice(BigDecimal.valueOf(5688));
        iphone.setImgUrl("img/cellphone/iphone6s.jpg");

        ShoppingCartDetail shoppingCartDetail1 = new ShoppingCartDetail();
        shoppingCartDetail1.setId(1);
        shoppingCartDetail1.setGoods(rose);
        shoppingCartDetail1.setNum(2);

        ShoppingCartDetail shoppingCartDetail2 = new ShoppingCartDetail();
        shoppingCartDetail2.setId(2);
        shoppingCartDetail2.setGoods(iphone);
        shoppingCartDetail2.setNum(3);

        List<ShoppingCartDetail> shoppingCartDetailList = new ArrayList<>();
        shoppingCart.setShoppingCartDetail(shoppingCartDetailList);
        shoppingCart.getShoppingCartDetail().add(shoppingCartDetail1);
        shoppingCart.getShoppingCartDetail().add(shoppingCartDetail2);
        Integer shoppingCartId = shoppingCartDao.save(shoppingCart);
        assertThat(shoppingCartDao.findOne(shoppingCartId).getShoppingCartDetail().toArray(), arrayContainingInAnyOrder
                (shoppingCartDetail1, shoppingCartDetail2));
    }

    @Sql("classpath:/sql/ShoppingCartDaoTest/testFindOne.sql")
    @Test
    public void testFindOne() {

        User user = new User();
        user.setId(1);
        user.setUserName("caiwen");
        user.setPassword("123456");
        user.setRealName("蔡文");
        user.setPwdQuestion("老婆的名字");
        user.setPwdQuestionAnswer("宋晓娇");
        user.setEmail("nuist_kevin@163.com");
        user.setAddress("南京托乐嘉");
        user.setPhoneNo("18094200522");

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(1);
        shoppingCart.setUser(user);

        Category flower = new Category();
        flower.setId(1);
        flower.setCategoryName("鲜花");
        Category cellphone = new Category();
        cellphone.setId(2);
        cellphone.setCategoryName("手机");

        Goods rose = new Goods();
        rose.setId(1);
        rose.setCategory(flower);
        rose.setGoodsName("玫瑰花");
        rose.setDescription("爱之花");
        rose.setPrice(BigDecimal.valueOf(199.99));
        rose.setImgUrl("img/flower/rose.jpg");

        Goods iphone = new Goods();
        iphone.setId(2);
        iphone.setCategory(cellphone);
        iphone.setGoodsName("iPhone 6s");
        iphone.setDescription("苹果最新一代手机");
        iphone.setPrice(BigDecimal.valueOf(5688.00).setScale(2));
        iphone.setImgUrl("img/cellphone/iphone6s.jpg");

        ShoppingCartDetail shoppingCartDetail1 = new ShoppingCartDetail();
        shoppingCartDetail1.setShoppingCart(shoppingCart);
        shoppingCartDetail1.setId(1);
        shoppingCartDetail1.setGoods(rose);
        shoppingCartDetail1.setNum(1);

        ShoppingCartDetail shoppingCartDetail2 = new ShoppingCartDetail();
        shoppingCartDetail2.setShoppingCart(shoppingCart);
        shoppingCartDetail2.setId(2);
        shoppingCartDetail2.setGoods(iphone);
        shoppingCartDetail2.setNum(1);

        List<ShoppingCartDetail> shoppingCartDetailList = new ArrayList<>();
        shoppingCart.setShoppingCartDetail(shoppingCartDetailList);
        shoppingCart.getShoppingCartDetail().add(shoppingCartDetail1);
        shoppingCart.getShoppingCartDetail().add(shoppingCartDetail2);
        shoppingCart.setGoodsNum(2);
        shoppingCart.setSubtotal(BigDecimal.valueOf(15333.32));
        ShoppingCart actual = shoppingCartDao.findOne(1);

        assertThat(actual.getGoodsNum(), is(2));
        assertThat(actual.getSubtotal(), is(BigDecimal.valueOf(15333.32)));
        assertThat(actual.getShoppingCartDetail().toArray(), arrayContainingInAnyOrder
                (shoppingCartDetail1, shoppingCartDetail2));
    }

}

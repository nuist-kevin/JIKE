package com.jikexueyuan.caiwen.dao.impl;

import com.jikexueyuan.caiwen.dao.GoodsDao;
import com.jikexueyuan.caiwen.entity.Category;
import com.jikexueyuan.caiwen.entity.Goods;
import static org.hamcrest.MatcherAssert.assertThat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;


/**
 * Created by caiwen on 2016/8/6.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional(transactionManager = "transactionManager")
public class GoodsDaoTest extends BaseDaoTest {
    @Resource
    GoodsDao goodsDao;

    @Test
    @Sql("classpath:/sql/GoodsDaoTest/testfindOne.sql")
    public void testfindOne() {
        Goods goods = goodsDao.findOne(5);
        Assert.assertTrue(goods.getId() == 5);
        Assert.assertEquals(goods.getGoodsname(), "茉莉花");
        Assert.assertTrue(goods.getCategory().getId() == 1);
        Assert.assertEquals(goods.getDescription(), "花的一种");
        Assert.assertEquals(goods.getPrice(), BigDecimal.valueOf(15.32));
        Assert.assertEquals(goods.getImgUrl(), "img/flowers/pasm.jpg");
    }

    @Test
    @Sql("classpath:/sql/GoodsDaoTest/testSave.sql")
    public void testSave() {
        Category category = new Category();
        category.setId(1);
        Goods goods = new Goods();
        goods.setCategory(category);
        goods.setGoodsname("茉莉花");
        goods.setDescription("花的一种");
        goods.setPrice(BigDecimal.valueOf(15.32));
        goods.setImgUrl("img/flowers/pasm.jpg");
        Integer goodsId = goodsDao.save(goods);
        Assert.assertEquals(goods, goodsDao.findOne(goodsId));
    }

    @Test
    @Sql("classpath:/sql/GoodsDaoTest/testTotalCount.sql")
    public void testTotalCount() {
        Assert.assertEquals(goodsDao.totalCount(), Long.valueOf(5l));
    }


    @Test
    @Sql("classpath:/sql/GoodsDaoTest/testFindAll.sql")
    public void testFindAll() {
        Category category1 = new Category();
        category1.setId(1);
        category1.setCategoryName("普通花");
        Goods goods1 = new Goods();
        goods1.setId(1);
        goods1.setCategory(category1);
        goods1.setGoodsname("茉莉花1");
        goods1.setDescription("花的一种1");
        goods1.setPrice(BigDecimal.valueOf(15.31));
        goods1.setImgUrl("img/flowers/pasm1.jpg");

        Category category2 = new Category();
        category2.setId(2);
        category2.setCategoryName("普通花2");
        Goods goods2 = new Goods();
        goods2.setId(2);
        goods2.setCategory(category2);
        goods2.setGoodsname("茉莉花2");
        goods2.setDescription("花的一种2");
        goods2.setPrice(BigDecimal.valueOf(15.32));
        goods2.setImgUrl("img/flowers/pasm2.jpg");

        List<Goods> goodsList = goodsDao.findAll();
        assertThat(goodsList.toArray() ,arrayContainingInAnyOrder(is(goods1), is(goods2)));
    }

    @Test
    @Sql  //TODO
    public void testFindByPage() {
//        List<Goods> goodsList = goodsDao.findByPage()
    }
}

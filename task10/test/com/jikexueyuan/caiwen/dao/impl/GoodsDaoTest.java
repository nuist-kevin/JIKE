package com.jikexueyuan.caiwen.dao.impl;

import com.jikexueyuan.caiwen.dao.GoodsDao;
import com.jikexueyuan.caiwen.entity.Category;
import com.jikexueyuan.caiwen.entity.Goods;
import static org.hamcrest.MatcherAssert.assertThat;
import org.springframework.test.context.jdbc.Sql;
import org.testng.Assert;
import org.testng.annotations.Test;
import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;


/**
 * Created by caiwen on 2016/8/6.
 */

public class GoodsDaoTest extends BaseDaoTest {
    @Resource
    GoodsDao goodsDao;

    @Test
    @Sql("classpath:/sql/GoodsDaoTest/testfindOne.sql")
    public void testfindOne() {
        Goods goods = goodsDao.findOne(5);
        Assert.assertTrue(goods.getId() == 5);
        Assert.assertEquals(goods.getGoodsName(), "茉莉花");
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
        goods.setGoodsName("茉莉花");
        goods.setDescription("花的一种");
        goods.setPrice(BigDecimal.valueOf(15.32));
        goods.setImgUrl("img/flowers/pasm.jpg");
        Integer goodsId = goodsDao.save(goods);
        Assert.assertEquals(goods, goodsDao.findOne(goodsId));
    }

    @Test
    @Sql("classpath:/sql/GoodsDaoTest/testTotalCount.sql")
    public void testTotalCount() {
        assertThat(goodsDao.totalCount(), is(5));
    }

    @Test(dependsOnMethods = "testTotalCount")
    @Sql("classpath:/sql/GoodsDaoTest/testDelete.sql")
    public void testDelete() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        goodsDao.delete(1);
        assertThat(goodsDao.totalCount(), is(0));
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
        goods1.setGoodsName("茉莉花1");
        goods1.setDescription("花的一种1");
        goods1.setPrice(BigDecimal.valueOf(15.31));
        goods1.setImgUrl("img/flowers/pasm1.jpg");

        Category category2 = new Category();
        category2.setId(2);
        category2.setCategoryName("普通花2");
        Goods goods2 = new Goods();
        goods2.setId(2);
        goods2.setCategory(category2);
        goods2.setGoodsName("茉莉花2");
        goods2.setDescription("花的一种2");
        goods2.setPrice(BigDecimal.valueOf(15.32));
        goods2.setImgUrl("img/flowers/pasm2.jpg");

        List<Goods> goodsList = goodsDao.findAll();
        assertThat(goodsList.toArray() ,arrayContainingInAnyOrder(is(goods1), is(goods2)));
    }

    @Test
    @Sql("classpath:/sql/GoodsDaoTest/testConditionQuery.sql")
    public void testConditionQuery() {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("goodsname", "茉莉");
        List<Goods> expected = new ArrayList<>();
        List<Goods> goodsList = goodsDao.conditionQuery(parameterMap, 1);
        for (int i = 1; i <= 5; i++) {
            Category category1 = new Category();
            category1.setId(i);
            category1.setCategoryName("普通花" + i);
            Goods goods1 = new Goods();
            goods1.setId(i);
            goods1.setCategory(category1);
            goods1.setGoodsName("茉莉花" + i);
            goods1.setDescription("花的一种" + i);
            goods1.setPrice(BigDecimal.valueOf(i).setScale(2));
            goods1.setImgUrl("img/flowers/pasm" + i + ".jpg");
            expected.add(goods1);
        }
        assertThat(goodsList, hasSize(5));
        assertThat(goodsList.toArray(), arrayContainingInAnyOrder(expected.toArray()));

        List<Goods> expected1 = new ArrayList<>();
        for (int i = 6; i <= 10; i++) {
            Category category1 = new Category();
            category1.setId(i);
            category1.setCategoryName("普通花" + i);
            Goods goods1 = new Goods();
            goods1.setId(i);
            goods1.setCategory(category1);
            goods1.setGoodsName("茉莉花" + i);
            goods1.setDescription("花的一种" + i);
            goods1.setPrice(BigDecimal.valueOf(i).setScale(2));
            goods1.setImgUrl("img/flowers/pasm" + i + ".jpg");
            expected1.add(goods1);
        }
        List<Goods> goodsList1 = goodsDao.conditionQuery(parameterMap, 2);
        assertThat(goodsList1, hasSize(5));
        assertThat(goodsList1.toArray(), arrayContainingInAnyOrder(expected1.toArray()));

        parameterMap.put("categoryId", "2");
        List<Goods> goodsList2 = goodsDao.conditionQuery(parameterMap, 1);
        Category category1 = new Category();
        category1.setId(2);
        category1.setCategoryName("普通花2");
        Goods goods5 = new Goods();
        goods5.setId(2);
        goods5.setCategory(category1);
        goods5.setGoodsName("茉莉花2");
        goods5.setDescription("花的一种2");
        goods5.setPrice(BigDecimal.valueOf(2).setScale(2));
        goods5.setImgUrl("img/flowers/pasm2.jpg");

        Goods goods6 = new Goods();
        goods6.setId(22);
        goods6.setCategory(category1);
        goods6.setGoodsName("茉莉花22");
        goods6.setDescription("花的一种22");
        goods6.setPrice(BigDecimal.valueOf(22).setScale(2));
        goods6.setImgUrl("img/flowers/pasm22.jpg");
        assertThat(goodsList2, hasSize(2));
        assertThat(goodsList2.toArray(), arrayContainingInAnyOrder(is(goods5), is(goods6)));

        parameterMap.put("fromPrice", "5");
        List<Goods> goodsList3 = goodsDao.conditionQuery(parameterMap, 1);

        assertThat(goodsList3, hasSize(1));
        assertThat(goodsList3.toArray(), arrayContainingInAnyOrder(is(goods6)));

        parameterMap.put("toPrice", "5");
        List<Goods> goodsList4 = goodsDao.conditionQuery(parameterMap, 1);
        assertThat(goodsList4, hasSize(1));
        assertThat(goodsList4.toArray(), arrayContainingInAnyOrder(is(goods6)));

        parameterMap.remove("fromPrice");
        List<Goods> goodsList5 = goodsDao.conditionQuery(parameterMap, 1);
        assertThat(goodsList5, hasSize(2));
        assertThat(goodsList5.toArray(), arrayContainingInAnyOrder(is(goods5), is(goods6)));
    }
}

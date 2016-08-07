package com.jikexueyuan.caiwen.dao.impl;

import com.jikexueyuan.caiwen.dao.GoodsDao;
import com.jikexueyuan.caiwen.entity.Category;
import com.jikexueyuan.caiwen.entity.Goods;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.xml.sax.InputSource;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

/**
 * Created by caiwen on 2016/8/6.
 */
public class GoodsDaoImplTest extends BaseDaoTest {
    @Resource
    GoodsDao goodsDao;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Test
    @Sql("classpath:/sql/GoodsDaoImplTest/testfindOne.sql")
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
    @Sql("classpath:/sql/GoodsDaoImplTest/testSave.sql")
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
    @Sql("classpath:/sql/GoodsDaoImplTest/testTotalCount.sql")
    public void testTotalCount() {
        Assert.assertEquals(goodsDao.totalCount(), Long.valueOf(5l));
    }


    /**
     * 首先从提供的excel中将每一条记录都转换成一个对象，然后持久化到数据库中
     */
    @Test
//    @Sql("classpath:/sql/GoodsDaoImplTest/testFindAll.sql")
    @DataSet
    public void testFindAll() throws IOException, DataSetException {
        IDataSet expectedDataSet = new FlatXmlDataSet(new FlatXmlProducer(new InputSource(new FileInputStream
                ("GoodsDaoTest.xml"))));
        ITable expectedTable = expectedDataSet.getTable("goods");
        XlsDataSet xlsDataSet = new XlsDataSet(new FileInputStream("GoodsDaotest.xlsx"));
            ITable xlsTable = xlsDataSet.getTable("sheet1");
//        Assert.assertEquals(goodsDao.findAll(), expectedTable.);


    }
}

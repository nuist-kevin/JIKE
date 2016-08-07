package com.jikexueyuan.caiwen.dao.impl;

import com.jikexueyuan.caiwen.dao.GoodsDao;
import org.dbunit.dataset.excel.XlsDataSet;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

//import static org.unitils.reflectionassert.ReflectionAssert.*;
/**
 * Created by caiwen on 2016/8/6.
 */
@SpringApplicationContext("classpath:applicationContext.xml")
public class GoodsDaoTest extends UnitilsJUnit4{

    @SpringBean("goodsDao")
    GoodsDao goodsDao;

    @Test
    @DataSet("GoodsDaoTest.xml")
//    @ExpectedDataSet("GoodsDaoTest.xml")
    public void testfindAll() {
        goodsDao.findAll();
    }
}

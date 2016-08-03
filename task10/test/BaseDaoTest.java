import com.jikexueyuan.caiwen.dao.BaseDao;
import com.jikexueyuan.caiwen.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by caiwen on 2016/8/3.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
//@Transactional(transactionManager = "transactionManager")
public class BaseDaoTest extends AbstractJUnit4SpringContextTests {
//    @Resource
//    BaseDao baseDao;

    @Autowired
    SessionFactory sessionFactory;
    @Test
    public void saveTest() {
        User user1 = new User();
        user1.setUserName("caiwen");
        user1.setRealName("蔡文");
        user1.setPassword("6886377");
        user1.setPwdQuestion("老婆的名字");
        user1.setPwdQuestion("宋晓娇");
        user1.setEmail("nuist_kevin@163.com");
        user1.setAddress("南京将军大道");
        user1.setPhoneNo("18094200522");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Integer id = (Integer)session.save(user1);

//          =  baseDao.save(user1);

//         Assert.assertEquals(((User) baseDao.findOne(id)).getUserName(), "caiwen");
        Assert.assertEquals(((User)session.get(User.class, id)).getUserName(), "caiwen");
        session.getTransaction().rollback();
        session.close();
    }

}

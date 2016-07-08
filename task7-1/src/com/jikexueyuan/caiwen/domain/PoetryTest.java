package com.jikexueyuan.caiwen.domain;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class PoetryTest {

    @Test
    public void test() {
/*		Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.b.buildSessionFactory();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = standardServiceRegistryBuilder.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);*/


        SessionFactory sessionFactory;
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata()
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();

/*            List<Object[]> resultList = session.createQuery(
                    "select p.poet.name, count(p) from Poetry p " +
                            "group by p.poet.name having length(p.poet.name) = 9 ").list();*/


/*            List<Object[]> resultList = session.createNativeQuery(
                    "select t2.name, count(t2.name)" +
                            "   FROM" +
                            "   tang_poetry.poetries t1" +
                            "   JOIN" +
                            "   tang_poetry.poets t2 ON t1.poet_id = t2.id" +
                            "   group by t2.name" +
                            "   having length(t2.name) = 9").getResultList();*/




            Long recordNum = (Long) session.createQuery("select count(p.title) from Poetry p where p.poet.name = '李白'").uniqueResult();
            System.out.println(recordNum);
            int pageNum = (int)(recordNum%10 == 0 ? recordNum/10 : (recordNum/10 + 1) );
            for (int i = 1; i <= pageNum; i++) {
                List<String> titles = session.createNativeQuery(
                        "select t1.title" +
                                "   FROM" +
                                "   tang_poetry.poetries t1" +
                                "   JOIN" +
                                "   tang_poetry.poets t2 ON t1.poet_id = t2.id" +
                                "   where t2.name='李白'").setFirstResult((i-1)*10).setMaxResults(10).
                        getResultList();
                System.out.println("第" + i +"页：");
                for (String title : titles) {
                    System.out.println("《" +title + "》");
                }

            }

 /*           for (Object[] record2 : resultList) {
                System.out.println(record2[0] + " - " + record2[1]);
            }*/
            session.close();


        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }


    }

}

package com.jikexueyuan.caiwen.entity;

import com.jikexueyuan.caiwen.entity.Poet;
import com.jikexueyuan.caiwen.entity.Poetry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by caiwen on 2016/7/8.
 */
public class TestUseJpa {
    public static void main(String[] args) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");

            EntityManager entityManager = entityManagerFactory.createEntityManager();
//            entityManager.getTransaction().begin();

/*
            List<Poet> result = entityManager.createQuery("from Poet").getResultList();

            for (Poet poet : result) {
                System.out.println(poet.getName());
            }
*/
        Query query = entityManager.createQuery("select substring(pp.content, 1, 15) from Poet p join p.poetries pp where p.name = :name");
        query.setParameter("name", "杜甫");
        List<String> result = query.getResultList();
        for (String title : result) {
            System.out.println(title);
        }

    }
}

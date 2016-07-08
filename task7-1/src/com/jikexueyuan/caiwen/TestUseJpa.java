package com.jikexueyuan.caiwen;

import com.jikexueyuan.caiwen.entity.Poet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by caiwen on 2016/7/8.
 */
public class TestUseJpa {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Poet> result = entityManager.createQuery("from Poet").getResultList();

        for ( Poet poet : result ) {
            System.out.println( poet.getName() );
        }

    }
}

package com.jikexueyuan.caiwen.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class BasicDao {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
    }

}

package com.jikexueyuan.caiwen.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import com.jikexueyuan.caiwen.dao.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
//@Transactional
public class BaseDaoImpl<T , PK extends Serializable> implements BaseDao<T, PK> {
	SessionFactory SessionFactory;
	Class<T> entityClass;


	public BaseDaoImpl() {
	       this.entityClass = null;
	        Class c = getClass();
	        Type t = c.getGenericSuperclass();
	        if (t instanceof ParameterizedType) {
	            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
	            this.entityClass = (Class<T>) p[0];
	        }
	}

	public SessionFactory getSessionFactory() {
		return SessionFactory;
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}

	public Session getSession() {
		return SessionFactory.getCurrentSession();
	}
	
	@Override
	public T findOne(PK pk) {
		return (T) getSession().load(entityClass, pk);
	}

	/**
	 * 新增和修改都使用这个方法，返回主键ID
	 */
	@Override
	public PK save(T model) {
		return (PK) getSession().save(model);
	}

	@Override
	public void delete(PK pk) {
		getSession().delete(findOne(pk));
	}

	@Override
	public List<T> findAll() {
		return getSession().createCriteria(entityClass).list();
	}

	@Override
	public Long totalCount() {
		// TODO Auto-generated method stub
		return (Long) getSession().createCriteria(entityClass).setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public List<T> findByPage(int pageSize, int startIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

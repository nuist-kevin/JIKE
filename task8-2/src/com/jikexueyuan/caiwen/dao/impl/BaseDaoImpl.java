package com.jikexueyuan.caiwen.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.jikexueyuan.caiwen.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	protected SessionFactory sessionFactory;
	protected Class<T> entityClass;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public BaseDaoImpl() {
	       this.entityClass = null;
	        Class c = getClass();
	        Type t = c.getGenericSuperclass();
	        if (t instanceof ParameterizedType) {
	            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
	            this.entityClass = (Class<T>) p[0];
	        }
	}

	@Override
	public T get(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return (T) session.get(entityClass, id);
	}

	@Override
	public Integer save(T model) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(model);
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(get(id));
	}

	@Override
	public void update(T model) {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public List<T> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return (List<T>)session.createCriteria(entityClass).list();
	}

	@Override
	public Long totalCount() {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.createCriteria(entityClass).setProjection(Projections.count("id")).uniqueResult();
	}

	@Override
	public List<T> findByPage(int pageSize, int startIndex) {
		Session session = sessionFactory.getCurrentSession();
		return (List<T>)session.createCriteria(entityClass)
				.setFirstResult(startIndex).setMaxResults(pageSize).list();
	}
}

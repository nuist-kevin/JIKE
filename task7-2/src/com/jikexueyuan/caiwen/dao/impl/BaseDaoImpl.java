package com.jikexueyuan.caiwen.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.jikexueyuan.caiwen.dao.BaseDao;
import com.jikexueyuan.caiwen.util.HibernateUtil;

public class BaseDaoImpl<T> implements BaseDao<T> {

	protected Class<T> entityClass;

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
		Session session = HibernateUtil.getSession();
		return (T) session.get(entityClass, id);
	}

	@Override
	public Integer save(T model) {
		Session session = HibernateUtil.getSession();
		return (Integer) session.save(model);
	}

	@Override
	public void delete(Integer id) {
		Session session = HibernateUtil.getSession();
		session.delete(get(id));
	}

	@Override
	public void update(T model) {
		Session session = HibernateUtil.getSession();
		session.update(model);
	}

	@Override
	public List<T> findAll() {
		Session session = HibernateUtil.getSession();
		return (List<T>)session.createCriteria(entityClass).list();
	}

	@Override
	public Long totalCount() {
		Session session = HibernateUtil.getSession();
		return (Long) session.createCriteria(entityClass).setProjection(Projections.count("id")).uniqueResult();
	}

	@Override
	public List<T> findByPage(int pageSize, int startIndex) {
		Session session = HibernateUtil.getSession();
		return (List<T>)session.createCriteria(entityClass)
				.setFirstResult(startIndex).setMaxResults(pageSize).list();
	}
}

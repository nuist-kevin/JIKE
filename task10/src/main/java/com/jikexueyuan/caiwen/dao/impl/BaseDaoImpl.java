package com.jikexueyuan.caiwen.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import com.jikexueyuan.caiwen.dao.BaseDao;

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
		return (T) getSession().get(entityClass, pk);
	}

	/**
	 * 新增方法，返回主键ID
	 */
	@Override
	public PK save(T model) {
		PK pk =   (PK) getSession().save(model);
		getSession().flush();
		return pk;
	}

	@Override
	public void saveOrUpdate(T model) {
		getSession().saveOrUpdate(model);
		getSession().flush();
	}

	@Override
	public void delete(PK pk) {
		getSession().delete(findOne(pk));
		getSession().flush();
	}

	@Override
	public List<T> findAll() {
		return getSession().createCriteria(entityClass).list();
	}

	@Override
	public Integer totalCount() {
		// TODO Auto-generated method stub
		return  new Long((Long) getSession().createCriteria(entityClass).setProjection(Projections.rowCount())
				.uniqueResult()).intValue();
	}

	@Override
	public Integer totalPages(Integer recordPerPage) {
		Integer totalCount = totalCount();
		if (recordPerPage == null) {
			recordPerPage = RECORD_PER_PAGE;
		}
		return ((totalCount % recordPerPage) == 0) ? (totalCount() / recordPerPage) : (totalCount() /
				recordPerPage + 1) ;
	}

	@Override
	public Map pagedQuery(Integer page, Integer recordPerPage) {
		if (recordPerPage == null) {
			recordPerPage = RECORD_PER_PAGE;
		}
		Map<String, Object> result = new HashMap<>();
		result.put("totalPages", totalPages(recordPerPage));
		Criteria criteria = getSession().createCriteria(entityClass);
		criteria.setMaxResults(recordPerPage);
		criteria.setFirstResult(recordPerPage * (page - 1));
		result.put("pageData", criteria.list());
		return result;
	}

}

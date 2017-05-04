package com.pizzalover.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pizzalover.dao.CategoryDAO;
import com.pizzalover.domain.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	public static Logger log = LoggerFactory.getLogger(SupplierDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);

		} catch (HibernateException e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	@Transactional
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);

		} catch (HibernateException e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	@Transactional
	public boolean delete(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);

		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public List<Category> list() {

		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	@Transactional
	public Category getByCategoryId(String category_id) {

		return (Category) sessionFactory.getCurrentSession().get(Category.class, category_id);
	}

	public Category getByCategoryName(String name) {
		
		
		log.debug("starting of getByCategoryName");

		String hql = "from Category where name ='" + name + "'";
		System.out.println(hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("ending of getByCategoryName");
		System.out.println("ending of getByCategoryName");
		return (Category) query.uniqueResult();
	}

}

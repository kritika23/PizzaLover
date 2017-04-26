package com.pizzalover.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pizzalover.dao.ProductDAO;
import com.pizzalover.domain.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	public static Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);

		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);

		} catch (HibernateException e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	@Transactional
	public boolean delete(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);

		} catch (HibernateException e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	@Transactional
	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Transactional
	public Product getByProductId(String product_id) {

		return (Product) sessionFactory.getCurrentSession().get(Product.class, product_id);
	}

}

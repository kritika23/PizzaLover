package com.pizzalover.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pizzalover.dao.SupplierDAO;
import com.pizzalover.domain.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
	public static Logger log = LoggerFactory.getLogger(SupplierDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);

		} catch (HibernateException e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	@Transactional
	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);

		} catch (HibernateException e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	@Transactional
	public boolean delete(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);

		} catch (HibernateException e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	@Transactional
	public List<Supplier> list() {

		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	@Transactional
	public Supplier getBySupplierId(String supplier_id) {

		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, supplier_id);
	}

}

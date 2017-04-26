package com.pizzalover.dao.impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.QueryExecutionRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pizzalover.dao.UserDAO;
import com.pizzalover.domain.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	public static Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean delete(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
		return true;

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> list() {

		return sessionFactory.getCurrentSession().createQuery("from User").list();

	}

	@Transactional
	public User getByUserId(String user_id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, user_id);

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public boolean validate(String user_id, String password) {
		log.debug("starting of isValid method");
		System.out.println("starting of isValid method");
		String hql = "from User where user_id ='" + user_id + "' and password='" + password + "'";
		System.out.println(hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("ending of isValid method");

		if (query.uniqueResult() == null) {
			return false;
		} else {
			System.out.println("ending of validate method");

			return true;

		}
	}

}

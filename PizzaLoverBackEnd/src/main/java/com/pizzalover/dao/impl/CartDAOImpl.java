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

import com.pizzalover.dao.CartDAO;
import com.pizzalover.domain.Cart;

	
	@Repository("cartDAO")

	public class CartDAOImpl implements CartDAO {
		public static Logger log = LoggerFactory.getLogger(CartDAOImpl.class);

		@Autowired
		private SessionFactory sessionFactory;
		
		
		public CartDAOImpl(SessionFactory sessionFactory) {

			this.sessionFactory = sessionFactory;
		}

		
		@Transactional
		public List<Cart> list(String user_id) {
			log.debug("Starting of the method list");
			String hql = "from Cart where user_id='" + user_id + "'  and status = " + "'New'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			log.debug("Ending of the method list");
			return query.list();
			
		}

		@Transactional
		public boolean save(Cart cart) {
			log.debug("Starting of the method save");

			//cart.setCart_id(cart.getCart_id());
			try {
				sessionFactory.getCurrentSession().save(cart);
				return true;
			} catch (HibernateException e) {
			
				e.printStackTrace();
				return false;
			}
			
		}

		@Transactional
		public Cart getCart(String user_id, String product_name) {
			String hql = "from Cart where user_id = ? and product_name = ?";
			Query  query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setString(0, user_id);
			query.setString(1, product_name);
			return (Cart) query.uniqueResult();
			
		}

		@Transactional
	
		public Integer getQuantity(String user_id, String product_name) {
			String hql = "select quantity from  cart where user_id = ?  &&  product_name =?";
			
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setString(0, user_id);
			query.setString(1, product_name);
			log.debug("Ending of the method getTotalAmount");
			return (Integer) query.uniqueResult();
		}
		
		
		@Transactional

		public Long getTotalAmount(String user_id) {
				log.debug("Starting of the method getTotalAmount");
				String hql = "select sum(price*quantity) from Cart where user_id=" + "'" + user_id + "'" + "  and status = " + "'New'";
				log.debug("hql" + hql);

				Query query = sessionFactory.getCurrentSession().createQuery(hql);
				log.debug("Ending of the method getTotalAmount");
				return (Long) query.uniqueResult();

		}

/*		@Transactional
		private int getMaxId() {
			log.debug("Starting of the method getMaxId");

			Long maxID = 100L;
			try {
				String hql = "select max(cart_id) from cart";
				Query query = sessionFactory.getCurrentSession().createQuery(hql);
				maxID = (Long) query.uniqueResult();
			} catch (HibernateException e) {
				log.debug("It seems this is first record. setting initial id is 100 :");
				maxID = 100L;
				e.printStackTrace();
			}
			log.debug("Max id :" + maxID);
			return (int) (maxID + 1);

		}*/
		

		@Transactional
	public Cart get(int id) {
		return (Cart) sessionFactory.getCurrentSession().get(Cart.class, id);
			
		}
		
		@Transactional
		public boolean delete(Cart cart) {
			try {
				sessionFactory.getCurrentSession().delete(cart);

			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		
		@Transactional
		public boolean update(Cart cart) {
			try {
				sessionFactory.getCurrentSession().update(cart);
				return true;
			} catch (HibernateException e) {
				
				e.printStackTrace();
				return false;
			}
		}



		
}

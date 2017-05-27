package com.pizzalover.config;
import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pizzalover.dao.UserDAO;
import com.pizzalover.domain.Cart;
import com.pizzalover.domain.Category;
import com.pizzalover.domain.Product;
import com.pizzalover.domain.Supplier;
import com.pizzalover.domain.User;

@Configuration
@ComponentScan("com.pizzalover")
@EnableTransactionManagement
public class AnnotationConfigApplicationContext {

	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test1");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		
		dataSource.setPassword("sa");
		
		return dataSource;
	}

	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClasses(Supplier.class);
		sessionBuilder.addAnnotatedClasses(Product.class);
		sessionBuilder.addAnnotatedClasses(Category.class);
		//sessionBuilder.addAnnotatedClasses(BillingAddress.class);
		sessionBuilder.addAnnotatedClasses(Cart.class);
		//sessionBuilder.addAnnotatedClasses(CartItem.class);
		//sessionBuilder.addAnnotatedClasses(Customer.class);
		//sessionBuilder.addAnnotatedClasses(ShippingAddress.class);
		//sessionBuilder.addAnnotatedClasses(Payment.class);
		//sessionBuilder.addAnnotatedClass(Billing.class);

		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	

}

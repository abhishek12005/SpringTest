package com.menu.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

//A Util class for returning session factory object
@Repository
@Transactional
public class HibernateUtil {

	@PersistenceContext
	private EntityManager entityManager;

	public SessionFactory getHiberSessionFactory() {
		try {
			SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
			return sessionFactory;
		} catch (HibernateException e) {
			// TODO: handle exception
			System.out.println("Hibernate exception in creating sessionFactory" + e);
			throw e;
		}

	}

}

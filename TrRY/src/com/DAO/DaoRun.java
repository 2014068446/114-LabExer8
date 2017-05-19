package com.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.BEAN.TVSeries;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;


public class DaoRun implements TVDao {
	
	/*SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	*/
	
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;
	/**
	 * Used to save or update a TV.
	 */
	@Override
	public void saveOrUpdateTV(TVSeries TV) {
		try {
			
			session.saveOrUpdate(TV);
			
			
		} catch (Exception e) {
			
			System.out.print(e);
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a TV.
	 */
	@Override
	public void deleteTV(Long TVId) {
		try {
			TVSeries TV = (TVSeries) session.get(TVSeries.class, TVId);
			session.delete(TV);
			
		} catch (Exception e) {
			System.out.print(e);
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the TVs.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TVSeries> listTV() {
		List<TVSeries> courses = null;
		try {
			courses = session.createQuery("FROM TVSeries").list();
			
		} catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * Used to list a single TV by Id.
	 */
	@Override
	public TVSeries listTVById(Long TVId) {
		TVSeries TV = null;
		try {
			TV = (TVSeries) session.get(TVSeries.class, TVId);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TV;
	}

}

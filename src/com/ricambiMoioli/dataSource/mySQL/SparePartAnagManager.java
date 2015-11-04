package com.ricambiMoioli.dataSource.mySQL;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.ricambiMoioli.model.SparePartAnag;



public class SparePartAnagManager {

	private SessionFactory factory;
	public SparePartAnagManager()
	{
		factory = new Configuration().configure("resources/hibernate.cfg.xml").
				addPackage("com.ricambiMoioli.model"). //add package if used.
				addAnnotatedClass(SparePartAnag.class).
				buildSessionFactory();
	}
	
	public ArrayList<SparePartAnag> getAllSPA()
	{
		List<SparePartAnag> tmpList = new ArrayList<SparePartAnag>();
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();          
			tmpList = session.createCriteria(SparePartAnag.class).list();
			//alternative with hql
			//String hql = "select a from SparePartAnag a";
			//tmpList = session.createQuery(hql).list();

		}
		catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}	

		return new ArrayList<SparePartAnag>(tmpList);
		
	}
	
	
	public Boolean addNewSPObject(SparePartAnag sPA)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer sparePartAnagID = null;
		Boolean failure = false; 
		try{
			tx = session.beginTransaction();
			sparePartAnagID = (Integer) session.save(sPA); 
			tx.commit();
			return true;
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
			failure = true;
		}finally {
			session.close();
		}	
		return !failure;
	}

	public ArrayList<SparePartAnag> getSPObject(int sPACod) {
		// return the obj corresponding to sPCod
		Session session = factory.openSession();
		Transaction tx = null;
		List<SparePartAnag> tmpList = new ArrayList<SparePartAnag>();
		try{
			tx = session.beginTransaction();          
			
			//alternative with hql
			String hql = "FROM SparePartAnag S WHERE S.codSpa = " + sPACod;
			tmpList = session.createQuery(hql).list();

		}
		catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}	

		return new ArrayList<SparePartAnag>(tmpList);
	}
	
}

package com.ricambiMoioli.dataSource.mySQL;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ricambiMoioli.model.SparePart;

public class SparePartManager {

	private SessionFactory factory;
	public SparePartManager()
	{
		factory = new Configuration().configure("resources/hibernate.cfg.xml").
				addPackage("com.ricambiMoioli.model"). //add package if used.
				addAnnotatedClass(SparePart.class).
				buildSessionFactory();
	}

	public ArrayList<SparePart> getAllSPObject()
	{
		List<SparePart> tmpList = new ArrayList<SparePart>();
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();          
			tmpList = session.createCriteria(SparePart.class).list();
			//alternative with hql
			//String hql = "select a from SparePart a";
			//tmpList = session.createQuery(hql).list();

		}
		catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}	

		return new ArrayList<SparePart>(tmpList);
		
	}

	public ArrayList<SparePart> getAllSPObjectExtended()
	{
		List<SparePart> tmpList = new ArrayList<SparePart>();
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();          
			tmpList = session.createCriteria(SparePart.class).list();
			
			//https://access.redhat.com/documentation/en-US/JBoss_Enterprise_Application_Platform/4.2/html/Hibernate_Annotations_Reference_Guide/sect-Hibernate_Annotations_Reference_Guide-Mapping_with_EJB3JPA_Annotations-Mapping_secondary_tables.html
			//http://www.concretepage.com/hibernate/secondarytables_hibernate_annotation
			//http://stackoverflow.com/questions/22668350/how-to-map-one-class-with-multiple-tables-in-hibernate-javax-persistance
			
			
			//sess.createSQLQuery
			//alternative with hql
			//String hql = "select a from SparePart a";
			//tmpList = session.createQuery(hql).list();

		}
		catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}	

		return new ArrayList<SparePart>(tmpList);
		
	}
	
	
	public Boolean addNewSPObject(SparePart sP)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer sparePartID = null;
		Boolean failure = false; 
		try{
			tx = session.beginTransaction();
			sparePartID = (Integer) session.save(sP); 
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

	public ArrayList<SparePart> getSPObject(int sPCod) {
		// return the obj corresponding to sPCod
		Session session = factory.openSession();
		Transaction tx = null;
		List<SparePart> tmpList = new ArrayList<SparePart>();
		try{
			tx = session.beginTransaction();          
			
			//alternative with hql
			String hql = "FROM SparePart S WHERE S.ID = " + sPCod;
			tmpList = session.createQuery(hql).list();

		}
		catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close();
		}	

		return new ArrayList<SparePart>(tmpList);
	}


}

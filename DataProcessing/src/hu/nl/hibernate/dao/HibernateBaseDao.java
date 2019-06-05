package hu.nl.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateBaseDao {
	public static final StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	public static final Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
	
	public static SessionFactory factory;
	public static Session session;
	public static Transaction t;
	
	public Session getSession(){
		session = factory.openSession();
		t = session.beginTransaction();
		
		return session;
	}
	
	public void closeSession(){
		t.commit();
		session.close();
	}
	
	public SessionFactory getFactory() {
		factory = meta.getSessionFactoryBuilder().build();
		
		return factory;
	}
	
	public void closeFactory() {
		factory.close();
	}
}

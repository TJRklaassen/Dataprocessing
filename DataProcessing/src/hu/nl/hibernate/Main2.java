package hu.nl.hibernate;

import java.sql.Date;

import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder; 

public class Main2 {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		// test create
		Reiziger r1 = new Reiziger(6, "TJR", "", "Klaassen", Date.valueOf("1997-04-16"));
		session.save(r1);

		// test update
		//Reiziger r2 = new Reiziger(2, "K", null, "Jansen", Date.valueOf("2001-10-22"));
		Reiziger r2 = new Reiziger(2, "B", "van", "Rijn", Date.valueOf("2002-10-22"));
		session.update(r2);

		// test read
		Reiziger r = session.get(Reiziger.class, 2);
		printReiziger(r);
		r = session.get(Reiziger.class, 6);
		printReiziger(r);

		// test delete
		session.delete(r1);

		t.commit();
		factory.close();
		session.close();
	}
	
	 public static void printReiziger(Reiziger r) {
	      if(r.getTussenvoegsel() == null) {
	    	  System.out.println(String.format("%s, %s %s, %s",
	    			  r.getReizigerID(), r.getVoorletters(), r.getAchternaam(), r.getGbdatum()));
	      } else {
	    	  System.out.println(String.format("%s, %s %s %s, %s",
	    			  r.getReizigerID(), r.getVoorletters(), r.getTussenvoegsel(), r.getAchternaam(), r.getGbdatum()));
	      }
	  }
}
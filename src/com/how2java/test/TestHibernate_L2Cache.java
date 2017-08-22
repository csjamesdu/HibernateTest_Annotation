package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;

public class TestHibernate_L2Cache {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s1 = sf.openSession();
		s1.beginTransaction();
		
		Category c1 = (Category)s1.get(Category.class, 2);
		System.out.println("mark1");
		Category c2 = (Category)s1.get(Category.class, 2);
		System.out.println("mark2");
		s1.getTransaction().commit();
		s1.close();
		
		Session s2 = sf.openSession();
		s2.beginTransaction();
		Category c3 =(Category)s2.get(Category.class, 2);
		System.out.println("mark3");
		s2.getTransaction().commit();
		s2.close();
		//pay attention to the property value of lazyload, if "lazy==false", l2 cache won't work as expected
		//cause the query is about the relationship between several objects/tables not the object/table itself
		sf.close();
	}

}

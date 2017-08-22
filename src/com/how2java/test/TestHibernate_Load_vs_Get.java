package com.how2java.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.how2java.pojo.Product;

public class TestHibernate_Load_vs_Get {
	public static void main(String[] args){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		s.beginTransaction();
		//when using load() method, query won't be conducted before the operation on object's property;
		//when data ain't exists, load() returns exception ObjectNotFoundException
		Product p = (Product)s.load(Product.class, 1);
		System.out.println("log1");
		String name=p.getName();
		System.out.println("log2");
		
		//when using get() method, query will be conducted first no matter there's operation on the property or not!
		//when data ain't exists, get() returns NULL, if pass its value to reference might result in NullPointerException;
		Product p2 = (Product)s.get(Product.class, 60);
		System.out.println("log3");
		System.out.println(p2);
		//String name2=p2.getName();
		System.out.println("log4");
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}

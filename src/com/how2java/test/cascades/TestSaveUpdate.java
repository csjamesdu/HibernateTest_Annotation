package com.how2java.test.cascades;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;

public class TestSaveUpdate {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Category c = (Category)s.get(Category.class, 1);
		
		Product p1 = new Product();
		p1.setName("product_101");
		Product p2 = new Product();
		p2.setName("product_102");
		Product p3 = new Product();
		p3.setName("product_103");
		
		c.getProducts().add(p1);
		c.getProducts().add(p2);
		c.getProducts().add(p3);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
		//delete_category_1();
	}
	
	/*public static void delete_category_1(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Category c = (Category)s.get(Category.class, 1);
		s.delete(c);
		
		s.close();
		sf.close();
	}*/

}

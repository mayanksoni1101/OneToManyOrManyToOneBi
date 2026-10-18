package org.jsp.onetomanyormanytoonebi;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertData {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etran = em.getTransaction();
		etran.begin();
		
		Merchant m = new Merchant();
		m.setName("Mayank Soni");
		m.setGst_num("APGT9485623DS");
		m.setPassword("admin");
		m.setPhone(9485688456l);
		m.setEmail("mayanksoni@gmail.com");
		
		Product p1 = new Product();
		p1.setName("Laptop");
		p1.setBrand("Lenovo");
		p1.setCategory("Electronics");
		p1.setPrice(56000);
		p1.setM(m);
		
		Product p2 = new Product();
		p2.setName("Mouse");
		p2.setBrand("Lenovo");
		p2.setCategory("Electronics");
		p2.setPrice(1000);
		p2.setM(m);
		
		Product p3 = new Product();
		p3.setName("Keyboard");
		p3.setBrand("Lenovo");
		p3.setCategory("Electronics");
		p3.setPrice(5000);
		p3.setM(m);
		
		Product p4 = new Product();
		p4.setName("Monitor");
		p4.setBrand("Lenovo");
		p4.setCategory("Electronics");
		p4.setPrice(8500);
		p4.setM(m);
		
		List<Product> plist = Arrays.asList(p1,p2,p3,p4);
		
		m.setProds(plist);
		
		em.persist(m);
		etran.commit();
	}
}

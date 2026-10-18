package org.jsp.onetomanyormanytoonebi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FindProductByName {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		TypedQuery<Product> q = em.createQuery("select p from Product p where p.name = ?1", Product.class);
		System.out.println("Enter Product Name : ");
		q.setParameter(1, sc.nextLine());
		List<Product> plist = q.getResultList();
		if(!plist.isEmpty()) {
			plist.forEach(System.out::println);
		}
		else {
			System.err.println("No Record Found !!!");
		}
		try {}
		finally {
			sc.close();
		}
	
	
	}
}

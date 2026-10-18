package org.jsp.onetomanyormanytoonebi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FindProductsByMerchantPhoneAndPassword {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		TypedQuery<Product> q = em.createQuery("select p from Product p where p.m.phone = ?1 and p.m.password = ?2", Product.class);
		System.out.println("Enter Merchant Phone Number : ");
		q.setParameter(1, sc.nextLong());
		System.out.println("Enter Merchant Password : ");
		q.setParameter(2, sc.next());
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

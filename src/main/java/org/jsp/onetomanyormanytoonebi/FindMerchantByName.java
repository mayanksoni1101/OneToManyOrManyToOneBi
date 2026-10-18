package org.jsp.onetomanyormanytoonebi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FindMerchantByName {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		TypedQuery<Merchant> q = em.createQuery("select m from Merchant m where m.name = ?1", Merchant.class);
		System.out.println("Enter Merchant Name : ");
		q.setParameter(1, sc.nextLine());
		List<Merchant> mlist = q.getResultList();
		if(!mlist.isEmpty()) {
			mlist.forEach(System.out::println);
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

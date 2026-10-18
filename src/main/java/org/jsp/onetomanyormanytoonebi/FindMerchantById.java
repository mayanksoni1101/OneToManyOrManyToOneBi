package org.jsp.onetomanyormanytoonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindMerchantById {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Merchant Id : ");
		Merchant m = em.find(Merchant.class, sc.nextInt());
		if(m!=null) {
			System.out.println(m);
		}
		else {
			System.err.println("No Record Found");
		}
		try {}
		finally {
			sc.close();
		}
	}
}

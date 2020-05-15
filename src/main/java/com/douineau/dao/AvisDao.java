package com.douineau.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.douineau.entity.Avis;
import com.douineau.utils.PersistenceUtil;

public class AvisDao {

	public static void insertAvis(Avis avis) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(avis);
		em.getTransaction().commit();

		em.close();
	}

	public static List<Avis> getThreeLatestAvis() {
		EntityManager em = PersistenceUtil.getEntityManager();
		TypedQuery<Avis> query = em.createQuery("SELECT a FROM Avis a WHERE a.toValidate = '0' ORDER BY a.createdAt DESC", Avis.class);
		List<Avis> avis = query.getResultList();
		em.close();

		Collections.shuffle(avis);
		List<Avis> threeAvis = new ArrayList<Avis>();
		if (avis.size() >= 3) {
			for (int k = 0; k < 3; k++) {
				threeAvis.add(avis.get(k));
			}
		}

		return threeAvis;

	}

	public static List<Avis> getAll() {
		EntityManager em = PersistenceUtil.getEntityManager();
		TypedQuery<Avis> query = em.createQuery("SELECT a FROM Avis a", Avis.class);
		List<Avis> avis = query.getResultList();
		em.close();

		return avis;

	}
	
	public static Avis getLatestNotReadAvis() {
		EntityManager em = PersistenceUtil.getEntityManager();
		TypedQuery<Avis> query = em.createQuery("SELECT a FROM Avis a WHERE a.toValidate = '1' ORDER BY a.createdAt DESC", Avis.class);
		List<Avis> avis = query.setMaxResults(1).getResultList();
		em.close();

		return avis.get(0);

	}
	
	public static Avis getNextLatestNotReadAvis(int index) {
		EntityManager em = PersistenceUtil.getEntityManager();
		TypedQuery<Avis> query = em.createQuery("SELECT a FROM Avis a WHERE a.toValidate = '1' ORDER BY a.createdAt DESC", Avis.class);
		List<Avis> avis = query.setMaxResults(index + 1).getResultList();
		em.close();

		return avis.get(index);

	}
	
	public static void validateAvis(String id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		Avis avis = em.find(Avis.class, Long.parseLong(id));
		avis.setToValidate("0");
		em.merge(avis);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public static void delete(String id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		Avis avis = em.find(Avis.class, Long.parseLong(id));
		em.remove(avis);
		em.getTransaction().commit();

		em.close();

	}
	
	public static Long getCount() {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(a) FROM Avis a WHERE a.toValidate = '1' ", Long.class);
		Long i = query.getSingleResult();
		em.close();
		
		return i ;

	}
}

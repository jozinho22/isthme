package com.douineau.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.douineau.entity.Commande;
import com.douineau.utils.PersistenceUtil;

public class CommandeDao {
	
	public static void insertCommande(Commande commande) {
    	EntityManager em = PersistenceUtil.getEntityManager();
    	em.getTransaction().begin();
    	em.persist(commande);
    	em.getTransaction().commit();;

		em.close();
	}
	
	public static List<Commande> getCommandesClient(String id) {
		System.out.println("id : " + id);
    	EntityManager em = PersistenceUtil.getEntityManager();
		TypedQuery<Commande> query = em.createQuery("SELECT c FROM Commande c where c.client = " + id , Commande.class);
//		query.setParameter(1, client.getId());
		List<Commande> commandes = query.getResultList();
		em.close();
		
		return commandes;
		
	}

}

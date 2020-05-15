package com.douineau.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.douineau.entity.Client;
import com.douineau.utils.PersistenceUtil;

public class ClientDao {
	
	public static Client getClientById(String id) {
		
    	EntityManager em = PersistenceUtil.getEntityManager();
    	Client client = em.find(Client.class, Long.parseLong(id));

		return client;
	}
	public static void insertClient(Client client) {
    	EntityManager em = PersistenceUtil.getEntityManager();
    	em.getTransaction().begin();
    	em.persist(client);
    	em.getTransaction().commit();;

		em.close();
	}
	
	public static List<Client> getClients() {
    	EntityManager em = PersistenceUtil.getEntityManager();
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
		List<Client> clients = query.getResultList();
		em.close();
		
		return clients;
	}
	
	public static List<Client> getRechercheClient(String req) {
    	EntityManager em = PersistenceUtil.getEntityManager();
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.nom LIKE '%" + req + "%'", Client.class);
		List<Client> clients = query.setMaxResults(7).getResultList();
		em.close();
		
		return clients;
	}
}

package com.douineau.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.douineau.entity.Gestion;
import com.douineau.utils.PersistenceUtil;

public class GestionDao {

	public static boolean check(String login, String password) {
		boolean checked;
    	EntityManager em = PersistenceUtil.getEntityManager();
		TypedQuery<Gestion> query = em.createQuery("SELECT g FROM Gestion g where g.login = ?1 and g.password = ?2", Gestion.class);
		query.setParameter(1, login);
		query.setParameter(2, password);

		try {
			Gestion gestion = query.getSingleResult();
			checked = true;
		} catch (NoResultException nre) {
			return false;
		} finally {
			em.close();
		}
		
		return checked;
	}

}

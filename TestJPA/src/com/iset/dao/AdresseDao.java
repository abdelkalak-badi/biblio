package com.iset.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import com.iset.model.Adresse;
import com.iset.util.JpaUtil;

public class AdresseDao {

	private EntityManager entityManager=JpaUtil.getEntityManager("TestJPA");
	 
	//m�thode ajouter d'une entit� �  la bd
		 public   void ajouter(Adresse c)
		{
			 EntityTransaction tx = entityManager.getTransaction();
			 	tx.begin();
			 	entityManager.persist(c);
			 	tx.commit();
			 	  
			}
			 
			 //m�thode modifier d'une entit� �  partir de la bd
			 public   void modifier(Adresse c)
				{
				 	EntityTransaction tx = entityManager.getTransaction();
				 	tx.begin();
				 	entityManager.merge(c);
				 	tx.commit();
				 	  
				}
			 
			 //m�thode Supprimer d'une entit� �  partir de la bd
			 public  void supprimer(Adresse c)
			{ 
				EntityTransaction tx = entityManager.getTransaction();
			    tx.begin();
			    c=entityManager.merge(c); // important
			    entityManager.remove(c);
			    tx.commit();  
			}
			 
			 //m�thode Consulter d'une entit� �  partir de la bd
			 public  Adresse consulter(Adresse c,Object id)
			{
			 	return entityManager.find(c.getClass(), id);
				}
			 
			 //m�thode pour lister tous les objets �  partir de la bd
			 public List<Adresse> listerTous() {
				 List<Adresse> clients =
		         entityManager.createQuery( 
		      "select c from Adresse c").getResultList();
				 return clients;
				 } 
		//m�thode pour lister tous les client dont le nom contient un //texte donn� en param�tre (pnom)
		 public List<Adresse> listerParNom(String nom) {List<Adresse> clients =entityManager.createQuery( "select c from adresse c where c.nom like :pnom")
		.setParameter("pnom","%"+nom+"%").getResultList();

				 return clients;	 }

}

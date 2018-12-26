package com.iset.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.iset.model.Livre;
import com.iset.util.JpaUtil;

public class LivreDao {


	private EntityManager entityManager=JpaUtil.getEntityManager("TestJPA");
	 
	//m�thode ajouter d'une entit� �  la bd
		 public   void ajouter(Livre c)
		{
			 EntityTransaction tx = entityManager.getTransaction();
			 	tx.begin();
			 	entityManager.persist(c);
			 	tx.commit();
			 	  
			}
			 
			 //m�thode modifier d'une entit� �  partir de la bd
			 public   void modifier(Livre c)
				{
				 	EntityTransaction tx = entityManager.getTransaction();
				 	tx.begin();
				 	entityManager.merge(c);
				 	tx.commit();
				 	  
				}
			 
			 //m�thode Supprimer d'une entit� �  partir de la bd
			 public  void supprimer(Livre c)
			{ 
				EntityTransaction tx = entityManager.getTransaction();
			    tx.begin();
			    c=entityManager.merge(c); // important
			    entityManager.remove(c);
			    tx.commit();  
			}
			 
			 //m�thode Consulter d'une entit� �  partir de la bd
			 public  Livre consulter(Livre c,Object id)
			{
			 	return entityManager.find(c.getClass(), id);
				}
			 
			 //m�thode pour lister tous les objets �  partir de la bd
			 public List<Livre> listerTous() {
				 List<Livre> clients =
		         entityManager.createQuery( 
		      "select c from Livre c").getResultList();
				 return clients;
				 } 
		//m�thode pour lister tous les client dont le nom contient un //texte donn� en param�tre (pnom)
		 public List<Livre> listerParNom(String nom) {List<Livre> clients =entityManager.createQuery( "select c from Client c where c.nom like :pnom")
		.setParameter("pnom","%"+nom+"%").getResultList();

				 return clients;	 }


}

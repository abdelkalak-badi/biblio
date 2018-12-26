package com.iset.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.iset.model.Livre;
import com.iset.util.JpaUtil;

public class LivreDao {


	private EntityManager entityManager=JpaUtil.getEntityManager("TestJPA");
	 
	//méthode ajouter d'une entité à  la bd
		 public   void ajouter(Livre c)
		{
			 EntityTransaction tx = entityManager.getTransaction();
			 	tx.begin();
			 	entityManager.persist(c);
			 	tx.commit();
			 	  
			}
			 
			 //méthode modifier d'une entité à  partir de la bd
			 public   void modifier(Livre c)
				{
				 	EntityTransaction tx = entityManager.getTransaction();
				 	tx.begin();
				 	entityManager.merge(c);
				 	tx.commit();
				 	  
				}
			 
			 //méthode Supprimer d'une entité à  partir de la bd
			 public  void supprimer(Livre c)
			{ 
				EntityTransaction tx = entityManager.getTransaction();
			    tx.begin();
			    c=entityManager.merge(c); // important
			    entityManager.remove(c);
			    tx.commit();  
			}
			 
			 //méthode Consulter d'une entité à  partir de la bd
			 public  Livre consulter(Livre c,Object id)
			{
			 	return entityManager.find(c.getClass(), id);
				}
			 
			 //méthode pour lister tous les objets à  partir de la bd
			 public List<Livre> listerTous() {
				 List<Livre> clients =
		         entityManager.createQuery( 
		      "select c from Livre c").getResultList();
				 return clients;
				 } 
		//méthode pour lister tous les client dont le nom contient un //texte donné en paramètre (pnom)
		 public List<Livre> listerParNom(String nom) {List<Livre> clients =entityManager.createQuery( "select c from Client c where c.nom like :pnom")
		.setParameter("pnom","%"+nom+"%").getResultList();

				 return clients;	 }


}

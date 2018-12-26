package com.iset.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.iset.model.Classe;
import com.iset.util.JpaUtil;

public class ClasseDao {


	private EntityManager entityManager=JpaUtil.getEntityManager("TestJPA");
	 
	//m�thode ajouter d'une entit� �  la bd
		 public   void ajouter(Classe c)
		{
			 EntityTransaction tx = entityManager.getTransaction();
			 	tx.begin();
			 	entityManager.persist(c);
			 	tx.commit();
			 	  
			}
			 
			 //m�thode modifier d'une entit� �  partir de la bd
			 public   void modifier(Classe c)
				{
				 	EntityTransaction tx = entityManager.getTransaction();
				 	tx.begin();
				 	entityManager.merge(c);
				 	tx.commit();
				 	  
				}
			 
			 //m�thode Supprimer d'une entit� �  partir de la bd
			 public  void supprimer(Classe c)
			{ 
				EntityTransaction tx = entityManager.getTransaction();
			    tx.begin();
			    c=entityManager.merge(c); // important
			    entityManager.remove(c);
			    tx.commit();  
			}
			 
			 //m�thode Consulter d'une entit� �  partir de la bd
			 public  Classe consulter(Classe c,Object id)
			{
			 	return entityManager.find(c.getClass(), id);
				}
			 
			 //m�thode pour lister tous les objets �  partir de la bd
			 public List<Classe> listerTous() {
				 List<Classe> clients =
		         entityManager.createQuery( 
		      "select c from Classe c").getResultList();
				 return clients;
				 } 
		//m�thode pour lister tous les client dont le nom contient un //texte donn� en param�tre (pnom)
		 public List<Classe> listerParNom(String nom) {List<Classe> clients =entityManager.createQuery( "select c from Client c where c.nom like :pnom")
		.setParameter("pnom","%"+nom+"%").getResultList();

				 return clients;	 }

}

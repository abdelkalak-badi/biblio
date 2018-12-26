package com.iset.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.iset.model.Etudiant;
import com.iset.util.JpaUtil;

public class EtudiantDao {

	private EntityManager entityManager=JpaUtil.getEntityManager("TestJPA");
	 
	//m�thode ajouter d'une entit� �  la bd
		 public   void ajouter(Etudiant c)
		{
			 EntityTransaction tx = entityManager.getTransaction();
			 	tx.begin();
			 	entityManager.persist(c);
			 	tx.commit();
			 	  
			}
			 
			 //m�thode modifier d'une entit� �  partir de la bd
			 public   void modifier(Etudiant c)
				{
				 	EntityTransaction tx = entityManager.getTransaction();
				 	tx.begin();
				 	entityManager.merge(c);
				 	tx.commit();
				 	  
				}
			 
			 //m�thode Supprimer d'une entit� �  partir de la bd
			 public  void supprimer(Etudiant c)
			{ 
				EntityTransaction tx = entityManager.getTransaction();
			    tx.begin();
			    c=entityManager.merge(c); // important
			    entityManager.remove(c);
			    tx.commit();  
			}
			 
			 //m�thode Consulter d'une entit� �  partir de la bd
			 public  Etudiant consulter(Etudiant c,Object id)
			{
			 	return entityManager.find(c.getClass(), id);
				}
			 
			 //m�thode pour lister tous les objets �  partir de la bd
			 public List<Etudiant> listerTous() {
				 List<Etudiant> clients =
		         entityManager.createQuery( 
		      "select c from Etudiant c").getResultList();
				 return clients;
				 } 
		//m�thode pour lister tous les client dont le nom contient un //texte donn� en param�tre (pnom)
		 public List<Etudiant> listerParNom(String nom) {List<Etudiant> clients =entityManager.createQuery( "select c from Client c where c.nom like :pnom")
		.setParameter("pnom","%"+nom+"%").getResultList();

				 return clients;	 }
}

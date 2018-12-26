package com.iset.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.iset.model.Etudiant;
import com.iset.util.JpaUtil;

public class EtudiantDao {

	private EntityManager entityManager=JpaUtil.getEntityManager("TestJPA");
	 
	//méthode ajouter d'une entité à  la bd
		 public   void ajouter(Etudiant c)
		{
			 EntityTransaction tx = entityManager.getTransaction();
			 	tx.begin();
			 	entityManager.persist(c);
			 	tx.commit();
			 	  
			}
			 
			 //méthode modifier d'une entité à  partir de la bd
			 public   void modifier(Etudiant c)
				{
				 	EntityTransaction tx = entityManager.getTransaction();
				 	tx.begin();
				 	entityManager.merge(c);
				 	tx.commit();
				 	  
				}
			 
			 //méthode Supprimer d'une entité à  partir de la bd
			 public  void supprimer(Etudiant c)
			{ 
				EntityTransaction tx = entityManager.getTransaction();
			    tx.begin();
			    c=entityManager.merge(c); // important
			    entityManager.remove(c);
			    tx.commit();  
			}
			 
			 //méthode Consulter d'une entité à  partir de la bd
			 public  Etudiant consulter(Etudiant c,Object id)
			{
			 	return entityManager.find(c.getClass(), id);
				}
			 
			 //méthode pour lister tous les objets à  partir de la bd
			 public List<Etudiant> listerTous() {
				 List<Etudiant> clients =
		         entityManager.createQuery( 
		      "select c from Etudiant c").getResultList();
				 return clients;
				 } 
		//méthode pour lister tous les client dont le nom contient un //texte donné en paramètre (pnom)
		 public List<Etudiant> listerParNom(String nom) {List<Etudiant> clients =entityManager.createQuery( "select c from Client c where c.nom like :pnom")
		.setParameter("pnom","%"+nom+"%").getResultList();

				 return clients;	 }
}

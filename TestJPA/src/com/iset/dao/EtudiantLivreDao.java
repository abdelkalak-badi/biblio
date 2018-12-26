package com.iset.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.iset.model.Adresse;
import com.iset.model.Classe;
import com.iset.model.Etudiant;
import com.iset.model.Etudiant_Livre;
import com.iset.model.Livre;
import com.iset.util.JpaUtil;

public class EtudiantLivreDao {
	private EntityManager entityManager=JpaUtil.getEntityManager("TestJPA");
	
	public void Ajouter_dones_Liste_livre(Etudiant etudiant,Livre livre) {
		
	    
		String quer="SELECT * FROM Etudiant_Livre WHERE EtudiantID='?';";
		Query q = entityManager.createNativeQuery(quer).setParameter(1,etudiant.getCin());
		List<Livre> authorsl = q.getResultList();
		LivreDao ld =new LivreDao();
		//List<Livre> authorsl=new ArrayList<>();
		//List<Etudiant> authorse =new ArrayList<>();
		
	    quer="SELECT * FROM Etudiant_Livre WHERE LivreID='?';";
		q = entityManager.createNativeQuery(quer).setParameter(1,livre.getId());
		List<Etudiant> authorse = q.getResultList();
		EtudiantDao ed =new EtudiantDao();

		EntityTransaction tx = entityManager.getTransaction();
	    tx.begin();
	    authorsl.add(livre);
		etudiant.setLivres(authorsl);
		authorse.add(etudiant);
		livre.setEtudiants(authorse);
		tx.commit(); 
		 }
	
	public ArrayList<Etudiant_Livre> SelectALL() {
		EntityTransaction tx = entityManager.getTransaction();
	    tx.begin();
	    
		String quer="SELECT * FROM Etudiant_Livre ;";
		Query q = entityManager.createNativeQuery(quer);
		ArrayList<Etudiant_Livre> authors = (ArrayList<Etudiant_Livre>) q.getResultList();
		System.out.println("00000000"+authors);
		tx.commit();
		return authors;
	
	}
	
	 public List<Etudiant_Livre> listerTous() {
		 List<Etudiant_Livre> clients =
         entityManager.createQuery( 
      "select c from Etudiant_Livre c").getResultList();
		 return clients;
		 } 
	

}

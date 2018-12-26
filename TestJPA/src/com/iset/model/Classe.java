package com.iset.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Classe {
	
	@Id 
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany (mappedBy="classe") 
    private List<Etudiant> etuiants;
	


	private String nom;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public List<Etudiant> getEtuiants() {
		return etuiants;
	}



	public void setEtuiants(List<Etudiant> etuiants) {
		this.etuiants = etuiants;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Classe(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}



	@Override
	public String toString() {
		return nom;
	}



	public Classe() {
		super();
	}
	
	


	

}

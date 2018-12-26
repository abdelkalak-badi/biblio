package com.iset.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Livre {
	
	@Id 
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany (mappedBy="Livres")
	private List<Etudiant>Etudiants;
	
	private String titre;
	private String auteur;

	@Temporal( TemporalType.DATE )
	private Date dateEdition;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Etudiant> getEtudiants() {
		return Etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		Etudiants = etudiants;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Date getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(Date dateEdition) {
		this.dateEdition = dateEdition;
	}

	@Override
	public String toString() {
		return id + ":" + titre + "=>" + auteur ;
	}

	public Livre(String titre, String auteur, Date dateEdition) {
		super();
		this.titre = titre;
		this.auteur = auteur;
		this.dateEdition = dateEdition;
	}
	

	public Livre(int id, String titre, String auteur, Date dateEdition) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.dateEdition = dateEdition;
	}

	public Livre() {
		super();
	}

}

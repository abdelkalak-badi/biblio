package com.iset.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

@Entity
	public class Etudiant  {
	
	    @Id 
	    private String Cin;
	    private String nom;
	    private String prenom;
	    @OneToOne 
		public Adresse adresse; 
	
		
		@JoinColumn (name="Classe")
		private Classe classe;

		@Temporal( TemporalType.DATE )
		private Date dateNaissance;
		
		@ManyToMany
		@JoinTable(name = "Etudiant_Livre",
		joinColumns = @JoinColumn(name = "EtudiantID"),
		inverseJoinColumns = @JoinColumn(name = "LivreID")
		)
		
		private List<Livre> Livres;

		public String getCin() {
			return Cin;
		}

		public void setCin(String cin) {
			Cin = cin;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public Adresse getAdresse() {
			return adresse;
		}

		public void setAdresse(Adresse adresse) {
			this.adresse = adresse;
		}

		public Classe getClasse() {
			return classe;
		}

		public void setClasse(Classe classe) {
			this.classe = classe;
		}

		public Date getDateNaissance() {
			return dateNaissance;
		}

		public void setDateNaissance(Date dateNaissance) {
			this.dateNaissance = dateNaissance;
		}

		public List<Livre> getLivres() {
			return Livres;
		}

		public void setLivres(List<Livre> livres) {
			Livres.addAll(livres);
		}

		public Etudiant(String cin, String nom, String prenom, Adresse adresse, Classe classe, Date dateNaissance) {
			super();
			Cin = cin;
			this.nom = nom;
			this.prenom = prenom;
			this.adresse = adresse;
			this.classe = classe;
			this.dateNaissance = dateNaissance;
		}

		@Override
		public String toString() {
			return nom + " " + prenom;
		}

		public Etudiant() {
			super();
		}



		
		
	}




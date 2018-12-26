package com.iset.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Adresse {
	
	@Id 
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String rue;
	private String Ville;
	private String Pays;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	public String getPays() {
		return Pays;
	}
	public void setPays(String pays) {
		Pays = pays;
	}
	public Adresse(int id, String rue, String ville, String pays) {
		super();
		this.id = id;
		this.rue = rue;
		Ville = ville;
		Pays = pays;
	}
	public Adresse() {
		super();
	}
	@Override
	public String toString() {
		return Pays+","+Ville+","+rue;
	}
	
	

}

package com.iset.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
	public class Etudiant_Livre
	    implements Serializable {
	 
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Column(name = "EtudiantID")
	    private String EtudiantID;
	 
	    @Column(name = "LivreID")
	    private int LivreID;

		public Etudiant_Livre(Object eL1, Object eL12) {
			super();
			EtudiantID = (String)eL1;
			LivreID = (Integer)eL12;
		}

		public Etudiant_Livre() {
			super();
		}

		public String getEtudiantID() {
			return EtudiantID;
		}

		public void setEtudiantID(String etudiantID) {
			EtudiantID = etudiantID;
		}

		public int getLivreID() {
			return LivreID;
		}

		public void setLivreID(int livreID) {
			LivreID = livreID;
		}

		@Override
		public String toString() {
			return EtudiantID + " --> " + LivreID ;
		}
	   
	 
	   
	    
}

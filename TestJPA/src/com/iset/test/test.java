package com.iset.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iset.dao.AdresseDao;
import com.iset.dao.ClasseDao;
import com.iset.dao.EtudiantDao;
import com.iset.dao.EtudiantLivreDao;
import com.iset.dao.LivreDao;
import com.iset.model.Adresse;
import com.iset.model.Classe;
import com.iset.model.Etudiant;
import com.iset.model.Etudiant_Livre;
import com.iset.model.Livre;

public class test {
	public static void main(String[] args) {
		Etudiant e = new Etudiant();
		EtudiantDao ed = new EtudiantDao();
		Livre l= new Livre();
		LivreDao ld = new LivreDao();
		l=ld.consulter(l, 4);
		e=ed.consulter(e, "09868485");
		EtudiantLivreDao eld=new EtudiantLivreDao();
		//eld.listerTous();
		for (Etudiant_Livre c12 : eld.SelectALL())
			System.out.println(c12);
	}
}


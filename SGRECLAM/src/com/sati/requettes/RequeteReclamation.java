package com.sati.requettes;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sati.model.AnneeScolaire;
import com.sati.model.Reclamation;

@Transactional
@Component
public class RequeteReclamation {
	
	@Autowired
	SessionFactory sessionFactory;

	public List<Reclamation> recupererReclamationbyEtudiant(String matriculeEtudiant, int codeAnnee){
	String query = "SELECT `reclamation`.*, `reclamation`.`CODE_ANNEE_SCOL` FROM `reclamation` WHERE ((`reclamation`.`MATRICULE_ETUDE` ='"+matriculeEtudiant+"') AND (`reclamation`.`CODE_ANNEE_SCOL` ='"+codeAnnee+"'))";
		List liste = getSessionFactory().getCurrentSession().createSQLQuery(query).addEntity(Reclamation.class).list();
		return liste;
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

}

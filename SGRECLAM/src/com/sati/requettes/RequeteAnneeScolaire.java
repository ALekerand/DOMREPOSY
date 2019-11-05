package com.sati.requettes;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sati.model.AnneeScolaire;

@Transactional
@Component
public class RequeteAnneeScolaire {
	
	@Autowired
	SessionFactory sessionFactory;

	public AnneeScolaire recupererDerniereAnneeScolaire(){
		String query =	"SELECT `annee_scolaire`.* FROM `annee_scolaire` ORDER BY `annee_scolaire`.`CODE_ANNEE_SCOL` DESC LIMIT 0 , 1";
		AnneeScolaire anneeScolaire = (AnneeScolaire) getSessionFactory().getCurrentSession().createSQLQuery(query).addEntity(AnneeScolaire.class).uniqueResult();
		return anneeScolaire;
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

}

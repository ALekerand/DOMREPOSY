package com.sati.requettes;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sati.model.AnneeScolaire;
import com.sati.model.Ecue;

@Transactional
@Component
public class RequeteEcue {
	
	@Autowired
	SessionFactory sessionFactory;

	public List<Ecue> recupererEcueparCode(String codeEcue){
	String query =	"SELECT `ecue`.* FROM `ecue` WHERE (`ecue`.`CODE_ECUE` ='"+codeEcue+"')";
		
		List liste = getSessionFactory().getCurrentSession().createSQLQuery(query).addEntity(Ecue.class).list();
		return liste;
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

}

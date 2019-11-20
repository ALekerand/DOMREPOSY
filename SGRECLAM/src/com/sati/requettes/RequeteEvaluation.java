package com.sati.requettes;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sati.model.Evaluation;

@Transactional
@Component
public class RequeteEvaluation {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	
	public List<Evaluation> recupEvaluationBySemestre(String codeSemestre){
		
	String query = "SELECT * FROM evaluation WHERE evaluation.CODE_SEMESTRE = '"+codeSemestre+"'";
		
		List liste = sessionFactory.getCurrentSession().createSQLQuery(query).addEntity(Evaluation.class).list();
		return liste;
		
	}
	
	
	
public List<Evaluation> recupEvaluationByAnneeScolaireAndEcue(String  codeEcue, int codeAnneeScol){
		
		String query = "SELECT* FROM evaluation WHERE evaluation.CODE_ANNEE_SCOL = '"+codeAnneeScol+"'AND evaluation.CODE_ECUE = '"+codeEcue+"'";
		
		 List lister = sessionFactory.getCurrentSession().createSQLQuery(query).addEntity(Evaluation.class).list();
		return lister;
		
	
}

}

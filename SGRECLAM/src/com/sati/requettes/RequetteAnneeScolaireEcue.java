/**
 * 
 */
package com.sati.requettes;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.sati.model.Evaluation;

/**
 * @author MACHELI
 *
 */
@Transactional
@Component
public class RequetteAnneeScolaireEcue {
	@Autowired
	SessionFactory sessionFactory;
	
	
	public List<Evaluation> recupEvaluationByAnneeScolaireAndEcue(String  codeEcue, int codeAnneeScol){
		
		String query = "SELECT* FROM evaluation WHERE evaluation.CODE_ANNEE_SCOL = '"+codeAnneeScol+"'AND evaluation.CODE_ECUE = '"+codeEcue+"'";
		
		 List lister = sessionFactory.getCurrentSession().createSQLQuery(query).addEntity(Evaluation.class).list();
		 		System.out.println("==========la taille liste Evaluation est" +lister.size());
		return lister;
		
	}

}

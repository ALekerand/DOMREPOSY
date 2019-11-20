/**
 * 
 */
package com.sati.requettes;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sati.model.Enseignant;
import com.sati.model.Enseigner;

/**
 * @author MACHELI
 *
 */

@Transactional
@Component
public class RequetteEnseigner {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	/**
	 * @author MACHELIs
	 * Cette méthode exécute une requete qui nous retoure la liste des Enseigner sur une année scolaires
	 * 
	 * @param
	 * @return liste
	 */
	public List<Enseigner> RecupEnseignerByAnneeScol(int codeAnneeScol){
	
		// La requete dans mySql
		String query = "SELECT * FROM `enseigner` WHERE enseigner.CODE_ANNEE_SCOL ="+ codeAnneeScol+"";
		List liste = sessionFactory.getCurrentSession().createSQLQuery(query).addEntity(Enseigner.class).list();	
		
			System.out.println("taille de la liste enseigner------"+liste.size());
		return liste ;
		
		
		
		
		
	}
	

	public List<Enseigner> RecupEnseignerByAnneeScolEnseignant(String matriculeEnsei, int codeAnneeScol){
		
		String query = "SELECT `enseigner`.* FROM `enseigner` WHERE `enseigner`.`CODE_ANNEE_SCOL` = '"+codeAnneeScol+"' AND `enseigner`.`MATRICULE_ENSEI` = '"+matriculeEnsei+"'";
		List lister = sessionFactory.getCurrentSession().createSQLQuery(query).addEntity(Enseigner.class).list();
		return lister ;
		
		
	}

}

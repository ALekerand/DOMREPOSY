/**
 * 
 */
package com.sati.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sati.model.AnneeScolaire;
import com.sati.model.Ecue;
import com.sati.model.Enseigner;
import com.sati.model.Evaluation;
import com.sati.model.Reclamation;
import com.sati.model.UserAuthentication;
import com.sati.requettes.RequeteAnneeScolaire;
import com.sati.requettes.RequeteEvaluation;
import com.sati.requettes.RequeteReclamation;
import com.sati.requettes.RequeteUtilisateur;
import com.sati.requettes.RequetteEnseigner;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
@Scope("session")
public class ConsultReclamController {
	
@Autowired
Iservice service;

@Autowired
RequetteEnseigner requetteEnseigner;

@Autowired
RequeteAnneeScolaire requeteAnneeScolaire;
 @Autowired 
RequeteUtilisateur requeteUtilisateur;
 @Autowired
 RequeteEvaluation requeteEvaluation;
	 

private List<Evaluation> listEvaluation = new ArrayList<Evaluation>();
private List<Ecue>listEcue = new ArrayList<Ecue>();
private List<Reclamation> listReclamation = new ArrayList<>();
private String codeEcue;

private UserAuthentication user ;
private AnneeScolaire anneeScolaire;

@PostConstruct
public void initialiser(){
	System.out.println("========== methode Initialiser");
	 user = (UserAuthentication)requeteUtilisateur.recuperUser().get(0);
	 anneeScolaire = requeteAnneeScolaire.recupererDerniereAnneeScolaire();
	 chargerListEcue();
}

public List<Reclamation> founirListReclamation(){
	System.out.println("========== je suis dans la methode");
	List<Evaluation> ListEvaluation = requeteEvaluation.recupEvaluationByAnneeScolaireAndEcue(codeEcue, anneeScolaire.getCodeAnneeScol());
	
	for (Evaluation evaluation : ListEvaluation) {
		listReclamation.addAll(evaluation.getReclamations());
	}
	
	System.out.println("========== Fin methode");
	
	return listReclamation;
	
	
	
}

public List<Ecue> chargerListEcue(){
		  List<Enseigner> listEnseigner = requetteEnseigner.RecupEnseignerByAnneeScolEnseignant(user.getMatriculeActeur(), anneeScolaire.getCodeAnneeScol() );
		  
		  for (Enseigner enseigner : listEnseigner) {
		  listEcue.add(enseigner.getEcue());
		  
		  }
		 
	return listEcue;
}









public List<Evaluation> getListEvaluation() {
 listEvaluation = service.getObjects("Evaluation");
	return listEvaluation;
}
public void setListEvaluation(List<Evaluation> listEvaluation) {
	this.listEvaluation = listEvaluation;
}
public List<Ecue> getListEcue() {
	return listEcue;
}
public void setListEcue(List<Ecue> listEcue) {
	this.listEcue = listEcue;
}
public String getCodeEcue() {
	return codeEcue;
}
public void setCodeEcue(String codeEcue) {
	this.codeEcue = codeEcue;
}

public List<Reclamation> getListReclamation() {
	return listReclamation;
}

public void setListReclamation(List<Reclamation> listReclamation) {
	this.listReclamation = listReclamation;
}




	

}

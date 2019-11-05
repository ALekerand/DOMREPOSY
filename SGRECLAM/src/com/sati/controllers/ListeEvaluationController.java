/**
 * 
 */
package com.sati.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sati.model.AnneeScolaire;
import com.sati.model.Ecue;
import com.sati.model.Evaluation;
import com.sati.model.TypeEvaluation;
import com.sati.requettes.RequetteAnneeScolaireEcue;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
public class ListeEvaluationController {
	
@Autowired
Iservice service;

@Autowired
RequetteAnneeScolaireEcue requetteAnneeScolaireEcue;

private Evaluation evaluation = new Evaluation();
private List<Evaluation> listEvaluation = new ArrayList<Evaluation>();
private Evaluation selectedEvaluation = new Evaluation();
private AnneeScolaire anneeScolaire = new AnneeScolaire();
private List<AnneeScolaire> listAnneeScolaire = new ArrayList<AnneeScolaire>();
private AnneeScolaire choisiAnneeScolaire = new AnneeScolaire();
private Ecue ecue = new Ecue();
private List<Ecue> listEcue = new ArrayList<Ecue>();
private Ecue choisiEcue = new Ecue();
private TypeEvaluation typeEvaluation = new TypeEvaluation();
private List<TypeEvaluation> listTypeEvaluation = new ArrayList<TypeEvaluation>();
private String codeEcue;
private int codeAnneeScol;


public void chargerListEvaluation() {
		System.out.println("=============== je suis en debut de m�thode");
	listEvaluation = requetteAnneeScolaireEcue.recupEvaluationByAnneeScolaireAndEcue(codeEcue, codeAnneeScol); 
	System.out.println("=================je suis en fin de m�thode");
	
}

public void info(String monMessage) {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", monMessage));
}

public void error() {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
}

public void annuler() {
evaluation.setCodeEvaluation("");
evaluation.setLibeleEvaluation("");
setCodeEcue(null);
setCodeAnneeScol(0);
}

public void modifier() {
 service.updateObject(evaluation);
 annuler();
 info("Modification effectu� avec succ�s!");
}






public Evaluation getEvaluation() {
	return evaluation;
}

public void setEvaluation(Evaluation evaluation) {
	this.evaluation = evaluation;
}

public List<Evaluation> getListEvaluation() {
	return listEvaluation;
}

public void setListEvaluation(List<Evaluation> listEvaluation) {
	this.listEvaluation = listEvaluation;
}

public Evaluation getSelectedEvaluation() {
	
	return selectedEvaluation;
}

public void setSelectedEvaluation(Evaluation selectedEvaluation) {
	this.selectedEvaluation = selectedEvaluation;
}

public AnneeScolaire getAnneeScolaire() {
	return anneeScolaire;
}

public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
	this.anneeScolaire = anneeScolaire;
}

public List<AnneeScolaire> getListAnneeScolaire() {
	listAnneeScolaire = service.getObjects("AnneeScolaire");
	System.out.println("======= La liste des ann�eScolires:"+ listAnneeScolaire.size() );
	return listAnneeScolaire;
}

public void setListAnneeScolaire(List<AnneeScolaire> listAnneeScolaire) {
	this.listAnneeScolaire = listAnneeScolaire;
}

public AnneeScolaire getChoisiAnneeScolaire() {
	return choisiAnneeScolaire;
}

public void setChoisiAnneeScolaire(AnneeScolaire choisiAnneeScolaire) {
	this.choisiAnneeScolaire = choisiAnneeScolaire;
}

public Ecue getEcue() {
	return ecue;
}

public void setEcue(Ecue ecue) {
	this.ecue = ecue;
}
public List<Ecue> getListEcue() {
	listEcue = service.getObjects("Ecue");
	return listEcue;
}

public void setListEcue(List<Ecue> listEcue) {
	this.listEcue = listEcue;
}

public Ecue getChoisiEcue() {
	return choisiEcue;
}

public void setChoisiEcue(Ecue choisiEcue) {
	this.choisiEcue = choisiEcue;
}

public String getCodeEcue() {
	return codeEcue;
}

public void setCodeEcue(String codeEcue) {
	this.codeEcue = codeEcue;
}

public int getCodeAnneeScol() {
	return codeAnneeScol;
}

public void setCodeAnneeScol(int codeAnneeScol) {
	this.codeAnneeScol = codeAnneeScol;
}


public TypeEvaluation getTypeEvaluation() {
	return typeEvaluation;
}

public void setTypeEvaluation(TypeEvaluation typeEvaluation) {
	this.typeEvaluation = typeEvaluation;
}

public List<TypeEvaluation> getListTypeEvaluation() {
	
	listTypeEvaluation = service.getObjects("TypeEvaluation");
	
	return listTypeEvaluation;
}

public void setListTypeEvaluation(List<TypeEvaluation> listTypeEvaluation) {
	this.listTypeEvaluation = listTypeEvaluation;
}

}

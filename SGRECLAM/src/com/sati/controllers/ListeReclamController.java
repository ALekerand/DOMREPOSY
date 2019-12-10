/**
 * 
 */
package com.sati.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sati.model.Ecue;
import com.sati.model.Evaluation;
import com.sati.model.Reclamation;
import com.sati.requettes.RequeteEvaluation;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
public class ListeReclamController {
	
	@Autowired
	Iservice service;
	@Autowired
	RequeteEvaluation requeteEvaluation;
	
	
	private List<Reclamation> listReclamation = new ArrayList<Reclamation>();
	private List<Ecue> listEcue = new ArrayList<Ecue>();
	private List<Evaluation> listEvaluation = new ArrayList<>();
	private Evaluation selectEvaluation = new Evaluation();
	private int codeAnneeScol;
	private String codeEcue;
	
	
	
	
	
	public List<Evaluation> chargerEvaluation(){
		
		setListEvaluation(requeteEvaluation.recupEvaluationByAnneeScolaireAndEcue(codeEcue, codeAnneeScol));
		
		return listEvaluation;
		
		
	}
	
	
	public List<Reclamation> getListReclamation() {
		return listReclamation;
	}

	public void setListReclamation(List<Reclamation> listReclamation) {
		this.listReclamation = listReclamation;
	}

	public List<Ecue> getListEcue() {
		listEcue = service.getObjects("Ecue");
		return listEcue;
	}

	public void setListEcue(List<Ecue> listEcue) {
		this.listEcue = listEcue;
	}

	public List<Evaluation> getListEvaluation() {
		listEvaluation = service.getObjects("Evaluation");
		return listEvaluation;
	}

	public void setListEvaluation(List<Evaluation> listEvaluation) {
		this.listEvaluation = listEvaluation;
	}

	public Evaluation getSelectEvaluation() {
		return selectEvaluation;
	}

	public void setSelectEvaluation(Evaluation selectEvaluation) {
		this.selectEvaluation = selectEvaluation;
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

}

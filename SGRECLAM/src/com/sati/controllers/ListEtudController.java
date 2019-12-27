package com.sati.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sati.model.AnneeScolaire;
import com.sati.model.Ecue;
import com.sati.model.Etudiant;
import com.sati.model.Evaluation;
import com.sati.model.Reclamation;
import com.sati.requettes.RequeteAnneeScolaire;
import com.sati.requettes.RequeteEcue;
import com.sati.requettes.RequeteEvaluation;
import com.sati.service.Iservice;

@Component
@Scope("session")
public class ListEtudController {
	@Autowired
	Iservice service;
	
	@Autowired
	RequeteEcue requeteEcue;
	
	@Autowired
	RequeteAnneeScolaire requeteAnneeScolaire;
	
	@Autowired
	RequeteEvaluation requeteEvaluation;
	
	private Etudiant etudiant = new Etudiant();
	private List<Reclamation> listReclamation = new ArrayList<>();
	private List<Ecue> listEcue = new ArrayList<>();
	private List<Evaluation> listEvaluation = new ArrayList<>();
	private Ecue  choosedEcue = new Ecue();
	private int codeAnneeScol;
	private String codeEcue;
	private Evaluation selectedEvaluation = new Evaluation();
	private AnneeScolaire anneescolaire = new AnneeScolaire();
	
	@PostConstruct
	public void initialisation() {
		anneescolaire = requeteAnneeScolaire.recupererDerniereAnneeScolaire();		
	}
	
	
	public List<Evaluation> chargerListEvaluation(){
		System.out.println("je suis dans la methode");
	
		return listEvaluation = requeteEvaluation.recupEvaluationByAnneeScolaireAndEcue(codeEcue, anneescolaire.getCodeAnneeScol());
		
	}
	
	
	public List<Reclamation> chargerEtudiant(){
		listReclamation.clear();
		for (Reclamation varReclam : selectedEvaluation.getReclamations()) {
			listReclamation.add(varReclam);
		}
		System.out.println("====================taille liste reclamation"+listReclamation.size());
		return listReclamation;
		
		
	}
	


	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public List<Ecue> getListEcue() {
		listEcue = service.getObjects("Ecue");
		return listEcue;
	}

	public void setListEcue(List<Ecue> listEcue) {
		this.listEcue = listEcue;
	}

	public List<Evaluation> getListEvaluation() {
		return listEvaluation;
	}

	public void setListEvaluation(List<Evaluation> listEvaluation) {
		this.listEvaluation = listEvaluation;
	}

	



	public int getCodeAnneeScol() {
		return codeAnneeScol;
	}




	public void setCodeAnneeScol(int codeAnneeScol) {
		this.codeAnneeScol = codeAnneeScol;
	}




	public String getCodeEcue() {
		return codeEcue;
	}




	public void setCodeEcue(String codeEcue) {
		this.codeEcue = codeEcue;
	}


	public Ecue getChoosedEcue() {
		return choosedEcue;
	}


	public void setChoosedEcue(Ecue choosedEcue) {
		this.choosedEcue = choosedEcue;
	}

	public List<Reclamation> getListReclamation() {
		return listReclamation;
	}

	public void setListReclamation(List<Reclamation> listReclamation) {
		this.listReclamation = listReclamation;
	}


	public Evaluation getSelectedEvaluation() {
		return selectedEvaluation;
	}


	public void setSelectedEvaluation(Evaluation selectedEvaluation) {
		this.selectedEvaluation = selectedEvaluation;
	}



}

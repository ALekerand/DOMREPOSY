package com.sati.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.sati.model.Ecue;
import com.sati.model.Etudiant;
import com.sati.model.Evaluation;
import com.sati.requettes.RequeteEcue;
import com.sati.requettes.RequeteEvaluation;
import com.sati.service.Iservice;


public class ListEtudController {
	@Autowired
	Iservice service;
	
	@Autowired
	RequeteEcue requeteEcue;
	
	@Autowired
	RequeteEvaluation requeteEvaluation;
	
	private Etudiant etudiant = new Etudiant();
	private List<Etudiant> listEtudiant = new ArrayList<Etudiant>();
	private List<Ecue> listEcue = new ArrayList<>();
	private List<Evaluation> listEvaluation = new ArrayList<>();
	private Ecue  choisirEcue = new Ecue();
	private Evaluation choisirEvaluation = new Evaluation();
	private int codeAnneeScol;
	private String codeEcue;
	
	
	
	public List<Evaluation>choisirEvaluation(){
		
		setListEvaluation(requeteEvaluation.recupEvaluationByAnneeScolaireAndEcue(codeEcue, codeAnneeScol));
		
		return listEvaluation;
		
		
	}
	
	
	public List<Ecue> choisirEcue(){
		setListEcue(requeteEcue.recupererEcueparCode(codeEcue));
		return listEcue;
		
		
	}
	
	@PostConstruct
	public void initialiser() {
		choisirEvaluation();
		choisirEcue();
	}
	
	
	
	public Evaluation getChoisirEvaluation() {
		return choisirEvaluation;
	}

	public void setChoisirEvaluation(Evaluation choisirEvaluation) {
		this.choisirEvaluation = choisirEvaluation;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public List<Etudiant> getListEtudiant() {
		listEtudiant = service.getObjects("Etudiant");
		return listEtudiant;
	}

	public void setListEtudiant(List<Etudiant> listEtudiant) {

		this.listEtudiant = listEtudiant;
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

	public Ecue getChoisirEcue() {
		return choisirEcue;
	}

	public void setChoisirEcue(Ecue choisirEcue) {
		this.choisirEcue = choisirEcue;
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

}

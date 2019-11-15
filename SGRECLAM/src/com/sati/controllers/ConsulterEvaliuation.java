/**
 * 
 */
package com.sati.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import org.primefaces.component.commandbutton.CommandButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sati.model.AnneeScolaire;
import com.sati.model.Ecue;
import com.sati.model.Evaluation;
import com.sati.model.TypeEvaluation;
import com.sati.requettes.RequeteEvaluation;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
public class ConsulterEvaliuation {
	

		@Autowired
			Iservice service;
		@Autowired
		RequeteEvaluation requeteEvaluation;
		
		private List<Evaluation> listEvaluation;
		private List<AnneeScolaire> listAnneeScolaire = new ArrayList();
		private AnneeScolaire anneeScolaire = new AnneeScolaire();
		private List<Ecue> listEcue = new ArrayList<Ecue>();
		
		private String codeEcue;
		private int codeAnneeScol;

			

			
			public void enregistrer() {
				
				}
		

	public List<Evaluation>	chargerListEvaluation() {
		//Former le libellé de l'année scolaire
		System.out.println("=============== je suis en debut de méthode");
		setListEvaluation(requeteEvaluation.recupEvaluationByAnneeScolaireAndEcue(codeEcue, codeAnneeScol)); 
		System.out.println("=================je suis en fin de méthode");
		return listEvaluation;
		
	}

		public List<Evaluation> getListEvaluation() {
			return listEvaluation;
		}


		public void setListEvaluation(List<Evaluation> listEvaluation) {
			this.listEvaluation = listEvaluation;
		}



		public List<AnneeScolaire> getListAnneeScolaire() {
			return listAnneeScolaire = service.getObjects("AnneeScolaire");
		}



		public void setListAnneeScolaire(List<AnneeScolaire> listAnneeScolaire) {
			this.listAnneeScolaire = listAnneeScolaire;
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



		public AnneeScolaire getAnneeScolaire() {
			return anneeScolaire;
		}



		public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
			this.anneeScolaire = anneeScolaire;
		}



		public List<Ecue> getListEcue() {
			return listEcue = service.getObjects("Ecue");
		}



		public void setListEcue(List<Ecue> listEcue) {
			this.listEcue = listEcue;
		}


}

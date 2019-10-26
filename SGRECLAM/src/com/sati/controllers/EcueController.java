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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sati.model.AnneeScolaire;
import com.sati.model.Ecue;
import com.sati.model.Niveau;
import com.sati.model.NiveauEcue;
import com.sati.model.NiveauEtudiant;
import com.sati.model.Ue;
import com.sati.requettes.RequeteAnneeScolaire;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
@Scope("session")
public class EcueController {
	



	@Autowired
		Iservice service;
	
	@Autowired
	RequeteAnneeScolaire requeteAnneeScolaire;
	
		private Ecue ecue = new Ecue();
		private List<Ecue>listEcue = new ArrayList<Ecue>();
		private Ecue selectedEcue = new Ecue();
		private List<Ue> listUe = new ArrayList<Ue>();
		private Ue selectedUe = new Ue();
		private List<Niveau> listNiveau = new ArrayList<Niveau>();
		private Niveau selectedNiveau = new Niveau();
		private List<NiveauEcue> listNiveauEcue = new ArrayList<NiveauEcue>();
		private Niveau choosedNiveau = new Niveau();
		private int codeNiveau;
		private NiveauEcue niveauEcue = new NiveauEcue();		
		private CommandButton btnEnregistrer= new CommandButton();
		private CommandButton btnAnnuler = new CommandButton();
		private CommandButton btnModifier = new CommandButton();
		private AnneeScolaire anneeScolair;
		
		@PostConstruct
		public void initialiser() {
			btnModifier.setDisabled(true);
		}
		
		public void enregistrer() {
			//choosedNiveauEcue.setEcue(ecue);
		//	choosedNiveauEcue.setNiveau(niveau);
			
			//Completer l'objet avec ue qui migre
			ecue.setUe(selectedUe);
			
			//envoie en base de donnée
			service.addObject(ecue);
			
			
			
			//ENREGISTREMENT DE niveauEcue
			choosedNiveau = (Niveau) service.getObjectById(codeNiveau, "Niveau");
			niveauEcue.setNiveau(choosedNiveau);
			niveauEcue.setEcue(ecue);
			niveauEcue.setAnneeScolaire(requeteAnneeScolaire.recupererDerniereAnneeScolaire());
			service.addObject(niveauEcue);
			
			info("Eneregistrement éffectué avec succès!");
			annuler();
			
		}
		
		public void selectionnerLigne() {
			 ecue = selectedEcue;
			 btnEnregistrer.setDisabled(true);
			 btnModifier.setDisabled(false);
		}
		
		
		
		public void info(String monMessage) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", monMessage));
	    }
	
	 public void error() {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
	    }
	 
	 public void annuler() {
		 ecue.setCodeEcue("");
		 setChoosedNiveau(null);
		 setSelectedUe(null);
		 ecue.setLibelleEcue(null);
		btnModifier.setDisabled(true);
		btnEnregistrer.setDisabled(false);
	 }
	
	 public void modifier() {
		 service.updateObject(ecue);
		 annuler();
		 info("Modification effectué avec succés!");
	 }
	 
	 public Ecue getEcue() {
			return ecue;
		}

		public void set(Ecue ecue) {
			this.ecue = ecue;
		}

		public List<Ecue> getListEcue() {
			listEcue = service.getObjects("Ecue");
			return listEcue;
		}

		public void setListEcue(List<Ecue> listEcue) {
			this.listEcue = listEcue;
		}

		public Ecue getSelectedEcue() {
			return selectedEcue;
		}

		public void setSelectedEcue(Ecue selectedEcue) {
			this.selectedEcue = selectedEcue;
		}

		public CommandButton getBtnEnregistrer() {
			return btnEnregistrer;
		}

		public void setBtnEnregistrer(CommandButton btnEnregistrer) {
			this.btnEnregistrer = btnEnregistrer;
		}

		public CommandButton getBtnAnnuler() {
			return btnAnnuler;
		}

		public void setBtnAnnuler(CommandButton btnAnnuler) {
			this.btnAnnuler = btnAnnuler;
		}

		public CommandButton getBtnModifier() {
			return btnModifier;
		}

		public void setBtnModifier(CommandButton btnModifier) {
			this.btnModifier = btnModifier;
		}

		public List<Ue> getListUe() {
			listUe = service.getObjects("Ue");
			return listUe;
		}

		public void setListUe(List<Ue> listUe) {
			this.listUe = listUe;
		}

		public Ue getSelectedUe() {
			return selectedUe;
		}

		public void setSelectedUe(Ue selectedUe) {
			this.selectedUe = selectedUe;
		}

		public List<NiveauEcue> getListNiveauEcue() {
			listNiveauEcue = service.getObjects("NiveauEcue");
			return listNiveauEcue;
		}

		public void setListNiveauEcue(List<NiveauEcue> listNiveauEcue) {
			this.listNiveauEcue = listNiveauEcue;
		}

		
		public List<Niveau> getListNiveau() {
			listNiveau = service.getObjects("Niveau");
			return listNiveau;
		}

		public void setListNiveau(List<Niveau> listNiveau) {
			this.listNiveau = listNiveau;
		}

		public Niveau getSelectedNiveau() {
			return selectedNiveau;
		}

		public void setSelectedNiveau(Niveau selectedNiveau) {
			this.selectedNiveau = selectedNiveau;
		}

		public int getCodeNiveau() {
			return codeNiveau;
		}

		public void setCodeNiveau(int codeNiveau) {
			this.codeNiveau = codeNiveau;
		}

		public Niveau getChoosedNiveau() {
			return choosedNiveau;
		}

		public void setChoosedNiveau(Niveau choosedNiveau) {
			this.choosedNiveau = choosedNiveau;
		}

		public AnneeScolaire getAnneeScolair() {
			return anneeScolair;
		}

		public void setAnneeScolair(AnneeScolaire anneeScolair) {
			this.anneeScolair = anneeScolair;
		}



}

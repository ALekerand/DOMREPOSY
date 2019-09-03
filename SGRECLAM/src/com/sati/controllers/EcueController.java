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

import com.sati.model.Ecue;
import com.sati.model.Ue;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
public class EcueController {
	



	@Autowired
		Iservice service;
	
		private Ecue ecue = new Ecue();
		private List<Ecue>listEcue = new ArrayList<Ecue>();
		private Ecue selectedEcue = new Ecue();
		private List<Ue> listUe = new ArrayList<Ue>();
		private Ue selectedUe = new Ue();
		
		
		
		private CommandButton btnEnregistrer= new CommandButton();
		private CommandButton btnAnnuler = new CommandButton();
		private CommandButton btnModifier = new CommandButton();
		
		
		@PostConstruct
		public void initialiser() {
			btnModifier.setDisabled(true);
		}
		
		public void enregistrer() {
			//Completer l'objet avec ue qui migre
			ecue.setUe(selectedUe);
			
			//envoie en base de donnée
			service.addObject(ecue);
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
		 ecue.setCodeEcue(0);
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

}

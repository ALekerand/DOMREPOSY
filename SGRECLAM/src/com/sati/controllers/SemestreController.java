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

import com.sati.model.Semestre;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
    @Component
public class SemestreController {
	@Autowired
		Iservice service;
		private Semestre semestre = new Semestre();
		private List<Semestre>listSemestre = new ArrayList<Semestre>();
		private Semestre selectedSemestre = new  Semestre();
		
		
		private CommandButton btnEnregistrer = new CommandButton();
		private CommandButton btnAnnuler = new CommandButton();
		private CommandButton btnModifier = new CommandButton();
		
		
		@PostConstruct
		public void initialiser() {
			btnModifier.setDisabled(true);
		}
		
		public void enregistrer() {
			service.addObject(semestre);
			info("Eneregistrement éffectué avec succès!");
			annuler();
			
		}
		
		public void selectionnerLigne() {
			 semestre = selectedSemestre;
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
		semestre.setCodeSemestre("");
		semestre.setLibelleSemestre("");
		btnModifier.setDisabled(true);
		btnEnregistrer.setDisabled(false);
	 }
	
	 public void modifier() {
		 service.updateObject(semestre);
		 annuler();
		 info("Modification effectué avec succés!");
	 }
	 
	 
		
		
		
		public Semestre getSemestre() {
			return semestre;
		}
		public void setSemestre(Semestre semestre) {
			this.semestre = semestre;
		}
		public List<Semestre> getListSemestre() {
			listSemestre = service.getObjects("Semestre");
			return listSemestre;
		}
		public void setListSemestre(List<Semestre> listSemestre) {
			this.listSemestre = listSemestre;
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

		public Semestre getSelectedSemestre() {
			return selectedSemestre;
		}

		public void setSelectedSemestre(Semestre selectedSemestre) {
			this.selectedSemestre = selectedSemestre;
		}
		
}

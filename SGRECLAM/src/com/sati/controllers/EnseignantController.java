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
import com.sati.model.Enseignant;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
public class EnseignantController {

		@Autowired
			Iservice service;
			private Enseignant enseignant = new Enseignant();
			private List<Enseignant>listEnseignant = new ArrayList<Enseignant>();
			private Enseignant selectedEnseignant = new Enseignant();
		
			private CommandButton btnEnregistrer1= new CommandButton();
			private CommandButton btnAnnuler = new CommandButton();
			private CommandButton btnModifier1 = new CommandButton();
			
			
			@PostConstruct
			public void initialiser() {
				btnModifier1.setDisabled(true);
			}
			
			public void enregistrer() {
				service.addObject(enseignant);
				info("Eneregistrement �ffectu� avec succ�s!");
				annuler();
				
			}
			
			public void selectionnerLigne() {
				enseignant = selectedEnseignant;
				 btnEnregistrer1.setDisabled(true);
				 btnModifier1.setDisabled(false);
			}
			
			
			
			public void info(String monMessage) {
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", monMessage));
		    }
		
		 public void error() {
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
		    }
		 
		 public void annuler() {
			 enseignant.setEnseigners(null);
			 enseignant.setEnseigners(null);
			btnModifier1.setDisabled(true);
			btnEnregistrer1.setDisabled(false);
		 }
		
		 public void modifier() {
			 service.updateObject(enseignant);
			 annuler();
			 info("Modification effectu� avec succ�s!");
		 }

		public Enseignant getEnseignant() {
			return enseignant;
		}

		public void setEnseignant(Enseignant enseignant) {
			this.enseignant = enseignant;
		}

		public List<Enseignant> getListEnseignant() {
			listEnseignant = service.getObjects("Enseignant");
			return listEnseignant;
		}

		public Enseignant getSelectedEnseignant() {
			return selectedEnseignant;
		}

		public void setSelectedEnseignant(Enseignant selectedEnseignant) {
			this.selectedEnseignant = selectedEnseignant;
		}

		public CommandButton getBtnEnregistrer1() {
			return btnEnregistrer1;
		}

		public void setBtnEnregistrer1(CommandButton btnEnregistrer1) {
			this.btnEnregistrer1 = btnEnregistrer1;
		}

		public CommandButton getBtnAnnuler() {
			return btnAnnuler;
		}

		public void setBtnAnnuler(CommandButton btnAnnuler) {
			this.btnAnnuler = btnAnnuler;
		}

		public CommandButton getBtnModifier1() {
			return btnModifier1;
		}

		public void setBtnModifier1(CommandButton btnModifier1) {
			this.btnModifier1 = btnModifier1;
		}

	
}

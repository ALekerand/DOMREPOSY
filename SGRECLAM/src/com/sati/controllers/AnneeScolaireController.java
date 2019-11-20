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
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
public class AnneeScolaireController {

		@Autowired
			Iservice service;
			private AnneeScolaire anneeScolaire = new AnneeScolaire();
			private List<AnneeScolaire>listAnneeScolaire = new ArrayList<AnneeScolaire>();
			private AnneeScolaire selectedAnneeScolaire = new AnneeScolaire();
			
			
			
			
			
			
			private CommandButton btnEnregistrer = new CommandButton();
			private CommandButton btnAnnuler = new CommandButton();
			private CommandButton btnModifier = new CommandButton();
			
			
			@PostConstruct
			public void initialiser() {
				btnModifier.setDisabled(true);
			}
			
			public void enregistrer() {
				//Former le libellé de l'année scolaire
				anneeScolaire.setLibelleAnneeScol(anneeScolaire.getDebutAnneeScol()+"-"+anneeScolaire.getFinAnneeScol());
				
				
				service.addObject(anneeScolaire);
				info("Eneregistrement éffectué avec succès!");
				annuler();
				
			}
			
			public void selectionnerLigne() {
				anneeScolaire = selectedAnneeScolaire;
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
			 anneeScolaire.setCodeAnneeScol(0);
			 anneeScolaire.setDebutAnneeScol(null);
			 anneeScolaire.setFinAnneeScol(null);
			 anneeScolaire.setLibelleAnneeScol(null);
			btnModifier.setDisabled(true);
			btnEnregistrer.setDisabled(false);
		 }
		
		 public void modifier() {
			 service.updateObject(anneeScolaire);
			 annuler();
			 info("Modification effectué avec succés!");
		 }

		public AnneeScolaire getAnneeScolaire() {
			return anneeScolaire;
		}

		public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
			this.anneeScolaire = anneeScolaire;
		}

		public List<AnneeScolaire> getListAnneeScolaire() {
			listAnneeScolaire = service.getObjects("AnneeScolaire");
			return listAnneeScolaire;
		}

		public void setListAnneeScolaire(List<AnneeScolaire> listAnneeScolaire) {
			this.listAnneeScolaire = listAnneeScolaire;
		}

		public AnneeScolaire getSelectedAnneeScolaire() {
			return selectedAnneeScolaire;
		}

		public void setSelectedAnneeScolaire(AnneeScolaire selectedAnneeScolaire) {
			this.selectedAnneeScolaire = selectedAnneeScolaire;
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

		public CommandButton getBtnEnregistrer() {
			return btnEnregistrer;
		}

		public void setBtnEnregistrer(CommandButton btnEnregistrer) {
			this.btnEnregistrer = btnEnregistrer;
		}


}

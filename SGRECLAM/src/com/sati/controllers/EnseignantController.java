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

import com.sati.model.Ecue;
import com.sati.model.Enseignant;
import com.sati.model.Sexe;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
@Scope("session")
public class EnseignantController {

		@Autowired
			Iservice service;
			private Enseignant enseignant = new Enseignant();
			private List<Enseignant>listEnseignant = new ArrayList<Enseignant>();
			private Enseignant selectedEnseignant = new Enseignant();
			private List<Sexe> listSexe = new ArrayList<Sexe>();
			private Sexe choosedSexe = new Sexe();
			private int codeSexe;
			
			
			private CommandButton btnEnregistrer1= new CommandButton();
			private CommandButton btnAnnuler = new CommandButton();
			private CommandButton btnModifier1 = new CommandButton();
			
			
			@PostConstruct
			public void initialiser() {
				btnModifier1.setDisabled(true);
			}
			
			public void enregistrer() {
				choosedSexe = (Sexe) service.getObjectById(codeSexe, "Sexe");
				enseignant.setSexe(choosedSexe);
				service.addObject(enseignant);
				info("Eneregistrement éffectué avec succès!");
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
			 info("Modification effectué avec succés!");
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

		public List<Sexe> getListSexe() {
			listSexe = service.getObjects("Sexe");
			return listSexe;
		}

		public void setListSexe(List<Sexe> listSexe) {
			
			this.listSexe = listSexe;
		}

		public Sexe getChoosedSexe() {
			return choosedSexe;
		}

		public void setChoosedSexe(Sexe choosedSexe) {
			this.choosedSexe = choosedSexe;
		}

		public int getCodeSexe() {
			return codeSexe;
		}

		public void setCodeSexe(int codeSexe) {
			this.codeSexe = codeSexe;
		}

	
}

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

import com.sati.model.EtatReclamation;
import com.sati.model.TypeEvaluation;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
@Scope("session")
public class EtatReclamationController {
	@Autowired
	Iservice service;
	private EtatReclamation etatReclamation = new EtatReclamation();
	private List<EtatReclamation> listEtatReclamation = new ArrayList<EtatReclamation>();
	private EtatReclamation selectedEtatReclamation = new EtatReclamation();
	
	private CommandButton btnEnregistrer= new CommandButton();
	private CommandButton btnAnnuler = new CommandButton();
	private CommandButton btnModifier = new CommandButton();
	
	
	@PostConstruct
	public void initialiser() {
		btnModifier.setDisabled(true);
	} 
	
	public void enregistrer() {
		service.addObject(etatReclamation);
		annuler();
		 info("Enregistrement effectué avec succés!");
	}
	
	public void selectionnerLigne() {
		etatReclamation = selectedEtatReclamation;
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
	 etatReclamation.setLibelleEtatReclam(null);
	btnModifier.setDisabled(true);
	btnEnregistrer.setDisabled(false);
 }

 public void modifier() {
	 service.updateObject(etatReclamation);
	 annuler();
	 info("Modification effectué avec succés!");
 }
 
	
	public EtatReclamation getEtatReclamation() {
		return etatReclamation;
	}
	public void setEtatReclamation(EtatReclamation etatReclamation) {
		this.etatReclamation = etatReclamation;
	}
	
	public EtatReclamation getSelectedEtatReclamation() {
		return selectedEtatReclamation;
	}
	public void setSelectedEtatReclamation(EtatReclamation selectedEtatReclamation) {
		this.selectedEtatReclamation = selectedEtatReclamation;
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

	public List<EtatReclamation> getListEtatReclamation() {
		listEtatReclamation = service.getObjects("EtatReclamation");
		return listEtatReclamation;
	}

	public void setListEtatReclamation(List<EtatReclamation> listEtatReclamation) {
		this.listEtatReclamation = listEtatReclamation;
	}


}

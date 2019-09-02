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

import com.sati.model.RetourReclamation;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
public class RetourReclamationController {
	@Autowired
	Iservice service;
	private RetourReclamation retourReclamation = new RetourReclamation();
	private List<RetourReclamation> listRetourReclamation = new ArrayList<RetourReclamation>();
	private RetourReclamation selectedRetourReclamation = new RetourReclamation();
	
	private CommandButton btnEnregistrer= new CommandButton();
	private CommandButton btnAnnuler = new CommandButton();
	private CommandButton btnModifier = new CommandButton();
	
	@PostConstruct
	public void initialiser() {
		btnModifier.setDisabled(true);
	}
	
	public void enregistrer() {
		service.addObject(retourReclamation);
		info("Eneregistrement éffectué avec succès!");
		annuler();
		
	}
	
	public void selectionnerLigne() {
		retourReclamation = selectedRetourReclamation;
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
	 retourReclamation.setCodeRetourReclam(0);
	 retourReclamation.setLibelleRetourReclam(null);
	btnModifier.setDisabled(true);
	btnEnregistrer.setDisabled(false);
 }

 public void modifier() {
	 service.updateObject(retourReclamation);
	 annuler();
	 info("Modification effectué avec succés!");
 }

	
	public RetourReclamation getRetourReclamation() {
		return retourReclamation;
	}
	public void setRetourReclamation(RetourReclamation retourReclamation) {
		this.retourReclamation = retourReclamation;
	}
	public List<RetourReclamation> getListeRetourReclamation() {
		
		listRetourReclamation = service.getObjects("RetourReclamation");
		return listRetourReclamation;
	}
	public void setListeRetourReclamation(List<RetourReclamation> listRetourReclamation) {
		this.listRetourReclamation = listRetourReclamation;
	}
	public RetourReclamation getSelectedRetourReclamation() {
		return selectedRetourReclamation;
	}
	public void setSelectedRetourReclamation(RetourReclamation selectedRetourReclamation) {
		this.selectedRetourReclamation = selectedRetourReclamation;
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

}

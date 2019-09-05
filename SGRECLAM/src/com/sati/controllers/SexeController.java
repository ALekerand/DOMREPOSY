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
import com.sati.model.Sexe;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
public class SexeController {
	@Autowired
	Iservice service;
	private Sexe sexe = new Sexe();
	private List<Sexe> listSexe = new ArrayList<Sexe>();
	private Sexe selectedSexe = new Sexe();
	
	
	private CommandButton btnEnregistrer = new CommandButton();
	private CommandButton btnAnnuler = new CommandButton();
	private CommandButton btnModifier = new CommandButton();
	
	
	@PostConstruct
	public void initialiser() {
		btnModifier.setDisabled(true);
	}
	
	public void enregistrer() {
		service.addObject(sexe);
		info("Eneregistrement éffectué avec succès!");
		annuler();
		
	}
	
	public void selectionnerLigne() {
		 sexe = selectedSexe;
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
	 sexe.setCodeSexe(0);
	 sexe.setLibelleSexe(null);
	btnModifier.setDisabled(true);
	btnEnregistrer.setDisabled(false);
 }

 public void modifier() {
	 service.updateObject(sexe);
	 annuler();
	 info("Modification effectué avec succés!");
 }
	
	public Sexe getSexe() {
		return sexe;
	}
	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}
	public List<Sexe> getListSexe() {
		listSexe = service.getObjects("Sexe");
		return listSexe;
	}
	public void setListSexe(List<Sexe> listSexe) {
		this.listSexe = listSexe;
	}
	public Sexe getSelectedSexe() {
		return selectedSexe;
	}
	public void setSelectedSexe(Sexe selectedSexe) {
		this.selectedSexe = selectedSexe;
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

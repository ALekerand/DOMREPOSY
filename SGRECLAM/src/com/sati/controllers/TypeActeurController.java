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

import com.sati.model.TypeActeur;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
public class TypeActeurController {
	@Autowired
	Iservice service;
	
	private TypeActeur typeActeur = new TypeActeur();
	
	private List<TypeActeur> listTypeActeur = new ArrayList<TypeActeur>();
	
	private TypeActeur selectedTypeActeur = new TypeActeur();
	
	private CommandButton btnEnregistrer1 = new CommandButton();
	private CommandButton btnAnnuler = new CommandButton();
	private CommandButton btnModifier1 = new CommandButton();
	
	
	@PostConstruct
	public void initialiser() {
		btnModifier1.setDisabled(true);
	}
	
	public void enregistrer() {
		info("Eneregistrement éffectué avec succès!");
		annuler();
		
	}
	
	public void selectionnerLigne() {
		typeActeur = selectedTypeActeur;
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
	 
	btnModifier1.setDisabled(true);
	btnEnregistrer1.setDisabled(false);
 }

	

	public TypeActeur getTypeActeur() {
		return typeActeur;
	}

	public void setTypeActeur(TypeActeur typeActeur) {
		this.typeActeur = typeActeur;
	}

	public List<TypeActeur> getListTypeActeur() {
		
		listTypeActeur = service.getObjects("TypeActeur");
		return listTypeActeur;
	}

	public void setListTypeActeur(List<TypeActeur> listTypeActeur) {
		this.listTypeActeur = listTypeActeur;
	}

	public TypeActeur getSelectedTypeActeur() {
		return selectedTypeActeur;
	}

	public void setSelectedTypeActeur(TypeActeur selectedTypeActeur) {
		this.selectedTypeActeur = selectedTypeActeur;
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

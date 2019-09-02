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

import com.sati.model.TypeEvaluation;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
public class TypeEvaluationController {
	@Autowired
	Iservice service;
	private TypeEvaluation typeEvaluation = new TypeEvaluation();
	private List<TypeEvaluation>ListTypeEvaluation = new ArrayList<TypeEvaluation>();
	private TypeEvaluation selectedTypeEvaluation = new TypeEvaluation();
	
	
	private CommandButton btnEnregistre= new CommandButton();
	private CommandButton btnAnnuler = new CommandButton();
	private CommandButton btnModifie = new CommandButton();
	
	
	@PostConstruct
	public void initialiser() {
		btnModifie.setDisabled(true);
	} 
	
	public void enregistrer() {
		service.addObject(typeEvaluation);
		annuler();
		 info("Enregistrement effectué avec succés!");
	}
	
	public void selectionnerLigne() {
		typeEvaluation = selectedTypeEvaluation;
		 btnEnregistre.setDisabled(true);
		 btnModifie.setDisabled(false);
	}
	
	
	
	public void info(String monMessage) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", monMessage));
    }

 public void error() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
    }
 
 public void annuler() {
	 typeEvaluation.setCodeTypeEvalu(0);
	 typeEvaluation.setLibelleTypeEvalu(null);
	btnModifie.setDisabled(true);
	btnEnregistre.setDisabled(false);
 }

 public void modifier() {
	 service.updateObject(typeEvaluation);
	 annuler();
	 info("Modification effectué avec succés!");
 }
	
	

	public TypeEvaluation getTypeEvaluation() {
		return typeEvaluation;
	}

	public void setTypeEvaluation(TypeEvaluation typeEvaluation) {
		this.typeEvaluation = typeEvaluation;
	}


	public TypeEvaluation getSelectedTypeEvaluation() {
		return selectedTypeEvaluation;
	}

	public void setSelectedTypeEvaluation(TypeEvaluation selectedTypeEvaluation) {
		this.selectedTypeEvaluation = selectedTypeEvaluation;
	}

	public CommandButton getBtnEnregistre() {
		return btnEnregistre;
	}

	public void setBtnEnregistre(CommandButton btnEnregistre) {
		this.btnEnregistre = btnEnregistre;
	}

	public CommandButton getBtnAnnuler() {
		return btnAnnuler;
	}

	public void setBtnAnnuler(CommandButton btnAnnuler) {
		this.btnAnnuler = btnAnnuler;
	}

	public CommandButton getBtnModifie() {
		return btnModifie;
	}

	public void setBtnModifie(CommandButton btnModifie) {
		this.btnModifie = btnModifie;
	}

	public List<TypeEvaluation> getListTypeEvaluation() {
		ListTypeEvaluation = service.getObjects("TypeEvaluation");
		return ListTypeEvaluation;
	}

	public void setListTypeEvaluation(List<TypeEvaluation> listTypeEvaluation) {
		ListTypeEvaluation = listTypeEvaluation;
	}

	
}

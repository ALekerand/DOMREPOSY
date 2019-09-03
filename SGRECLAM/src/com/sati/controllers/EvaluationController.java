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
import com.sati.model.Evaluation;
import com.sati.model.TypeEvaluation;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
public class EvaluationController {
	
	@Autowired
	Iservice service;
	
	private Evaluation evaluation = new Evaluation();
	private List<Evaluation> listEvaluation = new ArrayList<Evaluation>();
	private Evaluation selectedEvaluation = new Evaluation();
	private List<Ecue> listEcue = new ArrayList<Ecue>();
	private List<TypeEvaluation> listTypeEvaluation = new ArrayList<>();
	private Ecue choisir = new Ecue();
	private TypeEvaluation choixTypeEvaluation = new TypeEvaluation();
	
	
	private CommandButton btnEnregistrer= new CommandButton();
	private CommandButton btnAnnuler = new CommandButton();
	private CommandButton btnModifier = new CommandButton();
	
	
	
	@PostConstruct
	public void initialiser() {
		btnModifier.setDisabled(true);
	}
	
	public void enregistrer() {
		
		//setter les objets qui migrent
		evaluation.setEcue(choisir);
		evaluation.setTypeEvaluation(choixTypeEvaluation);
		
		//Enregistrement en base de donné
		service.addObject(evaluation);
		info("Eneregistrement éffectué avec succès!");
		annuler();
		
	}
	
	public void selectionnerLigne() {
		evaluation = selectedEvaluation;
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
	 evaluation.setLibeleEvaluation("");
	btnModifier.setDisabled(true);
	btnEnregistrer.setDisabled(false);
 }

 public void modifier() {
	 service.updateObject(evaluation);
	 annuler();
	 info("Modification effectué avec succés!");
 }
 
	
	

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public List<Evaluation> getListEvaluation() {
		listEvaluation = service.getObjects("Evaluation");
		return listEvaluation;
	}

	public void setListEvaluation(List<Evaluation> listEvaluation) {
		this.listEvaluation = listEvaluation;
	}

	public Evaluation getSelectedEvaluation() {
		return selectedEvaluation;
	}

	public void setSelectedEvaluation(Evaluation selectedEvaluation) {
		this.selectedEvaluation = selectedEvaluation;
	}

	public CommandButton getBtnAnnuler() {
		return btnAnnuler;
	}

	public void setBtnAnnuler(CommandButton btnAnnuler) {
		this.btnAnnuler = btnAnnuler;
	}

	public CommandButton getBtnEnregistrer() {
		return btnEnregistrer;
	}

	public void setBtnEnregistrer(CommandButton btnEnregistrer) {
		this.btnEnregistrer = btnEnregistrer;
	}

	public List<Ecue> getListEcue() {
		listEcue = service.getObjects("Ecue");
		return listEcue;
	}

	public void setListEcue(List<Ecue> listEcue) {
		this.listEcue = listEcue;
	}

	public List<TypeEvaluation> getListTypeEvaluation() {
		listTypeEvaluation = service.getObjects("TypeEvaluation");
		return listTypeEvaluation;
	}

	public void setListTypeEvaluation(List<TypeEvaluation> listTypeEvaluation) {
		this.listTypeEvaluation = listTypeEvaluation;
	}

	public Ecue getChoisir() {
		return choisir;
	}

	public void setChoisir(Ecue choisir) {
		this.choisir = choisir;
	}

	public TypeEvaluation getChoixTypeEvaluation() {
		return choixTypeEvaluation;
	}

	public void setChoixTypeEvaluation(TypeEvaluation choixTypeEvaluation) {
		this.choixTypeEvaluation = choixTypeEvaluation;
	}
	
	public CommandButton getBtnModifier() {
		return btnModifier;
	}

	public void setBtnModifier(CommandButton btnModifier) {
		this.btnModifier = btnModifier;
	}

}

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
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sati.model.Ecue;
import com.sati.model.Evaluation;
import com.sati.model.MotifeReclamation;
import com.sati.model.Reclamation;
import com.sati.model.Sexe;
import com.sati.model.TypeEvaluation;
import com.sati.requettes.RequeteAnneeScolaire;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
@Scope("session")
public class ReclamationController {
	
	@Autowired
	Iservice service;
	
	@Autowired
	RequeteAnneeScolaire requeteAnneeScolaire;
	
	private Reclamation reclamation = new Reclamation();
	private List<Reclamation> listReclamation = new ArrayList<Reclamation>();
	private Reclamation selectedReclamation = new Reclamation();
	private List<Evaluation> listEvaluation = new ArrayList<Evaluation>();
	private Evaluation selectedEvaluation = new Evaluation();
	private List<MotifeReclamation> listMotifeReclamation = new ArrayList<MotifeReclamation>();
	private MotifeReclamation choisirMotifeReclamation = new MotifeReclamation(); 
	private int codeMotifReclam;
	private UploadedFile file;
	



	private CommandButton btnEnregistrer = new CommandButton();
	private CommandButton btnAnnuler = new CommandButton();
	private CommandButton btnModifier = new CommandButton();
	
	@PostConstruct
	public void initialiser() {
		btnModifier.setDisabled(true);
	}
	
	
	public void enregistrer() {
		choisirMotifeReclamation = (MotifeReclamation) service.getObjectById(codeMotifReclam, "MotifeReclamation");	
		reclamation.setEvaluation(selectedEvaluation);
		reclamation.setAnneeScolaire(requeteAnneeScolaire.recupererDerniereAnneeScolaire().get(0));
		
		service.addObject(reclamation);
		info("Eneregistrement éffectué avec succès!");
		annuler();
		
	}
	
	public void selectionnerLigne() {
		reclamation = selectedReclamation;
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
	 reclamation.setNumeroReclam(0);
	 reclamation.setDateRetourReclam(null);
	btnModifier.setDisabled(true);
	btnEnregistrer.setDisabled(false);
 }

 public void modifier() {
	 service.updateObject(reclamation);
	 annuler();
	 info("Modification effectué avec succés!");
 }
	

	public Reclamation getReclamation() {
		return reclamation;
	}

	public void setReclamation(Reclamation reclamation) {
		this.reclamation = reclamation;
	}

	public List<Reclamation> getListReclamation() {
		listReclamation = service.getObjects("Reclamation");
		System.out.println("tail de la liste:"+listReclamation.size());
		return listReclamation;
	}

	public void setListReclamation(List<Reclamation> listReclamation) {
		this.listReclamation = listReclamation;
	}

	public Reclamation getSelectedReclamation() {
		return selectedReclamation;
	}

	public void setSelectedReclamation(Reclamation selectedReclamation) {
		this.selectedReclamation = selectedReclamation;
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


	public List<MotifeReclamation> getListMotifeReclamation() {
		listMotifeReclamation = service.getObjects("MotifeReclamation");
		return listMotifeReclamation;
	}


	public void setListMotifeReclamation(List<MotifeReclamation> listMotifeReclamation) {
		this.listMotifeReclamation = listMotifeReclamation;
	}


	public MotifeReclamation getChoisirMotifeReclamation() {
		return choisirMotifeReclamation;
	}


	public void setChoisirMotifeReclamation(MotifeReclamation choisirMotifeReclamation) {
		this.choisirMotifeReclamation = choisirMotifeReclamation;
	}
	public int getCodeMotifReclam() {
		return codeMotifReclam;
	}


	public void setCodeMotifReclam(int codeMotifReclam) {
		this.codeMotifReclam = codeMotifReclam;
	}


	public UploadedFile getFile() {
		return file;
	}


	public void setFile(UploadedFile file) {
		this.file = file;
	}
}

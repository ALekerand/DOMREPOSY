/**
 * 
 */
package com.sati.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sati.model.Etudiant;
import com.sati.model.Evaluation;
import com.sati.model.MotifReclamation;
import com.sati.model.Reclamation;
import com.sati.requettes.RequeteAnneeScolaire;
import com.sati.requettes.RequeteUtilisateur;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
@Scope("session")
public class ReclamationAdminController {
	
	@Autowired
	Iservice service;
	
	@Autowired
	RequeteUtilisateur requeteUtilisateur;
	
	private Reclamation reclamation = new Reclamation();
	private List<Reclamation> listReclamation = new ArrayList<Reclamation>();
	private Reclamation selectedReclamation = new Reclamation();
	private List<Evaluation> listEvaluation = new ArrayList<Evaluation>();
	private Evaluation selectedEvaluation = new Evaluation();
	private List<MotifReclamation> listMotifeReclamation = new ArrayList<MotifReclamation>();
	private MotifReclamation choisirMotifeReclamation = new MotifReclamation(); 
	private int codeMotifReclam;
	private UploadedFile file;
	private Etudiant etudiant = new Etudiant();
	private String matricule; 
	



	private CommandButton btnEnregistrer = new CommandButton();
	private CommandButton btnAnnuler = new CommandButton();
	private CommandButton btnModifier = new CommandButton();
	
	@PostConstruct
	public void initialiser() {
		btnModifier.setDisabled(true);
	}
	
	
	public void rechercherEtudiant() {
		etudiant = (Etudiant) service.getObjectById(matricule, "Etudiant");
	}
	
	public void annulerRecherche() {
		matricule="";
		etudiant.setNomEtud("");
		etudiant.setPrenomsEtude("");
		etudiant.setDateNaissance(null);
	}
	
	
	public void enregistrer() {
		//Recuperation du motis
		choisirMotifeReclamation = (MotifReclamation) service.getObjectById(codeMotifReclam, "MotifReclamation");	
				
		//Ajout des éléments migrants dans l'ojet reclamation avant d'aller en base de données
		reclamation.setEtudiant(etudiant);
		reclamation.setMotifReclamation(choisirMotifeReclamation);
		reclamation.setEvaluation(selectedEvaluation);
		reclamation.setDateReclam(new Date());
		
		//Ebregistrement en BD
		service.addObject(reclamation);
		
		//Vider les ogjets liés à la page
		annulerRecherche();
		annuler();
		selectedEvaluation = null;
		codeMotifReclam = 0;
		info("Eneregistrement éffectué avec succès!");
		
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


	public List<MotifReclamation> getListMotifeReclamation() {
		listMotifeReclamation = service.getObjects("MotifReclamation");
		return listMotifeReclamation;
	}


	public void setListMotifeReclamation(List<MotifReclamation> listMotifeReclamation) {
		this.listMotifeReclamation = listMotifeReclamation;
	}


	public MotifReclamation getChoisirMotifeReclamation() {
		return choisirMotifeReclamation;
	}


	public void setChoisirMotifeReclamation(MotifReclamation choisirMotifeReclamation) {
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


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
}

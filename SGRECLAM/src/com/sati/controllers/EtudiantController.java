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
import com.sati.model.Etudiant;
import com.sati.model.Sexe;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
public class EtudiantController {
	@Autowired
	Iservice service;
	private Etudiant etudiant = new Etudiant();
	private List<Etudiant> listEtudiant = new ArrayList<Etudiant>();
	private Etudiant selectedEtudiant = new Etudiant();
	private List<Sexe> listSexe = new ArrayList<Sexe>();
	private Sexe choisirSexe = new Sexe();
	private int codeSexe;
	

	private CommandButton btnEnregistrer= new CommandButton();
	private CommandButton btnAnnuler = new CommandButton();
	private CommandButton btnModifier = new CommandButton();
	
	@PostConstruct
	public void initialiser() {
		btnModifier.setDisabled(true);
	}
	
	public void enregistrer() {
		choisirSexe = (Sexe) service.getObjectById(codeSexe, "Sexe");
		service.addObject(etudiant);
		info("Eneregistrement éffectué avec succès!");
		annuler();
		
	}
	
	public void selectionnerLigne() {
		etudiant = selectedEtudiant;
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
	 etudiant.setMatriculeEtude("");
	 etudiant.setNomEtud(null);
	 etudiant.setPrenomsEtude(null);
	 etudiant.setDateNaissance(null);
	btnModifier.setDisabled(true);
	btnEnregistrer.setDisabled(false);
 }

 public void modifier() {
	 service.updateObject(etudiant);
	 annuler();
	 info("Modification effectué avec succés!");
 }

	
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public List<Etudiant> getListEtudiant() {
		listEtudiant = service.getObjects("Etudiant");
		return listEtudiant;
	}
	public void setListEtudiant(List<Etudiant> listEtudiant) {
		this.listEtudiant = listEtudiant;
	}
	public Etudiant getSelectedEtudiant() {
		return selectedEtudiant;
	}
	public void setSelectedEtudiant(Etudiant selectedEtudiant) {
		this.selectedEtudiant = selectedEtudiant;
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

	public List<Sexe> getListSexe() {
		listSexe = service.getObjects("Sexe");
		return listSexe;
	}

	public void setListSexe(List<Sexe> listSexe) {
		this.listSexe = listSexe;
	}

	public Sexe getChoisirSexe() {
		return choisirSexe;
	}

	public void setChoisirSexe(Sexe choisirSexe) {
		this.choisirSexe = choisirSexe;
	}
	
	public int getCodeSexe() {
		return codeSexe;
	}

	public void setCodeSexe(int codeSexe) {
		this.codeSexe = codeSexe;
	}


}

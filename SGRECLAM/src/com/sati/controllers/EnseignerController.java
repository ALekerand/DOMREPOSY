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
import com.sati.model.Enseignant;
import com.sati.model.Enseigner;
import com.sati.model.NiveauEcue;
import com.sati.requettes.RequeteAnneeScolaire;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
public class EnseignerController {
	
	@Autowired
	Iservice service;
	
	//@Autowired
	//InitialController  initialController;
	
	@Autowired
	RequeteAnneeScolaire requeteAnneeScolaire;
	

private Enseigner enseigner = new Enseigner();

private List<Enseigner> listEnseigner = new ArrayList<Enseigner>();

private Enseigner selectedEnseigner = new Enseigner();

private List<NiveauEcue> listNiveauEcue = new ArrayList<NiveauEcue>();

private NiveauEcue choosedNiveauEcue = new NiveauEcue();

private List<Enseignant> listEnseignant  = new ArrayList<Enseignant>();

private List<Ecue> listEcue = new ArrayList<Ecue>();

private Ecue choosedEcue = new Ecue();

private Enseignant choosedEnseignant = new Enseignant();

public int codeNiveauEcue ;

private CommandButton btnValider = new CommandButton();
private CommandButton btnAnnuler = new CommandButton();


@PostConstruct
public void initialiser() {
	
	btnValider.setDisabled(true);
}

public void enregistrer() {
	choosedNiveauEcue = (NiveauEcue) service.getObjectById(codeNiveauEcue,"NiveauEcue");	
	
	
	enseigner.setEnseignant(choosedEnseignant);
	enseigner.setEcue(choosedEcue);
	enseigner.setAnneeScolaire(requeteAnneeScolaire.recupererDerniereAnneeScolaire());
	
	service.addObject(enseigner);
	info("Eneregistrement éffectué avec succès!");
	annuler();
	
}

public void selectionnerLigne() {
	enseigner = selectedEnseigner;
	 btnValider.setDisabled(true);
}



public void info(String monMessage) {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", monMessage));
}

public void error() {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
}

public void annuler() {
	enseigner.setCodeEnseigner(0);
	enseigner.setDateEnseigner(null);
btnValider.setDisabled(true);
}

public void modifier() {
 service.updateObject(enseigner);
 annuler();
 info("Modification effectué avec succés!");
}


public Enseigner getEnseigner() {
	return enseigner;
}

public void setEnseigner(Enseigner enseigner) {
	this.enseigner = enseigner;
}

public List<Enseigner> getListEnseigner() {
	return listEnseigner;
}

public void setListEnseigner(List<Enseigner> listEnseigner) {
	this.listEnseigner = listEnseigner;
}

public Enseigner getSelectedEnseigner() {
	return selectedEnseigner;
}

public void setSelectedEnseigner(Enseigner selectedEnseigner) {
	this.selectedEnseigner = selectedEnseigner;
}

public List<NiveauEcue> getListNiveauEcue() {
	return listNiveauEcue;
}

public void setListNiveauEcue(List<NiveauEcue> listNiveauEcue) {
	this.listNiveauEcue = listNiveauEcue;
}

public NiveauEcue getChoosedNiveauEcue() {
	return choosedNiveauEcue;
}

public void setChoosedNiveauEcue(NiveauEcue choosedNiveauEcue) {
	this.choosedNiveauEcue = choosedNiveauEcue;
}

public List<Enseignant> getListEnseignant() {
	
	listEnseignant = service.getObjects("Enseignant");
	return listEnseignant;
}

public void setListEnseignant(List<Enseignant> listEnseignant) {
	this.listEnseignant = listEnseignant;
}

public Enseignant getChoosedEnseignant() {
	return choosedEnseignant;
}

public void setChoosedEnseignant(Enseignant choosedEnseignant) {
	this.choosedEnseignant = choosedEnseignant;
}

public CommandButton getBtnValider() {
	return btnValider;
}

public void setBtnValider(CommandButton btnValider) {
	this.btnValider = btnValider;
}

public CommandButton getBtnAnnuler() {
	return btnAnnuler;
}

public void setBtnAnnuler(CommandButton btnAnnuler) {
	this.btnAnnuler = btnAnnuler;
}

public List<Ecue> getListEcue() {
	return listEcue;
}

public void setListEcue(List<Ecue> listEcue) {
	this.listEcue = listEcue;
}

public Ecue getChoosedEcue() {
	return choosedEcue;
}

public void setChoosedEcue(Ecue choosedEcue) {
	this.choosedEcue = choosedEcue;
}



}

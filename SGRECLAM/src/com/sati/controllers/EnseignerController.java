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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sati.model.AnneeScolaire;
import com.sati.model.Ecue;
import com.sati.model.Enseignant;
import com.sati.model.Enseigner;
import com.sati.model.Niveau;
import com.sati.model.NiveauEcue;
import com.sati.requettes.RequeteAnneeScolaire;
import com.sati.requettes.RequeteEcue;
import com.sati.requettes.RequetteEnseigner;
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
	
	@Autowired
	RequetteEnseigner requetteEnseigner;
	
	

private Enseigner enseigner = new Enseigner();

private List<Enseigner> listEnseigner = new ArrayList<Enseigner>();

private Enseigner selectedEnseigner = new Enseigner();

private List<Niveau> listNiveau = new ArrayList<Niveau>();

private Niveau choosedNiveau = new Niveau();

private List<Enseignant> listEnseignant  = new ArrayList<Enseignant>();

private List<Ecue> listEcue = new ArrayList<Ecue>();

private Ecue choosedEcue = new Ecue();

private Enseignant choosedEnseignant = new Enseignant();

private int codeNiveau ;
private AnneeScolaire anneeScolaire;

private CommandButton btnValider = new CommandButton();
private CommandButton btnAnnuler = new CommandButton();


@PostConstruct
public void initialiser() {
	
	btnValider.setDisabled(false);
	anneeScolaire = requeteAnneeScolaire.recupererDerniereAnneeScolaire();
}

public void enregistrer() {
	choosedNiveau = (Niveau) service.getObjectById(codeNiveau,"Niveau");	
	
	
	enseigner.setEnseignant(choosedEnseignant);
	enseigner.setEcue(choosedEcue);
	enseigner.setAnneeScolaire(anneeScolaire);
	enseigner.setDateEnseigner(new Date());
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
	setChoosedEnseignant(null);
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
	listEnseigner = service.getObjects("Enseigner");
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

public List<Niveau> getListNiveau() {
	
	listNiveau = service.getObjects("Niveau");
	return listNiveau;
}

public void setListNiveau(List<Niveau> listNiveau) {
	this.listNiveau = listNiveau;
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
	 //Cargement de toute la liste des ECUE
  listEcue = service.getObjects("Ecue");
  	//Création d'une liste tempon pour recuperer les Ecue affectées
  List<Ecue> listeTempon = new ArrayList<>();
  	//Recuperer la lister des enseigner afin d'avoir les ecue concernées
  List<Enseigner> listEnseigner = requetteEnseigner.RecupEnseignerByAnneeScol(anneeScolaire.getCodeAnneeScol());
  

  for (Ecue varEcue : listEcue) {
	for (Enseigner varEnseig : listEnseigner) {
			//Verifier si l'element dans la liste Ecue est le meme que que dans la liste Enseigner
		if (varEcue.getCodeEcue().equals(varEnseig.getEcue().getCodeEcue())) {
				//Si c'est le meme alors l'ajoute dans la liste tempon
			listeTempon.add(varEcue);
			break;
			
		}
		
	}
}
  	//Retirer la liste des objets dans la liste tempon de la grande liste des ECUEs afin de les aficher 
  listEcue.removeAll(listeTempon);
  
	return listEcue ;
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

public int getCodeNiveau() {
	return codeNiveau;
}

public void setCodeNiveau(int codeNiveau) {
	this.codeNiveau = codeNiveau;
}



}

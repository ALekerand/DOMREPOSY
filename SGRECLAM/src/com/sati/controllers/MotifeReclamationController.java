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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sati.model.MotifeReclamation;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
@Scope("session")
public class MotifeReclamationController {
	@Autowired
	Iservice service;
	
	private MotifeReclamation motifeReclamation = new MotifeReclamation();
	
	private List<MotifeReclamation>listMotifeReclamation = new ArrayList<MotifeReclamation>();
	
	private MotifeReclamation selectedMotifeReclamation = new MotifeReclamation();
	
	private CommandButton btnEnregistrer= new CommandButton();
	private CommandButton btnAnnuler = new CommandButton();
	private CommandButton btnModifier = new CommandButton();
	
	
	@PostConstruct
	public void initialiser() {
		btnModifier.setDisabled(true);
	}
	
	public void enregistrer() {
		service.addObject(motifeReclamation);
		info("Eneregistrement éffectué avec succès!");
		annuler();
		
	}
	
	public void selectionnerLigne() {
		motifeReclamation = selectedMotifeReclamation;
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
	 motifeReclamation.setCodeMotifReclam(0);
	 motifeReclamation.setLibelleMotifReclam(null);
	btnModifier.setDisabled(true);
	btnEnregistrer.setDisabled(false);
 }

 public void modifier() {
	 service.updateObject(motifeReclamation);
	 annuler();
	 info("Modification effectué avec succés!");
 }
	
	
	
	public MotifeReclamation getMotifeReclamation() {
		return motifeReclamation;
	}

	public void setMotifeReclamation(MotifeReclamation motifeReclamation) {
		this.motifeReclamation = motifeReclamation;
	}

	public List<MotifeReclamation> getListMotifeReclamation() {
		listMotifeReclamation = service.getObjects("MotifeReclamation");
		return listMotifeReclamation;
	}

	public void setListMotifeReclamation(List<MotifeReclamation> listMotifeReclamation) {
		this.listMotifeReclamation = listMotifeReclamation;
	}

	public MotifeReclamation getSelectedMotifeReclamation() {
		return selectedMotifeReclamation;
	}

	public void setSelectedMotifeReclamation(MotifeReclamation selectedMotifeReclamation) {
		this.selectedMotifeReclamation = selectedMotifeReclamation;
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

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


import com.sati.model.Niveau;
import com.sati.service.Iservice;

/**
 * @author HP
 *
 */
@Component
public class NiveauController {
	@Autowired
	Iservice service; // injection de servive pour les action en bd
	
	private Niveau niveau = new Niveau();
	private List<Niveau> listNiveau = new ArrayList<Niveau>();
	private Niveau selectNiveau =new Niveau();
	
	//controles des champs
	private CommandButton btnEnregistrer = new CommandButton();
	private CommandButton btnAnnuler = new CommandButton();
	private CommandButton btnModifier = new CommandButton();
	
	//Méthode
	
	@PostConstruct
	public void btnModifier() {
		btnModifier.setDisabled(true);
	}
	
	public void enregistrer() {
		service.addObject(niveau);
		info("Eneregistrement éffectué avec succès!");
		annuler();
		
	}
	
	public void selectionnerLigne() {
		 niveau = selectNiveau;
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
		niveau.setCodeNiveau(0);
		niveau.setLibeleNiveau(null);
		btnModifier.setDisabled(true);
		btnEnregistrer.setDisabled(false);
	 }
	
	 public void modifier() {
		 service.updateObject(niveau);
		 info("Modification effectué avec succés!");
	 }
	//Accesseurs
	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}


	public Niveau getSelectNiveau() {
		return selectNiveau;
	}


	public void setSelectNiveau(Niveau selectNiveau) {
		this.selectNiveau = selectNiveau;
	}

	public List<Niveau> getListNiveau() {
		
		listNiveau.isEmpty();
		listNiveau = service.getObjects("Niveau");
		return listNiveau;
	}

	public void setListNiveau(List<Niveau> listNiveau) {
		this.listNiveau = listNiveau;
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

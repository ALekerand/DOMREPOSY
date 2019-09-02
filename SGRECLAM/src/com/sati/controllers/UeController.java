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

import com.sati.model.Ue;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
public class UeController {

	@Autowired
		Iservice service;
		private Ue ue = new Ue();
		private List<Ue>listUe = new ArrayList<Ue>();
		private Ue selectedUe = new Ue();
		
		
		
		private CommandButton btnEnregistrer1= new CommandButton();
		private CommandButton btnAnnuler = new CommandButton();
		private CommandButton btnModifier1 = new CommandButton();
		
		
		@PostConstruct
		public void initialiser() {
			btnModifier1.setDisabled(true);
		}
		
		public void enregistrer() {
			service.addObject(ue);
			info("Eneregistrement éffectué avec succès!");
			annuler();
			
		}
		
		public void selectionnerLigne() {
			 ue = selectedUe;
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
		 ue.setCodeUe(0);
		ue.setLibeleUe("");
		btnModifier1.setDisabled(true);
		btnEnregistrer1.setDisabled(false);
	 }
	
	 public void modifier() {
		 service.updateObject(ue);
		 annuler();
		 info("Modification effectué avec succés!");
	 }

	public Ue getUe() {
		return ue;
	}

	public void setUe(Ue ue) {
		this.ue = ue;
	}

	public List<Ue> getListUe() {
		listUe = service.getObjects("Ue");
		return listUe;
	}

	public void setListUe(List<Ue> listUe) {
		this.listUe = listUe;
	}

	public Ue getSelectedUe() {
		return selectedUe;
	}

	public void setSelectedUe(Ue selectedUe) {
		this.selectedUe = selectedUe;
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

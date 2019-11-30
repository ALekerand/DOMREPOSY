/**
 * 
 */
package com.sati.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sati.model.EtatReclamation;
import com.sati.model.Reclamation;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
@Scope("session")
public class RecepReclamationController {
	@Autowired
	Iservice service;
	List<Reclamation> listReclamation = new ArrayList<Reclamation>();
	private Reclamation selectionReclam = new Reclamation();
	
	
	public void reclamRecevables(){
		
		selectionReclam.setEtatReclamation((EtatReclamation) service.getObjectById(1,"EtatReclamation"));
		service.updateObject(selectionReclam);
		
	}
	
	public void reclamationNonRecevable() {
		
		selectionReclam.setEtatReclamation((EtatReclamation) service.getObjectById(2, "EtatReclamation"));
		service.updateObject(selectionReclam);
	}
	
	
	
	public List<Reclamation> getListReclamation() {
		listReclamation = service.getObjects("Reclamation");
		return listReclamation;
	}
	public void setListReclamation(List<Reclamation> listReclamation) {
		this.listReclamation = listReclamation;
	}

	public Reclamation getSelectionReclam() {
		return selectionReclam;
	}

	public void setSelectionReclam(Reclamation selectionReclam) {
		this.selectionReclam = selectionReclam;
	}

	
	
	

}

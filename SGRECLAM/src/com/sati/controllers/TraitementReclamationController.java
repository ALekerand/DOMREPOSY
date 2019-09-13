/**
 * 
 */
package com.sati.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sati.model.Reclamation;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
@Scope("session")
public class TraitementReclamationController {
	@Autowired
	Iservice service;
	private List<Reclamation> listReclamation = new ArrayList<Reclamation>();
	
	public List<Reclamation> getListReclamation() {
		listReclamation = service.getObjects("Reclamation");
		return listReclamation;
	}
	public void setListReclamation(List<Reclamation> listReclamation) {
		this.listReclamation = listReclamation;
	}
	

}

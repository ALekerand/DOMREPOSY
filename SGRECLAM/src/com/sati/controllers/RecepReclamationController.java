/**
 * 
 */
package com.sati.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sati.model.Reclamation;
import com.sati.service.Iservice;

/**
 * @author MACHELI
 *
 */
@Component
public class RecepReclamationController {
	@Autowired
	Iservice service;
	List<Reclamation> listReclamation = new ArrayList<Reclamation>();
	
	
	
	public List<Reclamation> getListReclamation() {
		listReclamation = service.getObjects("Reclamation");
		return listReclamation;
	}
	public void setListReclamation(List<Reclamation> listReclamation) {
		this.listReclamation = listReclamation;
	}
	
	

}

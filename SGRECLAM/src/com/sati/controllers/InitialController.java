package com.sati.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sati.model.AnneeScolaire;
import com.sati.model.UserAuthentication;
import com.sati.requettes.RequeteAnneeScolaire;
import com.sati.requettes.RequeteUtilisateur;

@Component
@Scope("session")
public class InitialController {
	
	private UserAuthentication user = new UserAuthentication();
	private AnneeScolaire annneScolaire = new AnneeScolaire(); 
	
	@Autowired
	RequeteUtilisateur requeteUtilisateur;
	
	@Autowired
	RequeteAnneeScolaire requeteAnneScolaire;
	
	@PostConstruct
	public void demarrer() {
		chargerUtilisateur();
		chargerAnneeScolaire();
	}
	
	
	public void chargerUtilisateur() {
		 user = (UserAuthentication) requeteUtilisateur.recuperUser().get(0);
	}

	
	public AnneeScolaire chargerAnneeScolaire () {
		annneScolaire = requeteAnneScolaire.recupererDerniereAnneeScolaire();
		return annneScolaire;
		
	}
	
	
	public UserAuthentication getUser() {
		return user;
	}

	public void setUser(UserAuthentication user) {
		this.user = user;
	}


	public AnneeScolaire getAnnneScolaire() {
		return annneScolaire;
	}


	public void setAnnneScolaire(AnneeScolaire annneScolaire) {
		this.annneScolaire = annneScolaire;
	}
	
	


}

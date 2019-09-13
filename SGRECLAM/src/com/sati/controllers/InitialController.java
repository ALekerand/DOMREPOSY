package com.sati.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sati.model.UserAuthentication;
import com.sati.requettes.RequeteUtilisateur;

@Component
@Scope("session")
public class InitialController {
	
	private UserAuthentication user = new UserAuthentication();
	
	@Autowired
	RequeteUtilisateur requeteUtilisateur;
	
	@PostConstruct
	public void chargerUtilisateur() {
		 user = (UserAuthentication) requeteUtilisateur.recuperUser().get(0);
	}

	public UserAuthentication getUser() {
		return user;
	}

	public void setUser(UserAuthentication user) {
		this.user = user;
	}
	
	


}

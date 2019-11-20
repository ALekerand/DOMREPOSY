package com.sati.requettes;

import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sati.model.UserAuthentication;


@Transactional
@Component
@Scope("session")
public class RequeteUtilisateur {
	
	@Autowired
	private SessionFactory sessionFactory;

	// private Utilisateur utilisateur = new Utilisateur();

	/**
	 * Méthode pour l'utilisateur de la session
	 * 
	 * @return utilisateur
	 * @throws HibernateException
	 */
	
	/**
	 * 
	 * @param paramLogin
	 * @return 
	 * 
	 */
	


	
	 public String recupererLogin() {
	      User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      String name = user.getUsername(); //get logged in username
	      System.out.println("Retour de la requete:"+name);
	      return name;
	  }
	 
	 
	 public List recuperUser() {
	String query = "SELECT `user_authentication`.* FROM `user_authentication` WHERE (`user_authentication`.`USERNAME` ='"+ recupererLogin() +"')";
		 List list = getSessionFactory().getCurrentSession().createSQLQuery(query).addEntity(UserAuthentication.class).list();
		
		 System.out.println("======== User:"+list.get(0));
		 return list;
	 }
	 
	 
		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		

}

package com.sati.model;
// Generated 3 sept. 2019 14:31:19 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Etudiant generated by hbm2java
 */
@Entity
@Table(name = "etudiant", catalog = "sgreclam_bd")
public class Etudiant implements java.io.Serializable {

	private String matricule;
	private Sexe sexe;
	private String nom;
	private String prenoms;
	private Date dateNaissance;
	private Set<NiveauEtudiant> niveauEtudiants = new HashSet<NiveauEtudiant>(0);
	private Set<Reclamation> reclamations = new HashSet<Reclamation>(0);

	public Etudiant() {
	}

	public Etudiant(String matricule, Sexe sexe) {
		this.matricule = matricule;
		this.sexe = sexe;
	}

	public Etudiant(String matricule, Sexe sexe, String nom, String prenoms, Date dateNaissance,
			Set<NiveauEtudiant> niveauEtudiants, Set<Reclamation> reclamations) {
		this.matricule = matricule;
		this.sexe = sexe;
		this.nom = nom;
		this.prenoms = prenoms;
		this.dateNaissance = dateNaissance;
		this.niveauEtudiants = niveauEtudiants;
		this.reclamations = reclamations;
	}

	@Id

	@Column(name = "MATRICULE", unique = true, nullable = false, length = 15)
	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_SEXE", nullable = false)
	public Sexe getSexe() {
		return this.sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	@Column(name = "NOM", length = 25)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "PRENOMS", length = 50)
	public String getPrenoms() {
		return this.prenoms;
	}

	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_NAISSANCE", length = 10)
	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etudiant")
	public Set<NiveauEtudiant> getNiveauEtudiants() {
		return this.niveauEtudiants;
	}

	public void setNiveauEtudiants(Set<NiveauEtudiant> niveauEtudiants) {
		this.niveauEtudiants = niveauEtudiants;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etudiant")
	public Set<Reclamation> getReclamations() {
		return this.reclamations;
	}

	public void setReclamations(Set<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

}

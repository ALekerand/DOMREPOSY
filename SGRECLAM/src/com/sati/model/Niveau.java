package com.sati.model;
// Generated 20 ao�t 2019 15:27:17 by Hibernate Tools 5.2.8.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Niveau generated by hbm2java
 */
@Entity
@Table(name = "niveau", catalog = "sgreclam_bd")
public class Niveau implements java.io.Serializable {

	private int codeNiveau;
	private String libeleNiveau;
	private Set<NiveauEcue> niveauEcues = new HashSet<NiveauEcue>(0);
	private Set<NiveauEtudiant> niveauEtudiants = new HashSet<NiveauEtudiant>(0);

	public Niveau() {
	}

	public Niveau(int codeNiveau) {
		this.codeNiveau = codeNiveau;
	}

	public Niveau(int codeNiveau, String libeleNiveau, Set<NiveauEcue> niveauEcues,
			Set<NiveauEtudiant> niveauEtudiants) {
		this.codeNiveau = codeNiveau;
		this.libeleNiveau = libeleNiveau;
		this.niveauEcues = niveauEcues;
		this.niveauEtudiants = niveauEtudiants;
	}

	@Id
	@GenericGenerator(name="lekerand" , strategy="increment")
	@GeneratedValue(generator="lekerand")
	@Column(name = "CODE_NIVEAU", unique = true, nullable = false)
	public int getCodeNiveau() {
		return this.codeNiveau;
	}

	public void setCodeNiveau(int codeNiveau) {
		this.codeNiveau = codeNiveau;
	}

	@Column(name = "LIBELE_NIVEAU", length = 15)
	public String getLibeleNiveau() {
		return this.libeleNiveau;
	}

	public void setLibeleNiveau(String libeleNiveau) {
		this.libeleNiveau = libeleNiveau;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "niveau")
	public Set<NiveauEcue> getNiveauEcues() {
		return this.niveauEcues;
	}

	public void setNiveauEcues(Set<NiveauEcue> niveauEcues) {
		this.niveauEcues = niveauEcues;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "niveau")
	public Set<NiveauEtudiant> getNiveauEtudiants() {
		return this.niveauEtudiants;
	}

	public void setNiveauEtudiants(Set<NiveauEtudiant> niveauEtudiants) {
		this.niveauEtudiants = niveauEtudiants;
	}

}

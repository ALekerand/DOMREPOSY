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
 * Semestre generated by hbm2java
 */
@Entity
@Table(name = "semestre", catalog = "sgreclam_bd")
public class Semestre implements java.io.Serializable {

	private String codeSemestre;
	private String libelleSemestre;
	private Set<Reclamation> reclamations = new HashSet<Reclamation>(0);

	public Semestre() {
	}

	public Semestre(String codeSemestre) {
		this.codeSemestre = codeSemestre;
	}

	public Semestre(String codeSemestre, String libelleSemestre, Set<Reclamation> reclamations) {
		this.codeSemestre = codeSemestre;
		this.libelleSemestre = libelleSemestre;
		this.reclamations = reclamations;
	}

	@Id
	
	@Column(name = "CODE_SEMESTRE", unique = true, nullable = false, length = 3)
	public String getCodeSemestre() {
		return this.codeSemestre;
	}

	public void setCodeSemestre(String codeSemestre) {
		this.codeSemestre = codeSemestre;
	}

	@Column(name = "LIBELLE_SEMESTRE", length = 10)
	public String getLibelleSemestre() {
		return this.libelleSemestre;
	}

	public void setLibelleSemestre(String libelleSemestre) {
		this.libelleSemestre = libelleSemestre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "semestre")
	public Set<Reclamation> getReclamations() {
		return this.reclamations;
	}

	public void setReclamations(Set<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

}
package com.sati.model;
// Generated 19 oct. 2019 09:43:29 by Hibernate Tools 5.2.12.Final

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

/**
 * Evaluation generated by hbm2java
 */
@Entity
@Table(name = "evaluation", catalog = "sgreclam_bd")
public class Evaluation implements java.io.Serializable {

	private String codeEvaluation;
	private AnneeScolaire anneeScolaire;
	private Ecue ecue;
	private Semestre semestre;
	private TypeEvaluation typeEvaluation;
	private String libeleEvaluation;
	private Set<Reclamation> reclamations = new HashSet<Reclamation>(0);

	public Evaluation() {
	}

	public Evaluation(String codeEvaluation, AnneeScolaire anneeScolaire, Ecue ecue, Semestre semestre,
			TypeEvaluation typeEvaluation) {
		this.codeEvaluation = codeEvaluation;
		this.anneeScolaire = anneeScolaire;
		this.ecue = ecue;
		this.semestre = semestre;
		this.typeEvaluation = typeEvaluation;
	}

	public Evaluation(String codeEvaluation, AnneeScolaire anneeScolaire, Ecue ecue, Semestre semestre,
			TypeEvaluation typeEvaluation, String libeleEvaluation, Set<Reclamation> reclamations) {
		this.codeEvaluation = codeEvaluation;
		this.anneeScolaire = anneeScolaire;
		this.ecue = ecue;
		this.semestre = semestre;
		this.typeEvaluation = typeEvaluation;
		this.libeleEvaluation = libeleEvaluation;
		this.reclamations = reclamations;
	}

	@Id

	@Column(name = "CODE_EVALUATION", unique = true, nullable = false, length = 5)
	public String getCodeEvaluation() {
		return this.codeEvaluation;
	}

	public void setCodeEvaluation(String codeEvaluation) {
		this.codeEvaluation = codeEvaluation;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CODE_ANNEE_SCOL", nullable = false)
	public AnneeScolaire getAnneeScolaire() {
		return this.anneeScolaire;
	}

	public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CODE_ECUE", nullable = false)
	public Ecue getEcue() {
		return this.ecue;
	}

	public void setEcue(Ecue ecue) {
		this.ecue = ecue;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CODE_SEMESTRE", nullable = false)
	public Semestre getSemestre() {
		return this.semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CODE_TYPE_EVALU", nullable = false)
	public TypeEvaluation getTypeEvaluation() {
		return this.typeEvaluation;
	}

	public void setTypeEvaluation(TypeEvaluation typeEvaluation) {
		this.typeEvaluation = typeEvaluation;
	}

	@Column(name = "LIBELE_EVALUATION", length = 15)
	public String getLibeleEvaluation() {
		return this.libeleEvaluation;
	}

	public void setLibeleEvaluation(String libeleEvaluation) {
		this.libeleEvaluation = libeleEvaluation;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "evaluation")
	public Set<Reclamation> getReclamations() {
		return this.reclamations;
	}

	public void setReclamations(Set<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

}

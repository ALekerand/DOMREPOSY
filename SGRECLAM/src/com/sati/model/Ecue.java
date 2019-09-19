package com.sati.model;
// Generated 13 sept. 2019 18:13:52 by Hibernate Tools 5.2.12.Final

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
 * Ecue generated by hbm2java
 */
@Entity
@Table(name = "ecue", catalog = "sgreclam_bd")
public class Ecue implements java.io.Serializable {

	private String codeEcue;
	private Ue ue;
	private String libelleEcue;
	private Set<NiveauEcue> niveauEcues = new HashSet<NiveauEcue>(0);
	private Set<Evaluation> evaluations = new HashSet<Evaluation>(0);
	private Set<Enseigner> enseigners = new HashSet<Enseigner>(0);

	public Ecue() {
	}

	public Ecue(String codeEcue, Ue ue) {
		this.codeEcue = codeEcue;
		this.ue = ue;
	}

	public Ecue(String codeEcue, Ue ue, String libelleEcue, Set<NiveauEcue> niveauEcues, Set<Evaluation> evaluations,
			Set<Enseigner> enseigners) {
		this.codeEcue = codeEcue;
		this.ue = ue;
		this.libelleEcue = libelleEcue;
		this.niveauEcues = niveauEcues;
		this.evaluations = evaluations;
		this.enseigners = enseigners;
	}

	@Id

	@Column(name = "CODE_ECUE", unique = true, nullable = false, length = 15)
	public String getCodeEcue() {
		return this.codeEcue;
	}

	public void setCodeEcue(String codeEcue) {
		this.codeEcue = codeEcue;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CODE_UE", nullable = false)
	public Ue getUe() {
		return this.ue;
	}

	public void setUe(Ue ue) {
		this.ue = ue;
	}

	@Column(name = "LIBELLE_ECUE", length = 50)
	public String getLibelleEcue() {
		return this.libelleEcue;
	}

	public void setLibelleEcue(String libelleEcue) {
		this.libelleEcue = libelleEcue;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ecue")
	public Set<NiveauEcue> getNiveauEcues() {
		return this.niveauEcues;
	}

	public void setNiveauEcues(Set<NiveauEcue> niveauEcues) {
		this.niveauEcues = niveauEcues;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ecue")
	public Set<Evaluation> getEvaluations() {
		return this.evaluations;
	}

	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ecue")
	public Set<Enseigner> getEnseigners() {
		return this.enseigners;
	}

	public void setEnseigners(Set<Enseigner> enseigners) {
		this.enseigners = enseigners;
	}

}

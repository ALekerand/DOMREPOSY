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
 * Enseignant generated by hbm2java
 */
@Entity
@Table(name = "enseignant", catalog = "sgreclam_bd")
public class Enseignant implements java.io.Serializable {

	private String matriculeEnsei;
	private Sexe sexe;
	private String nomEnsei;
	private String prenomsEnsei;
	private String sexeEnsei;
	private Set<Enseigner> enseigners = new HashSet<Enseigner>(0);

	public Enseignant() {
	}

	public Enseignant(String matriculeEnsei, Sexe sexe) {
		this.matriculeEnsei = matriculeEnsei;
		this.sexe = sexe;
	}

	public Enseignant(String matriculeEnsei, Sexe sexe, String nomEnsei, String prenomsEnsei, String sexeEnsei,
			Set<Enseigner> enseigners) {
		this.matriculeEnsei = matriculeEnsei;
		this.sexe = sexe;
		this.nomEnsei = nomEnsei;
		this.prenomsEnsei = prenomsEnsei;
		this.sexeEnsei = sexeEnsei;
		this.enseigners = enseigners;
	}

	@Id

	@Column(name = "MATRICULE_ENSEI", unique = true, nullable = false, length = 10)
	public String getMatriculeEnsei() {
		return this.matriculeEnsei;
	}

	public void setMatriculeEnsei(String matriculeEnsei) {
		this.matriculeEnsei = matriculeEnsei;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_SEXE", nullable = false)
	public Sexe getSexe() {
		return this.sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	@Column(name = "NOM_ENSEI", length = 10)
	public String getNomEnsei() {
		return this.nomEnsei;
	}

	public void setNomEnsei(String nomEnsei) {
		this.nomEnsei = nomEnsei;
	}

	@Column(name = "PRENOMS_ENSEI", length = 25)
	public String getPrenomsEnsei() {
		return this.prenomsEnsei;
	}

	public void setPrenomsEnsei(String prenomsEnsei) {
		this.prenomsEnsei = prenomsEnsei;
	}

	@Column(name = "SEXE_ENSEI", length = 10)
	public String getSexeEnsei() {
		return this.sexeEnsei;
	}

	public void setSexeEnsei(String sexeEnsei) {
		this.sexeEnsei = sexeEnsei;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enseignant")
	public Set<Enseigner> getEnseigners() {
		return this.enseigners;
	}

	public void setEnseigners(Set<Enseigner> enseigners) {
		this.enseigners = enseigners;
	}

}

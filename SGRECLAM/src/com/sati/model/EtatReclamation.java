package com.sati.model;
// Generated 3 sept. 2019 14:31:19 by Hibernate Tools 5.2.12.Final

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
 * EtatReclamation generated by hbm2java
 */
@Entity
@Table(name = "etat_reclamation", catalog = "sgreclam_bd")
public class EtatReclamation implements java.io.Serializable {

	private String codeEtatReclam;
	private String libelleEtatReclam;
	private Set<Reclamation> reclamations = new HashSet<Reclamation>(0);

	public EtatReclamation() {
	}

	public EtatReclamation(String codeEtatReclam) {
		this.codeEtatReclam = codeEtatReclam;
	}

	public EtatReclamation(String codeEtatReclam, String libelleEtatReclam, Set<Reclamation> reclamations) {
		this.codeEtatReclam = codeEtatReclam;
		this.libelleEtatReclam = libelleEtatReclam;
		this.reclamations = reclamations;
	}

	@Id
	@GenericGenerator(name="lekerand" , strategy="increment")
	@GeneratedValue(generator="lekerand")
	@Column(name = "CODE_ETAT_RECLAM", unique = true, nullable = false, length = 3)
	public String getCodeEtatReclam() {
		return this.codeEtatReclam;
	}

	public void setCodeEtatReclam(String codeEtatReclam) {
		this.codeEtatReclam = codeEtatReclam;
	}

	@Column(name = "LIBELLE_ETAT_RECLAM", length = 10)
	public String getLibelleEtatReclam() {
		return this.libelleEtatReclam;
	}

	public void setLibelleEtatReclam(String libelleEtatReclam) {
		this.libelleEtatReclam = libelleEtatReclam;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etatReclamation")
	public Set<Reclamation> getReclamations() {
		return this.reclamations;
	}

	public void setReclamations(Set<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

}

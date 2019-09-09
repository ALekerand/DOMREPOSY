package com.sati.model;
// Generated 9 sept. 2019 14:39:29 by Hibernate Tools 5.2.12.Final

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
 * RetourReclamation generated by hbm2java
 */
@Entity
@Table(name = "retour_reclamation", catalog = "sgreclam_bd")
public class RetourReclamation implements java.io.Serializable {

	private int codeRetourReclam;
	private String libelleRetourReclam;
	private Set<Reclamation> reclamations = new HashSet<Reclamation>(0);

	public RetourReclamation() {
	}

	public RetourReclamation(int codeRetourReclam) {
		this.codeRetourReclam = codeRetourReclam;
	}

	public RetourReclamation(int codeRetourReclam, String libelleRetourReclam, Set<Reclamation> reclamations) {
		this.codeRetourReclam = codeRetourReclam;
		this.libelleRetourReclam = libelleRetourReclam;
		this.reclamations = reclamations;
	}

	@Id
	@GenericGenerator(name="lekerand" , strategy="increment")
	@GeneratedValue(generator="lekerand")
	@Column(name = "CODE_RETOUR_RECLAM", unique = true, nullable = false)
	public int getCodeRetourReclam() {
		return this.codeRetourReclam;
	}

	public void setCodeRetourReclam(int codeRetourReclam) {
		this.codeRetourReclam = codeRetourReclam;
	}

	@Column(name = "LIBELLE_RETOUR_RECLAM", length = 20)
	public String getLibelleRetourReclam() {
		return this.libelleRetourReclam;
	}

	public void setLibelleRetourReclam(String libelleRetourReclam) {
		this.libelleRetourReclam = libelleRetourReclam;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "retourReclamation")
	public Set<Reclamation> getReclamations() {
		return this.reclamations;
	}

	public void setReclamations(Set<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

}

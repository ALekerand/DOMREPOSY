package com.sati.model;
// Generated 20 ao�t 2019 15:27:17 by Hibernate Tools 5.2.8.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MotifeReclamation generated by hbm2java
 */
@Entity
@Table(name = "motife_reclamation", catalog = "sgreclam_bd")
public class MotifeReclamation implements java.io.Serializable {

	private int codeMotifReclam;
	private String libelleMotifReclam;
	private Set<Reclamation> reclamations = new HashSet<Reclamation>(0);

	public MotifeReclamation() {
	}

	public MotifeReclamation(int codeMotifReclam) {
		this.codeMotifReclam = codeMotifReclam;
	}

	public MotifeReclamation(int codeMotifReclam, String libelleMotifReclam, Set<Reclamation> reclamations) {
		this.codeMotifReclam = codeMotifReclam;
		this.libelleMotifReclam = libelleMotifReclam;
		this.reclamations = reclamations;
	}

	@Id

	@Column(name = "CODE_MOTIF_RECLAM", unique = true, nullable = false)
	public int getCodeMotifReclam() {
		return this.codeMotifReclam;
	}

	public void setCodeMotifReclam(int codeMotifReclam) {
		this.codeMotifReclam = codeMotifReclam;
	}

	@Column(name = "LIBELLE_MOTIF_RECLAM", length = 15)
	public String getLibelleMotifReclam() {
		return this.libelleMotifReclam;
	}

	public void setLibelleMotifReclam(String libelleMotifReclam) {
		this.libelleMotifReclam = libelleMotifReclam;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "motifeReclamation")
	public Set<Reclamation> getReclamations() {
		return this.reclamations;
	}

	public void setReclamations(Set<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

}

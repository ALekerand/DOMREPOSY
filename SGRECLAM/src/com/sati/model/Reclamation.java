package com.sati.model;
// Generated 3 sept. 2019 14:31:19 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * Reclamation generated by hbm2java
 */
@Entity
@Table(name = "reclamation", catalog = "sgreclam_bd")
public class Reclamation implements java.io.Serializable {

	private int numeroReclam;
	private AnneeScolaire anneeScolaire;
	private EtatReclamation etatReclamation;
	private Etudiant etudiant;
	private Evaluation evaluation;
	private MotifeReclamation motifeReclamation;
	private RetourReclamation retourReclamation;
	private Semestre semestre;
	private Date dateReclam;
	private Date dateRetourReclam;
	private Date dateEtatReclam;

	public Reclamation() {
	}

	public Reclamation(int numeroReclam, AnneeScolaire anneeScolaire, Etudiant etudiant, Evaluation evaluation,
			MotifeReclamation motifeReclamation, Semestre semestre) {
		this.numeroReclam = numeroReclam;
		this.anneeScolaire = anneeScolaire;
		this.etudiant = etudiant;
		this.evaluation = evaluation;
		this.motifeReclamation = motifeReclamation;
		this.semestre = semestre;
	}

	public Reclamation(int numeroReclam, AnneeScolaire anneeScolaire, EtatReclamation etatReclamation,
			Etudiant etudiant, Evaluation evaluation, MotifeReclamation motifeReclamation,
			RetourReclamation retourReclamation, Semestre semestre, Date dateReclam, Date dateRetourReclam,
			Date dateEtatReclam) {
		this.numeroReclam = numeroReclam;
		this.anneeScolaire = anneeScolaire;
		this.etatReclamation = etatReclamation;
		this.etudiant = etudiant;
		this.evaluation = evaluation;
		this.motifeReclamation = motifeReclamation;
		this.retourReclamation = retourReclamation;
		this.semestre = semestre;
		this.dateReclam = dateReclam;
		this.dateRetourReclam = dateRetourReclam;
		this.dateEtatReclam = dateEtatReclam;
	}

	@Id
	@GenericGenerator(name="lekerand" , strategy="increment")
	@GeneratedValue(generator="lekerand")
	@Column(name = "NUMERO_RECLAM", unique = true, nullable = false)
	public int getNumeroReclam() {
		return this.numeroReclam;
	}

	public void setNumeroReclam(int numeroReclam) {
		this.numeroReclam = numeroReclam;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_ANNEE_SCOL", nullable = false)
	public AnneeScolaire getAnneeScolaire() {
		return this.anneeScolaire;
	}

	public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_ETAT_RECLAM")
	public EtatReclamation getEtatReclamation() {
		return this.etatReclamation;
	}

	public void setEtatReclamation(EtatReclamation etatReclamation) {
		this.etatReclamation = etatReclamation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MATRICULE", nullable = false)
	public Etudiant getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_EVALUATION", nullable = false)
	public Evaluation getEvaluation() {
		return this.evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_MOTIF_RECLAM", nullable = false)
	public MotifeReclamation getMotifeReclamation() {
		return this.motifeReclamation;
	}

	public void setMotifeReclamation(MotifeReclamation motifeReclamation) {
		this.motifeReclamation = motifeReclamation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_RETOUR_RECLAM")
	public RetourReclamation getRetourReclamation() {
		return this.retourReclamation;
	}

	public void setRetourReclamation(RetourReclamation retourReclamation) {
		this.retourReclamation = retourReclamation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_SEMESTRE", nullable = false)
	public Semestre getSemestre() {
		return this.semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_RECLAM", length = 19)
	public Date getDateReclam() {
		return this.dateReclam;
	}

	public void setDateReclam(Date dateReclam) {
		this.dateReclam = dateReclam;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_RETOUR_RECLAM", length = 19)
	public Date getDateRetourReclam() {
		return this.dateRetourReclam;
	}

	public void setDateRetourReclam(Date dateRetourReclam) {
		this.dateRetourReclam = dateRetourReclam;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_ETAT_RECLAM", length = 19)
	public Date getDateEtatReclam() {
		return this.dateEtatReclam;
	}

	public void setDateEtatReclam(Date dateEtatReclam) {
		this.dateEtatReclam = dateEtatReclam;
	}

}

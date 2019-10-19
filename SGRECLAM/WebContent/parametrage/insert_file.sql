
INSERT INTO `ue` (`CODE_UE`, `LIBELE_UE`) VALUES
('ANG1', 'Anglais'),
('ELECT1', 'ELECTRICITE'),
('MATH1', 'Mathématique');

INSERT INTO `ecue` (`CODE_ECUE`, `CODE_UE`, `LIBELLE_ECUE`) VALUES
('MATH1_1', 'MATH1', 'Algèbre1'),
('MATH1_2', 'MATH1', 'Analyse1'),
('MATH_3', 'MATH1', 'Analyse3'),
('MATH_4', 'MATH1', 'Algèbre5'),
('MATH_5', 'MATH1', 'ALGEBRE 2'),
('MATH_6', 'MATH1', 'ALGEBRE3');


INSERT INTO `sexe` (`CODE_SEXE`, `LIBELLE_SEXE`) VALUES
(1, 'Masculin'),
(2, 'Féminin');

INSERT INTO `enseignant` (`MATRICULE_ENSEI`, `CODE_SEXE`, `NOM_ENSEI`, `PRENOMS_ENSEI`, `SEXE_ENSEI`) VALUES
('DOM1', 2, 'DOMI', 'flore', NULL),
('ESEIG001', 1, 'KOFFI', 'GEORGE', NULL),
('ESEIG002', 2, 'DOGO', 'FENICIENNE', NULL);



INSERT INTO `etudiant` (`MATRICULE_ETUDE`, `CODE_SEXE`, `NOM_ETUD`, `PRENOMS_ETUDE`, `DATE_NAISSANCE`) VALUES
('UVCIT001', 1, 'ADOU', 'Marcelin', '2019-09-10'),
('UVCIT002', 2, 'KOFFI', 'AMENAN REINE', '2019-09-16');



INSERT INTO `etat_reclamation` (`CODE_ETAT_RECLAM`, `LIBELLE_ETAT_RECLAM`) VALUES
(1, 'Recevable'),
(2, 'Non recevable');




INSERT INTO `motif_reclamation` (`CODE_MOTIF_RECLAM`, `LIBELLE_MOTIF_RECLAM`) VALUES
(1, 'Erreur sur note'),
(3, 'Omission note'),
(4, 'Erreur sujet');


INSERT INTO `niveau` (`CODE_NIVEAU`, `LIBELE_NIVEAU`) VALUES
(1, 'Licence1'),
(2, 'Licence2'),
(3, 'Licence3'),
(4, 'Master1'),
(5, 'Master2');


INSERT INTO `semestre` (`CODE_SEMESTRE`, `LIBELLE_SEMESTRE`) VALUES
('S1', 'Semestre 1'),
('S2', 'Semestre 2'),
('S3', 'Semestre 3'),
('S4', 'Semestre 4'),
('S5', 'Semestre 5'),
('S6', 'Semestre 6');


INSERT INTO `type_acteur` (`CODE_TYPE`, `LIBELLE_TYPE_ACT`) VALUES
(1, 'ADMINISTRATEUR'),
(2, 'ENSEIGNANT'),
(3, 'ETUDIANT');


INSERT INTO `type_evaluation` (`CODE_TYPE_EVALU`, `LIBELLE_TYPE_EVALU`) VALUES
(1, 'Devoir de semaine'),
(2, 'Examen S1'),
(3, 'Examen S2'),
(4, 'Examen rattrapage S1'),
(6, 'Examen rattrapage S2');


INSERT INTO `user_authentication` (`USER_ID`, `CODE_TYPE`, `USERNAME`, `PASSWORD`, `ENABLED`, `EMAIL`, `TELEPHONE_USER`, `NOM_USER`, `PRENOMS_USER`, `PHOTO_USER`, `MATRICULE_ACTEUR`) VALUES
(1, 1, 'admin', 'admin', 1, NULL, NULL, 'NIANGORAN', 'Aristhophane Kerandel', NULL, NULL),
(2, 2, 'enseignant', 'enseignant', 1, NULL, NULL, 'KOTCHI', 'PIERRE', NULL, NULL),
(3, 3, 'etudiant', 'etudiant', 1, NULL, NULL, 'ADOU', 'Marcelin', NULL, 'UVCIT001'),
(4, 3, 'etud', 'etud', 1, NULL, NULL, 'KOFFI', 'AMENAN', NULL, 'UVCIT002'),
(5, 2, 'domi', 'domi', 1, 'flore@gmail.com', '45670004', 'DOMI', 'flore', NULL, 'DOM1');



INSERT INTO `user_authorization` (`USER_ROLE_ID`, `USER_ID`, `ROLE`) VALUES
(1, 1, 'ROLE_ADMIN'),
(2, 2, 'ROLE_ENSEIGNANT'),
(3, 3, 'ROLE_ETUDIANT'),
(4, 4, 'ROLE_ETUDIANT'),
(5, 5, 'ROLE_ENSEIGNANT');


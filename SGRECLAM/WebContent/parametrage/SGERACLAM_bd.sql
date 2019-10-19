/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  19/10/2019 09:23:03                      */
/*==============================================================*/


drop table if exists ANNEE_SCOLAIRE;

drop table if exists ECUE;

drop table if exists ENSEIGNANT;

drop table if exists ENSEIGNER;

drop table if exists ETAT_RECLAMATION;

drop table if exists ETUDIANT;

drop table if exists EVALUATION;

drop table if exists MOTIF_RECLAMATION;

drop table if exists NIVEAU;

drop table if exists NIVEAU_ECUE;

drop table if exists NIVEAU_ETUDIANT;

drop table if exists RECLAMATION;

drop table if exists RETOUR_RECLAMATION;

drop table if exists SEMESTRE;

drop table if exists SEXE;

drop table if exists TYPE_ACTEUR;

drop table if exists TYPE_EVALUATION;

drop table if exists UE;

drop table if exists USER_AUTHENTICATION;

drop table if exists USER_AUTHORIZATION;

/*==============================================================*/
/* Table : ANNEE_SCOLAIRE                                       */
/*==============================================================*/
create table ANNEE_SCOLAIRE
(
   CODE_ANNEE_SCOL      int not null,
   DEBUT_ANNEE_SCOL     int,
   FIN_ANNEE_SCOL       int,
   LIBELLE_ANNEE_SCOL   char(10),
   ETAT_ANNEE           bool,
   primary key (CODE_ANNEE_SCOL)
);

/*==============================================================*/
/* Table : ECUE                                                 */
/*==============================================================*/
create table ECUE
(
   CODE_ECUE            char(15) not null,
   CODE_UE              char(15) not null,
   LIBELLE_ECUE         char(50),
   primary key (CODE_ECUE)
);

/*==============================================================*/
/* Table : ENSEIGNANT                                           */
/*==============================================================*/
create table ENSEIGNANT
(
   MATRICULE_ENSEI      char(10) not null,
   CODE_SEXE            int not null,
   NOM_ENSEI            char(10),
   PRENOMS_ENSEI        char(25),
   SEXE_ENSEI           char(10),
   primary key (MATRICULE_ENSEI)
);

/*==============================================================*/
/* Table : ENSEIGNER                                            */
/*==============================================================*/
create table ENSEIGNER
(
   CODE_ENSEIGNER       int not null,
   CODE_ECUE            char(15) not null,
   CODE_ANNEE_SCOL      int not null,
   MATRICULE_ENSEI      char(10) not null,
   DATE_ENSEIGNER       date,
   primary key (CODE_ENSEIGNER)
);

/*==============================================================*/
/* Table : ETAT_RECLAMATION                                     */
/*==============================================================*/
create table ETAT_RECLAMATION
(
   CODE_ETAT_RECLAM     int not null,
   LIBELLE_ETAT_RECLAM  char(20),
   primary key (CODE_ETAT_RECLAM)
);

/*==============================================================*/
/* Table : ETUDIANT                                             */
/*==============================================================*/
create table ETUDIANT
(
   MATRICULE_ETUDE      char(15) not null,
   CODE_SEXE            int not null,
   NOM_ETUD             char(25),
   PRENOMS_ETUDE        char(50),
   DATE_NAISSANCE       date,
   primary key (MATRICULE_ETUDE)
);

/*==============================================================*/
/* Table : EVALUATION                                           */
/*==============================================================*/
create table EVALUATION
(
   CODE_EVALUATION      char(5) not null,
   CODE_SEMESTRE        char(3) not null,
   CODE_ECUE            char(15) not null,
   CODE_ANNEE_SCOL      int not null,
   CODE_TYPE_EVALU      int not null,
   LIBELE_EVALUATION    char(15),
   primary key (CODE_EVALUATION)
);

/*==============================================================*/
/* Table : MOTIF_RECLAMATION                                    */
/*==============================================================*/
create table MOTIF_RECLAMATION
(
   CODE_MOTIF_RECLAM    int not null,
   LIBELLE_MOTIF_RECLAM char(15),
   primary key (CODE_MOTIF_RECLAM)
);

/*==============================================================*/
/* Table : NIVEAU                                               */
/*==============================================================*/
create table NIVEAU
(
   CODE_NIVEAU          int not null,
   LIBELE_NIVEAU        char(15),
   primary key (CODE_NIVEAU)
);

/*==============================================================*/
/* Table : NIVEAU_ECUE                                          */
/*==============================================================*/
create table NIVEAU_ECUE
(
   CODE_NIVEAU_ECUE     int not null,
   CODE_ANNEE_SCOL      int not null,
   CODE_NIVEAU          int not null,
   CODE_ECUE            char(15) not null,
   LIBELE_NIVEAU_ECUE   char(15),
   primary key (CODE_NIVEAU_ECUE)
);

/*==============================================================*/
/* Table : NIVEAU_ETUDIANT                                      */
/*==============================================================*/
create table NIVEAU_ETUDIANT
(
   CODE_NIVEAU_ETUD     int not null,
   CODE_NIVEAU          int not null,
   CODE_ANNEE_SCOL      int not null,
   MATRICULE_ETUDE      char(15) not null,
   DATE_NIVEAU_ETUD     date,
   primary key (CODE_NIVEAU_ETUD)
);

/*==============================================================*/
/* Table : RECLAMATION                                          */
/*==============================================================*/
create table RECLAMATION
(
   NUMERO_RECLAM        int not null,
   CODE_RETOUR_RECLAM   int,
   CODE_EVALUATION      char(5) not null,
   CODE_ETAT_RECLAM     int,
   MATRICULE_ETUDE      char(15) not null,
   CODE_MOTIF_RECLAM    int not null,
   DATE_RECLAM          datetime,
   DATE_RETOUR_RECLAM   datetime,
   DATE_ETAT_RECLAM     datetime,
   DETAIL_RECLAM        text,
   FICHIER_RECLAM       char(50),
   primary key (NUMERO_RECLAM)
);

/*==============================================================*/
/* Table : RETOUR_RECLAMATION                                   */
/*==============================================================*/
create table RETOUR_RECLAMATION
(
   CODE_RETOUR_RECLAM   int not null,
   LIBELLE_RETOUR_RECLAM char(20),
   primary key (CODE_RETOUR_RECLAM)
);

/*==============================================================*/
/* Table : SEMESTRE                                             */
/*==============================================================*/
create table SEMESTRE
(
   CODE_SEMESTRE        char(3) not null,
   LIBELLE_SEMESTRE     char(10),
   primary key (CODE_SEMESTRE)
);

/*==============================================================*/
/* Table : SEXE                                                 */
/*==============================================================*/
create table SEXE
(
   CODE_SEXE            int not null,
   LIBELLE_SEXE         char(15),
   primary key (CODE_SEXE)
);

/*==============================================================*/
/* Table : TYPE_ACTEUR                                          */
/*==============================================================*/
create table TYPE_ACTEUR
(
   CODE_TYPE            int not null,
   LIBELLE_TYPE_ACT     char(25),
   primary key (CODE_TYPE)
);

/*==============================================================*/
/* Table : TYPE_EVALUATION                                      */
/*==============================================================*/
create table TYPE_EVALUATION
(
   CODE_TYPE_EVALU      int not null,
   LIBELLE_TYPE_EVALU   char(20),
   primary key (CODE_TYPE_EVALU)
);

/*==============================================================*/
/* Table : UE                                                   */
/*==============================================================*/
create table UE
(
   CODE_UE              char(15) not null,
   LIBELE_UE            char(50),
   primary key (CODE_UE)
);

/*==============================================================*/
/* Table : USER_AUTHENTICATION                                  */
/*==============================================================*/
create table USER_AUTHENTICATION
(
   USER_ID              int not null,
   CODE_TYPE            int not null,
   USERNAME             char(15),
   PASSWORD             char(15),
   ENABLED              bool,
   EMAIL                char(50),
   TELEPHONE_USER       numeric(15,0),
   NOM_USER             char(25),
   PRENOMS_USER         char(50),
   PHOTO_USER           char(150),
   MATRICULE_ACTEUR     char(15),
   primary key (USER_ID)
);

/*==============================================================*/
/* Table : USER_AUTHORIZATION                                   */
/*==============================================================*/
create table USER_AUTHORIZATION
(
   USER_ROLE_ID         int not null,
   USER_ID              int,
   ROLE                 char(20),
   primary key (USER_ROLE_ID)
);

alter table ECUE add constraint FK_ASSOCIATION_10 foreign key (CODE_UE)
      references UE (CODE_UE) on delete restrict on update restrict;

alter table ENSEIGNANT add constraint FK_ASSOCIATION_21 foreign key (CODE_SEXE)
      references SEXE (CODE_SEXE) on delete restrict on update restrict;

alter table ENSEIGNER add constraint FK_ASSOCIATION_12 foreign key (CODE_ECUE)
      references ECUE (CODE_ECUE) on delete restrict on update restrict;

alter table ENSEIGNER add constraint FK_ASSOCIATION_13 foreign key (MATRICULE_ENSEI)
      references ENSEIGNANT (MATRICULE_ENSEI) on delete restrict on update restrict;

alter table ENSEIGNER add constraint FK_ASSOCIATION_14 foreign key (CODE_ANNEE_SCOL)
      references ANNEE_SCOLAIRE (CODE_ANNEE_SCOL) on delete restrict on update restrict;

alter table ETUDIANT add constraint FK_ASSOCIATION_22 foreign key (CODE_SEXE)
      references SEXE (CODE_SEXE) on delete restrict on update restrict;

alter table EVALUATION add constraint FK_APPARTENIR foreign key (CODE_ANNEE_SCOL)
      references ANNEE_SCOLAIRE (CODE_ANNEE_SCOL) on delete restrict on update restrict;

alter table EVALUATION add constraint FK_ASSOCIATION_8 foreign key (CODE_TYPE_EVALU)
      references TYPE_EVALUATION (CODE_TYPE_EVALU) on delete restrict on update restrict;

alter table EVALUATION add constraint FK_ASSOCIATION_9 foreign key (CODE_ECUE)
      references ECUE (CODE_ECUE) on delete restrict on update restrict;

alter table EVALUATION add constraint FK_AVOIR_LIEU foreign key (CODE_SEMESTRE)
      references SEMESTRE (CODE_SEMESTRE) on delete restrict on update restrict;

alter table NIVEAU_ECUE add constraint FK_ASSOCIATION_17 foreign key (CODE_NIVEAU)
      references NIVEAU (CODE_NIVEAU) on delete restrict on update restrict;

alter table NIVEAU_ECUE add constraint FK_ASSOCIATION_18 foreign key (CODE_ECUE)
      references ECUE (CODE_ECUE) on delete restrict on update restrict;

alter table NIVEAU_ECUE add constraint FK_ASSOCIATION_19 foreign key (CODE_ANNEE_SCOL)
      references ANNEE_SCOLAIRE (CODE_ANNEE_SCOL) on delete restrict on update restrict;

alter table NIVEAU_ETUDIANT add constraint FK_ASSOCIATION_15 foreign key (MATRICULE_ETUDE)
      references ETUDIANT (MATRICULE_ETUDE) on delete restrict on update restrict;

alter table NIVEAU_ETUDIANT add constraint FK_ASSOCIATION_16 foreign key (CODE_NIVEAU)
      references NIVEAU (CODE_NIVEAU) on delete restrict on update restrict;

alter table NIVEAU_ETUDIANT add constraint FK_ASSOCIATION_20 foreign key (CODE_ANNEE_SCOL)
      references ANNEE_SCOLAIRE (CODE_ANNEE_SCOL) on delete restrict on update restrict;

alter table RECLAMATION add constraint FK_ASSOCIATION_11 foreign key (CODE_MOTIF_RECLAM)
      references MOTIF_RECLAMATION (CODE_MOTIF_RECLAM) on delete restrict on update restrict;

alter table RECLAMATION add constraint FK_AVOIR foreign key (CODE_RETOUR_RECLAM)
      references RETOUR_RECLAMATION (CODE_RETOUR_RECLAM) on delete restrict on update restrict;

alter table RECLAMATION add constraint FK_COMPORTER foreign key (CODE_ETAT_RECLAM)
      references ETAT_RECLAMATION (CODE_ETAT_RECLAM) on delete restrict on update restrict;

alter table RECLAMATION add constraint FK_FAIRE foreign key (MATRICULE_ETUDE)
      references ETUDIANT (MATRICULE_ETUDE) on delete restrict on update restrict;

alter table RECLAMATION add constraint FK_LIER foreign key (CODE_EVALUATION)
      references EVALUATION (CODE_EVALUATION) on delete restrict on update restrict;

alter table USER_AUTHENTICATION add constraint FK_ETRE foreign key (CODE_TYPE)
      references TYPE_ACTEUR (CODE_TYPE) on delete restrict on update restrict;

alter table USER_AUTHORIZATION add constraint FK_AUTORISATION_AUTHENTIFICATION foreign key (USER_ID)
      references USER_AUTHENTICATION (USER_ID) on delete restrict on update restrict;


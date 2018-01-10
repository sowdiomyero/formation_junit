package sn.sonatel.formation.junit.model;

import java.util.Date;

/**
 * Created by ext_sow18 on 09/01/2018.
 */
public class Reservation {

    public enum STATUT{
        PENDING,ACCEPTED,PAYED,REJECTED,CANCELED, RESERVED
    }
    String id;
    String nom;
    String auteur;
    Date dateReservation;
    private STATUT statut;

    public Reservation( String nom, String auteur, Date dateReservation, STATUT statut) {
        this.nom = nom;
        this.auteur = auteur;
        this.dateReservation = dateReservation;
        this.statut = statut;
    }

    public Reservation(String id, String nom, String auteur, Date dateReservation, STATUT statut) {
        this.id = id;
        this.nom = nom;
        this.auteur = auteur;
        this.dateReservation = dateReservation;
        this.statut = statut;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public STATUT getStatut() {
        return statut;
    }

    public void setStatut(STATUT statut) {
        this.statut = statut;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entity;

/**
 *
 * @author mariem
 */

import java.util.Date;

public class Projet {
    private int idProjet;
    private String nom;
    private int idEmployee;
    private Date dateDebut;
    private Date dateFin;
    private String description;
    private double tauxAvancement;

    public Projet() {
    }

    public Projet(int idProjet, String nom, String responsable, Date dateDebut, Date dateFin, String description, double tauxAvancement) {
        this.idProjet = idProjet;
        this.nom = nom;
        this.idEmployee = idEmployee;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
        this.tauxAvancement = tauxAvancement;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getidEmployee() {
        return idEmployee;
    }

    public void setidEmployee(int responsable) {
        this.idEmployee = responsable;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTauxAvancement() {
        return tauxAvancement;
    }

    public void setTauxAvancement(double tauxAvancement) {
        this.tauxAvancement = tauxAvancement;
    }

    public int getIdEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTitre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTitre(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIdEmployee(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

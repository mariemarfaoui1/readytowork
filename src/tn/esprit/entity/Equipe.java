/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entity;

import java.util.List;

/**
 *
 * @author mariem
 */
public class Equipe {
    private int id;
    private int idEmployee;
    private int idProjet;
    private String responsable;
    private List<String> employeeEffectuer;
    private String nom;

    public Equipe() {
    }

    public Equipe(int id, int idEmployee, int idProjet, String responsable, List<String> employeesEffectues, String nom) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.idProjet = idProjet;
        this.responsable = responsable;
        this.employeeEffectuer = employeeEffectuer;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public List<String> setEmployeeEffectuer() {
        return employeeEffectuer;
    }

    public void setEmployeeEffectuer(List<String> employeeEffectuer) {
        this.employeeEffectuer = employeeEffectuer;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

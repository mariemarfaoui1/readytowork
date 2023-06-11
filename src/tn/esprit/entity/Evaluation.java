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
public class Evaluation {
    private int idEvaluation;
    private String titre;
    private int performance;
    private int idProjet;

    public Evaluation() {
    }

    public Evaluation(int idEvaluation, String titre, int performance, int idProjet) {
        this.idEvaluation = idEvaluation;
        this.titre = titre;
        this.performance = performance;
        this.idProjet = idProjet;
    }

    public Evaluation(int idEvaluation, String titre, int performance, int idProjet, int idEmploye) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(int idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }
}

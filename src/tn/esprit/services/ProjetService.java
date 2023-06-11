/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

/**
 *
 * @author mariem
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.entity.Projet;

public class ProjetService {
    private static final String URL = "jdbc:mysql://localhost:3306/readytowork";
    private static final String USERNAME = "nom_utilisateur";
    private static final String PASSWORD = "mot_de_passe";

    public void ajouterProjet(Projet projet) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO Projet (idProjet, titre, idEmployee, dateDebut, dateFin, description, tauxAvancement) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, projet.getIdProjet());
            statement.setString(2, projet.getTitre());
            statement.setInt(3, projet.getIdEmployee());
            statement.setDate(4, new java.sql.Date(projet.getDateDebut().getTime()));
            statement.setDate(5, new java.sql.Date(projet.getDateFin().getTime()));
            statement.setString(6, projet.getDescription());
            statement.setDouble(7, projet.getTauxAvancement());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierProjet(Projet projet) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "UPDATE Projet SET titre = ?, idEmployee = ?, dateDebut = ?, dateFin = ?, description = ?, tauxAvancement = ? " +
                    "WHERE idProjet = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, projet.getTitre());
            statement.setInt(2, projet.getIdEmployee());
            statement.setDate(3, new java.sql.Date(projet.getDateDebut().getTime()));
            statement.setDate(4, new java.sql.Date(projet.getDateFin().getTime()));
            statement.setString(5, projet.getDescription());
            statement.setDouble(6, projet.getTauxAvancement());
            statement.setInt(7, projet.getIdProjet());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerProjet(int idProjet) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "DELETE FROM Projet WHERE idProjet = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, idProjet);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Projet getProjetById(int idProjet) {
        Projet projet = null;
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM Projet WHERE idProjet = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, idProjet);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                projet = new Projet();
                projet.setIdProjet(resultSet.getInt("idProjet"));
                projet.setTitre(resultSet.getString("titre"));
                projet.setIdEmployee(resultSet.getInt("idEmployee"));
                projet.setDateDebut(resultSet.getDate("dateDebut"));
                projet.setDateFin(resultSet.getDate("dateFin"));
                projet.setDescription(resultSet.getString("description"));
                projet.setTauxAvancement(resultSet.getDouble("tauxAvancement"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projet;
    }

    public List<Projet> getAllProjets() {
        List<Projet> projets = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM Projet";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Projet projet = new Projet();
                projet.setIdProjet(resultSet.getInt("idProjet"));
                projet.setTitre(resultSet.getString("titre"));
                projet.setIdEmployee(resultSet.getInt("idEmployee"));
                projet.setDateDebut(resultSet.getDate("dateDebut"));
                projet.setDateFin(resultSet.getDate("dateFin"));
                projet.setDescription(resultSet.getString("description"));
                projet.setTauxAvancement(resultSet.getDouble("tauxAvancement"));
                projets.add(projet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projets;
    }
}

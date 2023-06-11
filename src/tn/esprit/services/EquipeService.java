/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.entity.Equipe;

public class EquipeService {
    private static final String URL = "jdbc:mysql://localhost:3306/readytowork";
    private static final String USERNAME = "nom_utilisateur";
    private static final String PASSWORD = "mot_de_passe";

    public void ajouterEquipe(Equipe equipe) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO Equipe (id, idEmployee, idProjet, Responsable, employeeffectuer, nom) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, equipe.getId());
            statement.setInt(2, equipe.getIdEmployee());
            statement.setInt(3, equipe.getIdProjet());
            statement.setString(4, equipe.getResponsable());
            
            statement.setString(6, equipe.getNom());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierEquipe(Equipe equipe) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "UPDATE Equipe SET idEmployee = ?, idProjet = ?, Responsable = ?, employeeffectuer = ?, nom = ? " +
                    "WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, equipe.getIdEmployee());
            statement.setInt(2, equipe.getIdProjet());
            statement.setString(3, equipe.getResponsable());
            statement.setString(5, equipe.getNom());
            statement.setInt(6, equipe.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerEquipe(int id) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "DELETE FROM Equipe WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Equipe getEquipeById(int id) {
        Equipe equipe = null;
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM Equipe WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                equipe = new Equipe();
                equipe.setId(resultSet.getInt("id"));
                equipe.setIdEmployee(resultSet.getInt("idEmployee"));
                equipe.setIdProjet(resultSet.getInt("idProjet"));
                equipe.setResponsable(resultSet.getString("Responsable"));
                equipe.setNom(resultSet.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipe;
    }

    public List<Equipe> getAllEquipes() {
        List<Equipe> equipes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM Equipe";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Equipe equipe = new Equipe();
                equipe.setId(resultSet.getInt("id"));
                equipe.setIdEmployee(resultSet.getInt("idEmployee"));
                equipe.setIdProjet(resultSet.getInt("idProjet"));
                equipe.setResponsable(resultSet.getString("Responsable"));
                equipe.setNom(resultSet.getString("nom"));
                equipes.add(equipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipes;
    }
}
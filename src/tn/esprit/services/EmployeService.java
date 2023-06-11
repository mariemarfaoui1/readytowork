

package tn.esprit.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.entity.Employe;
import tn.esprit.entity.Equipe;

public class EmployeService {
    private static final String URL = "jdbc:mysql://localhost:3306/readytowork";
    private static final String USERNAME = "nom_utilisateur";
    private static final String PASSWORD = "mot_de_passe";

    public void ajouterEmploye(Employe employe) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO Employe (idEmployee, cin, numeroTelephone, dateNaissance, dateEmbauche, nom, prenom, email, poste, departement) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, employe.getIdEmployee());
            statement.setInt(2, employe.getCin());
            statement.setInt(3, employe.getNumeroTelephone());
            statement.setDate(4, new java.sql.Date(employe.getDateNaissance().getTime()));
            statement.setDate(5, new java.sql.Date(employe.getDateEmbauche().getTime()));
            statement.setString(6, employe.getNom());
            statement.setString(7, employe.getPrenom());
            statement.setString(8, employe.getEmail());
            statement.setString(9, employe.getPoste());
            statement.setString(10, employe.getDepartement());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierEmploye(Employe employe) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "UPDATE Employe SET cin = ?, numeroTelephone = ?, dateNaissance = ?, dateEmbauche = ?, nom = ?, prenom = ?, email = ?, poste = ?, departement = ? " +
                    "WHERE idEmployee = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, employe.getCin());
            statement.setInt(2, employe.getNumeroTelephone());
            statement.setDate(3, new java.sql.Date(employe.getDateNaissance().getTime()));
            statement.setDate(4, new java.sql.Date(employe.getDateEmbauche().getTime()));
            statement.setString(5, employe.getNom());
            statement.setString(6, employe.getPrenom());
            statement.setString(7, employe.getEmail());
            statement.setString(8, employe.getPoste());
            statement.setString(9, employe.getDepartement());
            statement.setInt(10, employe.getIdEmployee());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerEmploye(int idEmployee) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "DELETE FROM Employe WHERE idEmployee = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, idEmployee);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employe getEmployeById(int idEmployee) {
        Employe employe = null;
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM Employe WHERE idEmployee = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, idEmployee);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                employe = new Employe();
                employe.setIdEmployee(resultSet.getInt("idEmployee"));
                employe.setCin(resultSet.getInt("cin"));
                employe.setNumeroTelephone(resultSet.getInt("numeroTelephone"));
                employe.setDateNaissance(resultSet.getDate("dateNaissance"));
                employe.setDateEmbauche(resultSet.getDate("dateEmbauche"));
                employe.setNom(resultSet.getString("nom"));
                employe.setPrenom(resultSet.getString("prenom"));
                employe.setEmail(resultSet.getString("email"));
                employe.setPoste(resultSet.getString("poste"));
                employe.setDepartement(resultSet.getString("departement"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employe;
    }

    public List<Employe> getAllEmployes() {
        List<Employe> employes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM Employe";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Employe employe = new Employe();
                employe.setIdEmployee(resultSet.getInt("idEmployee"));
                employe.setCin(resultSet.getInt("cin"));
                employe.setNumeroTelephone(resultSet.getInt("numeroTelephone"));
                employe.setDateNaissance(resultSet.getDate("dateNaissance"));
                employe.setDateEmbauche(resultSet.getDate("dateEmbauche"));
                employe.setNom(resultSet.getString("nom"));
                employe.setPrenom(resultSet.getString("prenom"));
                employe.setEmail(resultSet.getString("email"));
                employe.setPoste(resultSet.getString("poste"));
                employe.setDepartement(resultSet.getString("departement"));
                employes.add(employe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employes;
    }
}

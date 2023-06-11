package tn.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.connection.MaConnexion;
import tn.esprit.entity.Tache;

public class Tacheservice {
    private List<Tache> taches;
    private Connection cnx;

    public Tacheservice() {
        taches = new ArrayList<>();
        cnx = MaConnexion.getInstance().getCnx();
    }

    // Create
    public void createTache(int idTache, int idEmploye, String titre, int nombreHeures, int avancement, String nomEmploye) {
        Tache tache = new Tache(idTache, idEmploye, titre, nombreHeures, avancement, nomEmploye);
        taches.add(tache);

        if (cnx != null) { // Vérifier la connexion à la base de données
            String sql = "INSERT INTO tache (idTache, idEmploye, titre, nombreHeures, avancement, nomEmploye) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
                stmt.setInt(1, idTache);
                stmt.setInt(2, idEmploye);
                stmt.setString(3, titre);
                stmt.setInt(4, nombreHeures);
                stmt.setInt(5, avancement);
                stmt.setString(6, nomEmploye);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("La connexion à la base de données n'a pas été établie.");
        }
    }

    // Read
    public Tache getTacheById(int idTache) {
        for (Tache tache : taches) {
            if (tache.getIdTache() == idTache) {
                return tache;
            }
        }
        return null;
    }

    public List<Tache> getAllTaches() {
        List<Tache> allTaches = new ArrayList<>();
        String sql = "SELECT * FROM tache";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idTache = rs.getInt("idTache");
                int idEmploye = rs.getInt("idEmploye");
                String titre = rs.getString("titre");
                int nombreHeures = rs.getInt("nombreHeures");
                int avancement = rs.getInt("avancement");
                String nomEmploye = rs.getString("nomEmploye");
                Tache tache = new Tache(idTache, idEmploye, titre, nombreHeures, avancement, nomEmploye);
                allTaches.add(tache);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allTaches;
    }

    // Update
    public void updateTache(int idTache, int idEmploye, String titre, int nombreHeures, int avancement, String nomEmploye) {
        Tache tache = getTacheById(idTache);
        if (tache != null) {
            tache.setIdEmploye(idEmploye);
            tache.setTitre(titre);
            tache.setNombreHeures(nombreHeures);
            tache.setAvancement(avancement);
            tache.setNomEmploye(nomEmploye);

            String sql = "UPDATE tache SET idEmploye = ?, titre = ?, nombreHeures = ?, avancement = ?, nomEmploye = ? WHERE idTache = ?";
            try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
                stmt.setInt(1, idEmploye);
                stmt.setString(2, titre);
                stmt.setInt(3, nombreHeures);
                stmt.setInt(4, avancement);
                stmt.setString(5, nomEmploye);
                stmt.setInt(6, idTache);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Delete
    public void deleteTache(int idTache) {
        Tache tache = getTacheById(idTache);
        if (tache != null) {
            taches.remove(tache);

            String sql = "DELETE FROM tache WHERE idTache = ?";
            try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
                stmt.setInt(1, idTache);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

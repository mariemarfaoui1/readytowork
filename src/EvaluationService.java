import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.entity.Evaluation;

public class EvaluationService {
    private static final String URL = "jdbc:mysql://localhost:3306/readytowork";
    private static final String USERNAME = "nom_utilisateur";
    private static final String PASSWORD = "mot_de_passe";

    public void ajouterEvaluation(Evaluation evaluation) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO Evaluation (idEvaluation, idProjet, performance) " +
                    "VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, evaluation.getIdEvaluation());
            statement.setInt(2, evaluation.getIdProjet());
            statement.setInt(3, evaluation.getPerformance());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierEvaluation(Evaluation evaluation) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "UPDATE Evaluation SET idProjet = ?, performance = ? " +
                    "WHERE idEvaluation = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, evaluation.getIdProjet());
            statement.setInt(2, evaluation.getPerformance());
            statement.setInt(3, evaluation.getIdEvaluation());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerEvaluation(int idEvaluation) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "DELETE FROM Evaluation WHERE idEvaluation = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, idEvaluation);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Evaluation getEvaluationById(int idEvaluation) {
        Evaluation evaluation = null;
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM Evaluation WHERE idEvaluation = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, idEvaluation);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                evaluation = new Evaluation();
                evaluation.setIdEvaluation(resultSet.getInt("idEvaluation"));
                evaluation.setIdProjet(resultSet.getInt("idProjet"));
                evaluation.setPerformance(resultSet.getInt("performance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evaluation;
    }

    public List<Evaluation> getAllEvaluations() {
        List<Evaluation> evaluations = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM Evaluation";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Evaluation evaluation = new Evaluation();
                evaluation.setIdEvaluation(resultSet.getInt("idEvaluation"));
                evaluation.setIdProjet(resultSet.getInt("idProjet"));
                evaluation.setPerformance(resultSet.getInt("performance"));
                evaluations.add(evaluation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evaluations;
    }
}

import java.io.IOException;
import java.util.Date;
import java.util.List;
import tn.esprit.entity.Evaluation;
import tn.esprit.entity.Tache;




  /*  public static void main(String[] args) {
        TacheService tacheService = new TacheService();

        // Créer une nouvelle tâche
        tacheService.creerTache( "Tâche 1", "Description de la tâche 1", new Date(), new Date());

        // Lire toutes les tâches
        List<Tache> toutesLesTaches = tacheService.lireTaches();
        System.out.println("Toutes les tâches :");
        for (Tache tache : toutesLesTaches) {
            System.out.println(tache);
        }

        // Lire une tâche par son ID
        Tache tache1 = tacheService.lireTacheParId(1);
        System.out.println("Tâche par ID (1) : " + tache1);

        // Mettre à jour une tâche
        if (tache1 != null) {
            tacheService.mettreAJourTache(1, "Tâche 1 mise à jour", "Description mise à jour", new Date(), new Date());
        }

        // Supprimer une tâche
        tacheService.supprimerTache(1);

        // Lire toutes les tâches après suppression
        toutesLesTaches = tacheService.lireTaches();
        System.out.println("Toutes les tâches après suppression :");
        for (Tache tache : toutesLesTaches) {
            System.out.println(tache);
        }
    }
}*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author mariem
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Menu.fxml"));
        Scene scene =new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}


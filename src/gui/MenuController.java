/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author mariem
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
     private ImageView  img ;
    @FXML
    private AnchorPane mainpanel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Button idbtntache = new Button();

     idbtntache.setText("test");
    }    
    @FXML
void clickeval(ActionEvent event) throws IOException {
    Node node = null;
    Node equipeNode = FXMLLoader.load(getClass().getResource("/gui/ListEquipe.fxml"));

    mainpanel.getChildren().clear();
    mainpanel.getChildren().add(equipeNode);
}

@FXML
void clickeval2(ActionEvent event) throws IOException {
    Node projetNode = FXMLLoader.load(getClass().getResource("/gui/ListProjet.fxml"));

    mainpanel.getChildren().clear();
    mainpanel.getChildren().add(projetNode);
}

@FXML
void clickeval3(ActionEvent event) throws IOException {
    Node tacheNode = FXMLLoader.load(getClass().getResource("/gui/ListTache.fxml"));

    mainpanel.getChildren().clear();
    mainpanel.getChildren().add(tacheNode);
}
}
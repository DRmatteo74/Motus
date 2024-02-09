package fr.esgi.controller;

import fr.esgi.App;
import fr.esgi.service.HistoriqueService;
import fr.esgi.service.impl.HistoriqueServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HistoriqueController implements Initializable {

    private HistoriqueService historiqueService = new HistoriqueServiceImpl();

    @FXML
    private GridPane grilleHistorique;

    @FXML
    private FlowPane planeChoixPartie;

    @FXML
    private Label labelHistorique;

    @FXML
    private void handleButtonRetour() throws IOException {
        App.setRoot("home", null);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        historiqueService.afficherBoutonChoix(planeChoixPartie, grilleHistorique);

    }
}

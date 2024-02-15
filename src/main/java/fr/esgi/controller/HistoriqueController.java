package fr.esgi.controller;

import fr.esgi.App;
import fr.esgi.service.HistoriqueService;
import fr.esgi.service.impl.HistoriqueServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
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
    private MenuButton buttonTrie;

    @FXML
    private void handleButtonRetour() throws IOException {
        App.setRoot("menu", null);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        historiqueService.afficherBoutonChoix(planeChoixPartie, grilleHistorique);
        buttonTrie.setText("Trier par...");
    }

    public void handleButtonTrieMot(ActionEvent event) {
        buttonTrie.setText("Trier par mot");
        historiqueService.changerTrie(1, grilleHistorique);
    }

    public void handleButtonTrieTemps(ActionEvent event) {
        buttonTrie.setText("Trier par temps");
        historiqueService.changerTrie(2, grilleHistorique);
    }

    public void handleButtonTrieAucun(ActionEvent event) {
        buttonTrie.setText("Trier par...");
        historiqueService.changerTrie(0, grilleHistorique);
    }
}

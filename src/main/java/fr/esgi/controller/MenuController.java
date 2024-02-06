package fr.esgi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.esgi.App;
import fr.esgi.service.AffichageService;
import fr.esgi.service.DifficulteService;
import fr.esgi.service.impl.AffichageServiceImpl;
import fr.esgi.service.impl.DifficulteServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;

public class MenuController implements Initializable {

	private AffichageService affichageService = new AffichageServiceImpl();

	private DifficulteService difficulteService = new DifficulteServiceImpl();

	@FXML
	private Label labelPseudo;

	@FXML
	private SplitMenuButton buttonPartieRapide;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		difficulteService.creerDifficulte();

		affichageService.recupererInfoJoueurInterfaceMenu(labelPseudo);

		affichageService.creerBoutonMenu(buttonPartieRapide);
	}

	@FXML
	private void handleButtonCredit(ActionEvent event) throws IOException {
		App.setRoot("credit", null);
	}

}

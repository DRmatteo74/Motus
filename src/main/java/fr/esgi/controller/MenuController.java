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
	private SplitMenuButton buttonDifficulte;

	@FXML
	private SplitMenuButton buttonNbMot;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		difficulteService.creerDifficulte();

		affichageService.recupererInfoJoueurInterfaceMenu(labelPseudo);

		affichageService.creerBoutonMenu(buttonDifficulte, buttonNbMot);
	}

	@FXML
    public void handleButtonHistorique(ActionEvent event) throws IOException {
		App.setRoot("historique", null);
    }

	@FXML
	public void handleButtonValider(ActionEvent event) {
		int[] donneeATransmettre = { 0, 0 };
		switch (buttonDifficulte.getText()){
			case "Niveau facile (6 lettres)":
				donneeATransmettre[0] = 1;
				break;
			case "Niveau moyen (7 lettres)":
				donneeATransmettre[0] = 2;
				break;
			case "Niveau difficile (8 lettres)":
				donneeATransmettre[0] = 3;
				break;
			case "Niveau aléatoire":
				donneeATransmettre[0] = 0;
				break;
			default:
				return;
		}

		switch (buttonNbMot.getText()){
			case "1 mot":
				donneeATransmettre[1] = 1;
				break;
			case "4 mots":
				donneeATransmettre[1] = 4;
				break;
			default:
				return;
		}

		try {
			App.setRoot("jeu", donneeATransmettre);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

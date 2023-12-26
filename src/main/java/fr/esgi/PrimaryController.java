package fr.esgi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.esgi.service.AffichageService;
import fr.esgi.service.JoueurService;
import fr.esgi.service.MotService;
import fr.esgi.service.impl.AffichageServiceImpl;
import fr.esgi.service.impl.JoueurServiceImpl;
import fr.esgi.service.impl.MotServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

	private MotService motService = new MotServiceImpl();
	private AffichageService affichageService = new AffichageServiceImpl();
	private JoueurService joueurService = new JoueurServiceImpl();

	@FXML
	private Label mot1;

	@FXML
	private Label mot2;

	@FXML
	private Label mot3;

	@FXML
	private Label labelTitre;

	@FXML
	private TextField textfieldPseudo;

	@FXML
	private Button buttonValider;

	@FXML
	private void switchToSecondary() throws IOException {
		App.setRoot("secondary");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		affichageService.changerMotInterfaceAcceuil(mot1, mot2, mot3);
		affichageService.animerMotInterfaceAcceuil(mot1, mot2, mot3, labelTitre);
		buttonValider.setDisable(true);
		textfieldPseudo.textProperty().addListener((observable, oldValue, newValue) -> {
			// Activer ou désactiver le bouton en fonction du contenu du TextField
			buttonValider.setDisable(newValue.trim().isEmpty());
		});
	}

	@FXML
	private void handleButtonValider(ActionEvent event) {
		joueurService.creerJoueur(textfieldPseudo.getText());
		System.out.println("Texte saisi : " + textfieldPseudo.getText());
	}
}

package fr.esgi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.esgi.service.AffichageService;
import fr.esgi.service.impl.AffichageServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;

public class MenuController implements Initializable {

	private AffichageService affichageService = new AffichageServiceImpl();

	@FXML
	private Label labelPseudo;

	@FXML
	private SplitMenuButton buttonPartieRapide;

	@FXML
	private void switchToSecondary() throws IOException {
		App.setRoot("secondary", null);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		affichageService.recupererInfoJoueurInterfaceMenu(labelPseudo);

		affichageService.creerBoutonMenu(buttonPartieRapide);
	}

	@FXML
	private void handleButtonValider(ActionEvent event) {

	}

}

package fr.esgi.controller;

import java.io.IOException;

import fr.esgi.App;
import javafx.fxml.FXML;

public class CreditController {

	@FXML
	private void handleButtonCredit() throws IOException {
		App.setRoot("home", null);
	}
}
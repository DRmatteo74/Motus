package fr.esgi.service;

import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public interface JeuService {

	void creerBoutonJeu(List<Button> boutons, int nbEssai, GridPane grilleJeu, Button buttonVal);

	void modifierLabelJeu(GridPane grilleJeu, int ligne, String letter, Button buttonVal);

	void supprimerLabelJeu(GridPane grilleJeu, int ligne, Button buttonVal);

	String recupererMot(GridPane grilleJeu, int ligne);

	boolean verifierMot(String motTrouver, String motGagnant, GridPane grilleJeu, int nbEssai);

	boolean appartenirAuMot(char caractere, String motGagnant);

	boolean situerCorrectement(char caractere, char caractereGagnant);

	boolean supprimerDoublon(String motGagnant, String motJoueur, char lettre, int indice);

	int compterLettre(String mot, char lettre);
}

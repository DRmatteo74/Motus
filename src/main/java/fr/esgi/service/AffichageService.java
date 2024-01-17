package fr.esgi.service;

import java.util.List;

import fr.esgi.business.Mot;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public interface AffichageService {

	// page de connexion
	void changerMotInterfaceAcceuil(Label mot1, Label mot2, Label mot3);

	void animerMotInterfaceAcceuil(Label mot1, Label mot2, Label mot3, Label label);

	// menu
	void recupererInfoJoueurInterfaceMenu(Label labelPseudo);

	void creerBoutonMenu(SplitMenuButton buttonPartieRapide);

	// page de jeu
	void centrerItemsJeuInterface(GridPane grilleJeu, Label titreJeu, AnchorPane anchorClavier);

	void afficherGrilleDeJeuInterface(Mot motATrouver, GridPane grilleJeu);

	void creerBoutonJeu(List<Button> boutons, int nbEssai, GridPane grilleJeu, int taille);

	int lireLabelJeu(GridPane grilleJeu, int ligne, int colonne);

}

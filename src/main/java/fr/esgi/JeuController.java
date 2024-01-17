package fr.esgi;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import fr.esgi.business.Mot;
import fr.esgi.service.AffichageService;
import fr.esgi.service.MotService;
import fr.esgi.service.impl.AffichageServiceImpl;
import fr.esgi.service.impl.MotServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class JeuController implements Initializable {

	private AffichageService affichageService = new AffichageServiceImpl();

	private MotService motService = new MotServiceImpl();

	@FXML
	private GridPane grilleJeu;

	@FXML
	private Label titreJeu;

	@FXML
	private AnchorPane anchorClavier;

	@FXML
	private Button buttonA;

	@FXML
	private Button buttonZ;

	@FXML
	private Button buttonE;

	@FXML
	private Button buttonR;

	@FXML
	private Button buttonT;

	@FXML
	private Button buttonY;

	@FXML
	private Button buttonU;

	@FXML
	private Button buttonI;

	@FXML
	private Button buttonO;

	@FXML
	private Button buttonP;

	@FXML
	private Button buttonQ;

	@FXML
	private Button buttonS;

	@FXML
	private Button buttonD;

	@FXML
	private Button buttonF;

	@FXML
	private Button buttonG;

	@FXML
	private Button buttonH;

	@FXML
	private Button buttonJ;

	@FXML
	private Button buttonK;

	@FXML
	private Button buttonL;

	@FXML
	private Button buttonM;

	@FXML
	private Button buttonW;

	@FXML
	private Button buttonX;

	@FXML
	private Button buttonC;

	@FXML
	private Button buttonV;

	@FXML
	private Button buttonB;

	@FXML
	private Button buttonN;

	@FXML
	private Button buttonSup;

	@FXML
	private Button buttonVal;

	@FXML
	private Button[] boutons;

	private int difficulte;

	private int nbPartieRestante;

	private Mot motATrouver;

	private int taille;

	private int nombreEssai = 0;

	private String motRentrer;

	public void initializeData(Object data) {
		if (data instanceof int[]) {
			int[] dataArray = (int[]) data;

			// Afficher chaque élément du tableau
			/*
			 * for (int i = 0; i < dataArray.length; i++) { System.out.println("Élément " +
			 * i + ": " + dataArray[i]); }
			 */
			difficulte = dataArray[0];
			nbPartieRestante = dataArray[1];
		} else {
			System.out.println("Le type de données n'est pas pris en charge : " + data.getClass());
		}
		motATrouver = motService.recupererMotAleatoire();
		motRentrer = Character.toUpperCase(motATrouver.getMot().charAt(0)) + "";
		affichageService.afficherGrilleDeJeuInterface(motATrouver, grilleJeu);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		boutons = new Button[] { buttonA, buttonZ, buttonE, buttonR, buttonT, buttonY, buttonU, buttonI, buttonO,
				buttonP, buttonQ, buttonS, buttonD, buttonF, buttonG, buttonH, buttonJ, buttonK, buttonL, buttonM,
				buttonW, buttonX, buttonC, buttonV, buttonB, buttonN };

		// motATrouver = motService.recupererMotAleatoireParNiveau(difficulte);
		affichageService.centrerItemsJeuInterface(grilleJeu, titreJeu, anchorClavier);
		// affichageService.afficherGrilleDeJeuInterface(motATrouver, grilleJeu);
		affichageService.creerBoutonJeu(Arrays.asList(boutons), nombreEssai, grilleJeu, taille);
	}

	@FXML
	private void SUP(ActionEvent event) {
		System.out.println("coucou");
	}

	@FXML
	private void VAL(ActionEvent event) {
		System.out.println("coucou");
	}

}

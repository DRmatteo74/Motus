package fr.esgi.controller;

import fr.esgi.App;
import fr.esgi.business.Difficulte;
import fr.esgi.business.Mot;
import fr.esgi.business.Partie;
import fr.esgi.business.Question;
import fr.esgi.service.*;
import fr.esgi.service.impl.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class JeuController implements Initializable {
	
	private AffichageService affichageService = new AffichageServiceImpl();

	private MotService motService = new MotServiceImpl();

	private JeuService jeuService = new JeuServiceImpl();

	private QuestionService questionService = new QuestionServiceImpl();

	private PartieService partieService = new PartieServiceImpl();

	private DifficulteService difficulteService = new DifficulteServiceImpl();

	private JoueurService joueurService = new JoueurServiceImpl();

	@FXML
	private GridPane grilleJeu;

	@FXML
	private Label titreJeu;

	@FXML
	private Label labelNumMot;

	@FXML
	private Label labelMaxNumMot;

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

	@FXML
	public Label statutLabel;

	private int nbPartieRestante;

	private int difficulteChoisi;

	private Mot motATrouver;

	private int nombreEssai = 0;

	private String motRentrer;

	private Long tempsDebut;

	private Long tempsFin;

	private Long tempsTotal;

	private List<String> listReponse = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// créer une liste de boutton
		boutons = new Button[] { buttonA, buttonZ, buttonE, buttonR, buttonT, buttonY, buttonU, buttonI, buttonO,
				buttonP, buttonQ, buttonS, buttonD, buttonF, buttonG, buttonH, buttonJ, buttonK, buttonL, buttonM,
				buttonW, buttonX, buttonC, buttonV, buttonB, buttonN };

		// j'initialise correctement mon décor
		affichageService.centrerItemsJeuInterface(grilleJeu, titreJeu, anchorClavier);

		statutLabel.setText("");
	}

	Scene scene = null;

	/**
	 * Je recupere les éléments données dans mon changement de page et j'initialise
	 * des éléments
	 * 
	 * @param data
	 */
	public void initializeData(Object data, Scene _scene) {
		//Permet d'accéder à la scene et donc de détecter l'appuie sur le clavier
		scene = _scene;
		if (data instanceof int[]) {
			int[] dataArray = (int[]) data;

			nbPartieRestante = dataArray[1];
			difficulteChoisi = dataArray[0];
		} else {
			System.out.println("Le type de données n'est pas pris en charge : " + data.getClass());
		}
		// je choisi la difficulte
		if (difficulteChoisi == 0) {
			motATrouver = motService.recupererMotAleatoire();
		} else {
			motATrouver = motService.recupererMotAleatoireParNiveau(difficulteChoisi);
		}

		// Ecris le nombre de mots et vérifie le nombre restant pour évité de créer une nouvelle partie en cas de partie longue
		boolean createPartie = false;
		if(labelMaxNumMot.getText().isEmpty()){
			createPartie = true;
			labelMaxNumMot.setText(String.valueOf(nbPartieRestante));
		}

		labelNumMot.setText(String.valueOf(Integer.parseInt(labelMaxNumMot.getText()) - nbPartieRestante +1));

		// si nous sommes en debut de jeu, je créer un objet Partie
		if ((nbPartieRestante == 1 && createPartie) ||nbPartieRestante == 4) {
			Difficulte difficulte = difficulteService.recupererDifficulteParId((long) difficulteChoisi);
			partieService.innitialiserPartie(difficulte, joueurService.recupererJoueur());
		}
		// aide à résoudre
		System.out.println(motATrouver);
		// j'initialise mes boutons, ma grille et je démarre le timer
		motRentrer = Character.toUpperCase(motATrouver.getMot().charAt(0)) + "";
		affichageService.afficherGrilleDeJeuInterface(motATrouver, grilleJeu, buttonVal);
		jeuService.creerBoutonJeu(Arrays.asList(boutons), nombreEssai, grilleJeu, buttonVal, scene);
		tempsDebut = System.currentTimeMillis();

	}

	/**
	 * Bouton supprimé
	 * 
	 * @param event
	 */
	@FXML
	private void SUP(ActionEvent event) {
		jeuService.supprimerLabelJeu(grilleJeu, nombreEssai, buttonVal);
	}

	/**
	 * Bouton validé
	 * 
	 * @param event
	 */
	@FXML
	private void VAL(ActionEvent event) throws IOException {
		motRentrer = jeuService.recupererMot(grilleJeu, nombreEssai);
		// je vérifie si le mot existe
		if (motService.recupererMot(motRentrer) == null) {
			JOptionPane.showMessageDialog(null, "Votre mot n'existe pas", "Erreur", JOptionPane.ERROR_MESSAGE);
		} else {
			// je l'ajoute à ma liste de réponse
			listReponse.add(motRentrer);
			// je vérifie si je gagne
			boolean aGagner = jeuService.verifierMot(motRentrer, motATrouver.getMot(), grilleJeu, nombreEssai);
			// partie gagner
			if (aGagner) {
				// j'arrete le timeret je mets à jour ou créer ma parties et ma question
				tempsFin = System.currentTimeMillis();
				tempsTotal = (tempsFin - tempsDebut) / 1000;
				Partie partie = partieService.recupererDernierePartie();
				Question question = questionService.creerQuestion(tempsTotal, listReponse, motATrouver, partie);
				partieService.changerListQuestion(partie, question);
				// si c'est la fin de la partie
				if (nbPartieRestante < 2) {
					JOptionPane.showMessageDialog(null, "Vous avez gagné ! le mot était " + motATrouver.getMot() + " en "  + tempsTotal + " secondes", "Succes", JOptionPane.INFORMATION_MESSAGE);
					joueurService.ajouterPartie(joueurService.recupererJoueur(), partie);
					App.setRoot("menu", null);
				} else {
					// sinon on continue à jouer (partie multiple question)
					nbPartieRestante = nbPartieRestante - 1;
					statutLabel.setText("");
					nombreEssai = 0;
					listReponse.clear();
					initializeData(new int[] {difficulteChoisi, nbPartieRestante}, scene);
				}

			} else {
				// parti perdu
				if (nombreEssai >= 5) {
					statutLabel.setText("Vous avez perdu !");
					// je mets à jour ou créer ma partie et ma question
					Partie partie = partieService.recupererDernierePartie();
					Question question = questionService.creerQuestion(null, listReponse, motATrouver, partie);
					partieService.changerListQuestion(partie, question);
					joueurService.ajouterPartie(joueurService.recupererJoueur(), partie);
				}
				// essaie suivant
				else {
					// j'augmente le nombre d'essaie et je reinitiliase mes boutons
					nombreEssai += 1;
					jeuService.creerBoutonJeu(Arrays.asList(boutons), nombreEssai, grilleJeu, buttonVal, scene);
				}
			}
		}
	}

	@FXML
	private void handleButtonRetour(ActionEvent event) throws IOException {
		App.setRoot("menu", null);
	}

}

package fr.esgi.service.impl;

import java.io.IOException;

import fr.esgi.App;
import fr.esgi.business.Joueur;
import fr.esgi.business.Mot;
import fr.esgi.service.AffichageService;
import fr.esgi.service.JoueurService;
import fr.esgi.service.MotService;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class AffichageServiceImpl implements AffichageService {

	private MotService motService = new MotServiceImpl();

	private JoueurService joueurService = new JoueurServiceImpl();

	/**
	 * Change les trois mots de l'écran de démarage
	 * 
	 * @param mot1
	 * @param mot2
	 * @param mot3
	 */
	@Override
	public void changerMotInterfaceAcceuil(Label mot1, Label mot2, Label mot3) {

		mot1.setText(motService.recupererMotAleatoire().getMot());
		mot2.setText(motService.recupererMotAleatoire().getMot());
		mot3.setText(motService.recupererMotAleatoire().getMot());

	}

	/**
	 * Anim les trois mots de l'écran de démarage et change le titre si le curseur
	 * survole
	 * 
	 * @param mot1
	 * @param mot2
	 * @param mot3
	 * @param label
	 */
	@Override
	public void animerMotInterfaceAcceuil(Label mot1, Label mot2, Label mot3, Label label) {
		TranslateTransition translate1 = new TranslateTransition();
		translate1.setNode(mot1);
		translate1.setDuration(Duration.millis(2500));
		translate1.setByY(500); // Déplace vers le bas de la page
		translate1.setAutoReverse(false);
		translate1.setCycleCount(1); // Exécute la transition une seule fois

		// Configurez un événement à la fin de la transition pour réinitialiser la
		// position du Label
		translate1.setOnFinished(event -> {
			mot1.setTranslateY(-150); // Réinitialise la position du Label en haut
			translate1.play(); // Redémarre la transition
		});

		translate1.play();

		// translate
		TranslateTransition translate2 = new TranslateTransition();
		translate2.setNode(mot2);
		translate2.setDuration(Duration.millis(2200));
		translate2.setCycleCount(TranslateTransition.INDEFINITE);
		translate2.setByX(160);
		translate2.setByY(330);
		translate2.setAutoReverse(true);
		translate2.play();

		// rotate
		RotateTransition rotate = new RotateTransition();
		rotate.setNode(mot2);
		rotate.setDuration(Duration.millis(1500));
		rotate.setCycleCount(TranslateTransition.INDEFINITE);
		rotate.setInterpolator(Interpolator.LINEAR);
		rotate.setByAngle(360);
		rotate.setAxis(Rotate.Z_AXIS);
		rotate.play();

		// scale
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(mot3);
		scale.setDuration(Duration.millis(1000));
		scale.setCycleCount(TranslateTransition.INDEFINITE);
		scale.setInterpolator(Interpolator.LINEAR);
		scale.setByX(1.5);
		scale.setByY(1.5);
		scale.setAutoReverse(true);
		scale.play();

		// Créer une rotation transition
		RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), label);
		rotateTransition.setByAngle(360); // Rotation de 360 degrés
		rotateTransition.setCycleCount(Animation.INDEFINITE); // Rotation indéfinie

		// Créer une transition de redimensionnement
		ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), label);
		scaleTransition.setByX(1.3); // Facteur d'échelle en X
		scaleTransition.setByY(1.3); // Facteur d'échelle en Y
		scaleTransition.setCycleCount(Animation.INDEFINITE); // Redimensionnement indéfini

		// Ajouter des gestionnaires d'événements pour démarrer et arrêter les
		// transitions au survol
		label.setOnMouseEntered(event -> {
			rotateTransition.play();
			scaleTransition.play();
		});

		label.setOnMouseExited(event -> {
			rotateTransition.pause();
			scaleTransition.pause();
		});

	}

	///////////////////////////////////////////////////
	// page Acceuil
	//////////////////////////////////////////////////

	/**
	 * Affiche le pseudo du joueur
	 * 
	 * @param labelPseudo
	 */
	@Override
	public void recupererInfoJoueurInterfaceMenu(Label labelPseudo) {
		// recupere le joueur
		Joueur joueur = joueurService.recupererJoueur();
		labelPseudo.setText(joueur.getPseudo());
	}

	/**
	 * Créer le bouton Split pour les parties rapides
	 *
	 * @param buttonDifficulte
	 * @param buttonNbMot
	 */
	@Override
	public void creerBoutonMenu(SplitMenuButton buttonDifficulte, SplitMenuButton buttonNbMot) {
		// création des choix possible
		MenuItem facile = new MenuItem("Niveau facile (6 lettres)");
		MenuItem moyen = new MenuItem("Niveau moyen (7 lettres)");
		MenuItem difficile = new MenuItem("Niveau difficile (8 lettres)");
		MenuItem aleatoire = new MenuItem("Niveau aléatoire");

		// ajout des choix
		buttonDifficulte.getItems().addAll(facile, moyen, difficile, aleatoire);

		MenuItem unMot = new MenuItem("1 mot");
		MenuItem quatreMot = new MenuItem("4 mots");
		buttonNbMot.getItems().addAll(unMot, quatreMot);

		// defini l'action sur le clique d'un des choix
		// Parametre 1 : Permets à la page de jeu de savoir la difficulté (1, 2, 3, 0)
		// Parametre 2 : Le nombre de partie (0/4) pour rapide ou longue

		facile.setOnAction((e) -> {
			buttonDifficulte.setText(facile.getText());
		});
		moyen.setOnAction((e) -> {
			buttonDifficulte.setText(moyen.getText());
		});
		difficile.setOnAction((e) -> {
			buttonDifficulte.setText(difficile.getText());
		});
		aleatoire.setOnAction((e) -> {
			buttonDifficulte.setText(aleatoire.getText());
		});

		unMot.setOnAction((e)->{
			buttonNbMot.setText(unMot.getText());
		});

		quatreMot.setOnAction((e)->{
			buttonNbMot.setText(quatreMot.getText());
		});
	}

	//////////////////////////////////////////
	// page de jeu
	///////////////////////////////////////////

	/**
	 * Définit la postition du clavier et de la grille sur la page de jeu
	 * 
	 * @param grilleJeu
	 * @param titreJeu
	 * @param anchorClavier
	 */
	@Override
	public void centrerItemsJeuInterface(GridPane grilleJeu, Label titreJeu, AnchorPane anchorClavier) {
		// Obtenez le conteneur parent commun pour le label et la grille
		Pane parentContainer = (Pane) titreJeu.getParent();

		// Calculez et définissez la nouvelle position x du label
		ChangeListener<Number> dimensionsChangeListener = new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				double centerXLabel = (parentContainer.getWidth() - titreJeu.getWidth()) / 2;
				titreJeu.setLayoutX(centerXLabel);

				double centerXGrid = (parentContainer.getWidth() - grilleJeu.getWidth()) / 2;
				grilleJeu.setLayoutX(centerXGrid);

				double centerXAnchor = (parentContainer.getWidth() - anchorClavier.getWidth()) / 2;
				anchorClavier.setLayoutX(centerXAnchor);

				double bottomMargin = 10; // Marge en bas
				double centerYAnchor = parentContainer.getHeight() - anchorClavier.getHeight() - bottomMargin;
				anchorClavier.setLayoutY(centerYAnchor);
			}
		};

		// Ajoutez un écouteur d'événements pour le redimensionnement du parent
		parentContainer.widthProperty().addListener(dimensionsChangeListener);

		// Initialisez la position initiale du label
		dimensionsChangeListener.changed(null, null, null);
	}

	/**
	 * Créer la grille de bonne longueur et créer des label texte dedans
	 * 
	 * @param motATrouver
	 * @param grilleJeu
	 * @param buttonVal
	 */
	@Override
	public void afficherGrilleDeJeuInterface(Mot motATrouver, GridPane grilleJeu, Button buttonVal) {
		int taille = motATrouver.getLongueurMot();
		// Supprimer toutes les colonnes existantes
		grilleJeu.getColumnConstraints().clear();
		grilleJeu.getChildren().clear();

		// defini la taille de chaque carreau
		for (int col = 0; col < taille; col++) {
			ColumnConstraints colConst = new ColumnConstraints();
			colConst.setPercentWidth(100.0 / taille);
			grilleJeu.getColumnConstraints().add(colConst);
		}

		// Supprimer toutes les lignes existantes
		grilleJeu.getRowConstraints().clear();

		grilleJeu.setVgap(10.0);

		// defini la taille de chaque carreau
		for (int row = 0; row < 6; row++) {
			RowConstraints rowConst = new RowConstraints();
			rowConst.setPercentHeight(100.0 / 6);
			grilleJeu.getRowConstraints().add(rowConst);

			// créer un label dans chaque carreau
			for (int col = 0; col < taille; col++) {
				Label label = new Label();
				if (col == 0 && row == 0) {
					// initialise la premiere lettre du mot a trouver
					String premiereLettre = Character.toUpperCase(motATrouver.getMot().charAt(0)) + "";
					label.setText(premiereLettre);
				} else {
					label.setText("_");
				}
				// defini le style de mes labels
				label.setStyle(
						"-fx-border-color: white; -fx-border-width: 1px; -fx-border-radius: 5px; -fx-background-color: #FFFFFF00; -fx-font-size: 16px; -fx-font-weight: bold; -fx-min-width: 30px; -fx-alignment: center; -fx-text-fill: white;");
				grilleJeu.add(label, col, row);
			}
		}
		// desactive le boutton valider
		buttonVal.setDisable(true);
	}

	/**
	 * Change la couleur des labeltexte une fois que le joueur a validé
	 * 
	 * @param ligne
	 * @param grilleJeu
	 * @param colonne
	 * @param couleur
	 */
	@Override
	public void changerCouleurGrilleInterface(GridPane grilleJeu, int ligne, int colonne, Color couleur) {
		// defini le style du label
		String style = String.format(
				"-fx-background-color: #%02X%02X%02X; -fx-border-color: black; -fx-font-weight: bold; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-font-size: 16px; -fx-min-width: 30px; -fx-alignment: center;",
				(int) (couleur.getRed() * 255), (int) (couleur.getGreen() * 255), (int) (couleur.getBlue() * 255));

		for (javafx.scene.Node node : grilleJeu.getChildren()) {
			Integer rowIndex = GridPane.getRowIndex(node);
			Integer colIndex = GridPane.getColumnIndex(node);

			// applique sur le label voulu
			if (rowIndex != null && colIndex != null && rowIndex == ligne && colIndex == colonne) {
				((Label) node).setStyle(style);
				break;
			}
		}
	}

}

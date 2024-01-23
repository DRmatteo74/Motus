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

	@Override
	public void changerMotInterfaceAcceuil(Label mot1, Label mot2, Label mot3) {

		mot1.setText(motService.recupererMotAleatoire().getMot());
		mot2.setText(motService.recupererMotAleatoire().getMot());
		mot3.setText(motService.recupererMotAleatoire().getMot());

	}

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

	@Override
	public void recupererInfoJoueurInterfaceMenu(Label labelPseudo) {
		Joueur joueur = joueurService.recupererJoueur();
		labelPseudo.setText(joueur.getPseudo());
	}

	@Override
	public void creerBoutonMenu(SplitMenuButton buttonPartieRapide) {
		MenuItem facile = new MenuItem("Niveau facile (8 lettres maxi)");
		MenuItem moyen = new MenuItem("Niveau moyen (9 à 11 lettres)");
		MenuItem difficile = new MenuItem("Niveau difficile (12 lettres et plus)");

		buttonPartieRapide.getItems().addAll(facile, moyen, difficile);

		// Permets à la page de jeu de savoir la difficulté (1, 2, 3) et le nombre de
		// partie (0/1)

		facile.setOnAction((e) -> {
			int[] donneeATransmettre = { 1, 0 };
			try {
				App.setRoot("jeu", donneeATransmettre);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		moyen.setOnAction((e) -> {
			int[] donneeATransmettre = { 2, 0 };
			try {
				App.setRoot("jeu", donneeATransmettre);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		difficile.setOnAction((e) -> {
			int[] donneeATransmettre = { 3, 0 };
			try {
				App.setRoot("jeu", donneeATransmettre);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

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

				double bottomMargin = 10; // Marge en bas (ajustez selon vos besoins)
				double centerYAnchor = parentContainer.getHeight() - anchorClavier.getHeight() - bottomMargin;
				anchorClavier.setLayoutY(centerYAnchor);
			}
		};

		// Ajoutez un écouteur d'événements pour le redimensionnement du parent
		parentContainer.widthProperty().addListener(dimensionsChangeListener);

		// Initialisez la position initiale du label
		dimensionsChangeListener.changed(null, null, null);
	}

	@Override
	public void afficherGrilleDeJeuInterface(Mot motATrouver, GridPane grilleJeu, Button buttonVal) {
		int taille = motATrouver.getLongueurMot();
		// Supprimer toutes les colonnes existantes
		grilleJeu.getColumnConstraints().clear();

		for (int col = 0; col < taille; col++) {
			ColumnConstraints colConst = new ColumnConstraints();
			colConst.setPercentWidth(100.0 / taille);
			grilleJeu.getColumnConstraints().add(colConst);
		}

		// Supprimer toutes les lignes existantes
		grilleJeu.getRowConstraints().clear();

		grilleJeu.setVgap(10.0);

		for (int row = 0; row < 6; row++) {
			RowConstraints rowConst = new RowConstraints();
			rowConst.setPercentHeight(100.0 / 6);
			grilleJeu.getRowConstraints().add(rowConst);

			for (int col = 0; col < taille; col++) {
				Label label = new Label();
				if (col == 0 && row == 0) {
					String premiereLettre = Character.toUpperCase(motATrouver.getMot().charAt(0)) + "";
					label.setText(premiereLettre);
				} else {
					label.setText("_");
				}
				label.setStyle(
						"-fx-border-color: black; -fx-border-width: 1px; -fx-background-color: white; -fx-font-size: 16px; -fx-min-width: 30px; -fx-alignment: center;");
				grilleJeu.add(label, col, row);
			}
		}
		buttonVal.setDisable(true);
	}

	@Override
	public void changerCouleurGrilleInterface(GridPane grilleJeu, int ligne, int colonne, Color couleur) {
		String style = String.format("-fx-background-color: #%02X%02X%02X;", (int) (couleur.getRed() * 255),
				(int) (couleur.getGreen() * 255), (int) (couleur.getBlue() * 255));

		for (javafx.scene.Node node : grilleJeu.getChildren()) {
			Integer rowIndex = GridPane.getRowIndex(node);
			Integer colIndex = GridPane.getColumnIndex(node);

			if (rowIndex != null && colIndex != null && rowIndex == ligne && colIndex == colonne) {
				((Label) node).setStyle(style);
				break;
			}
		}
	}

}

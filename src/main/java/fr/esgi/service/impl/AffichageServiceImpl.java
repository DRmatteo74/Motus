package fr.esgi.service.impl;

import fr.esgi.service.AffichageService;
import fr.esgi.service.MotService;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class AffichageServiceImpl implements AffichageService {

	private MotService motService = new MotServiceImpl();

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

}

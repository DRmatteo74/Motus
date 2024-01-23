package fr.esgi.service.impl;

import java.util.List;

import fr.esgi.service.AffichageService;
import fr.esgi.service.JeuService;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class JeuServiceImpl implements JeuService {
	private AffichageService affichageService = new AffichageServiceImpl();

	@Override
	public void creerBoutonJeu(List<Button> boutons, int nbEssai, GridPane grilleJeu, Button buttonVal) {

		for (Button button : boutons) {
			button.setOnAction(event -> {
				// Action à effectuer lorsqu'un bouton est cliqué
				String letter = button.getText();
				modifierLabelJeu(grilleJeu, nbEssai, letter, buttonVal);
			});
		}
	}

	@Override
	public void modifierLabelJeu(GridPane grilleJeu, int ligne, String lettre, Button buttonVal) {
		int taille = grilleJeu.getColumnCount() - 1;

		for (javafx.scene.Node node : grilleJeu.getChildren()) {
			Integer rowIndex = GridPane.getRowIndex(node);
			Integer colIndex = GridPane.getColumnIndex(node);

			if (rowIndex != null && colIndex != null && rowIndex == ligne && ((Label) node).getText() == "_") {
				((Label) node).setText(lettre);
				if (colIndex == taille) {
					buttonVal.setDisable(false);
				}
				break;
			}
		}
	}

	@Override
	public void supprimerLabelJeu(GridPane grilleJeu, int ligne, Button buttonVal) {
		int col = grilleJeu.getColumnCount();
		int trouve = 0;
		while (col > 0) {
			for (javafx.scene.Node node : grilleJeu.getChildren()) {
				Integer rowIndex = GridPane.getRowIndex(node);
				Integer colIndex = GridPane.getColumnIndex(node);

				if (rowIndex != null && colIndex != null && rowIndex == ligne && colIndex > 0
						&& ((Label) node).getText() != "_" && colIndex == col) {
					((Label) node).setText("_");
					buttonVal.setDisable(true);
					trouve = 1;
					break;
				}
			}
			if (trouve == 1) {
				break;
			}
			col = col - 1;
		}

	}

	@Override
	public String recupererMot(GridPane grilleJeu, int ligne) {
		String motRentrer = "";
		for (javafx.scene.Node node : grilleJeu.getChildren()) {
			Integer rowIndex = GridPane.getRowIndex(node);
			Integer colIndex = GridPane.getColumnIndex(node);

			if (rowIndex != null && colIndex != null && rowIndex == ligne) {
				motRentrer = motRentrer + ((Label) node).getText();
			}
		}
		System.out.println(motRentrer);
		return motRentrer.toLowerCase();
	}

	@Override
	public boolean verifierMot(String motTrouver, String motGagnant, GridPane grilleJeu, int nbEssai) {
		int nbLettreJuste = 0;
		for (int i = 0; i < motGagnant.length(); i++) {
			// je vérifie si la lettre appartient au mot recherché
			if (appartenirAuMot(motTrouver.charAt(i), motGagnant)) {
				// si la lettre est a la bonne place j'incrémente le nombre de lettre juste de 1
				if (situerCorrectement(motTrouver.charAt(i), motGagnant.charAt(i))) {
					System.out.println("'" + motTrouver.charAt(i) + "'est dans le mot et à la bonne place/");
					affichageService.changerCouleurGrilleInterface(grilleJeu, nbEssai, i, Color.GREEN);
					nbLettreJuste = nbLettreJuste + 1;
				} else {
					if (supprimerDoublon(motGagnant, motTrouver, motTrouver.charAt(i), i)) {
						System.out.println("'" + motTrouver.charAt(i) + "'n'est pas bon/ ");
					} else {
						System.out.println("'" + motTrouver.charAt(i) + "'est dans le mot mais à la mauvaise place/ ");
						affichageService.changerCouleurGrilleInterface(grilleJeu, nbEssai, i, Color.YELLOW);
					}
				}
			} else {
				System.out.println("'" + motTrouver.charAt(i) + "'n'est pas dans le mot/ ");
			}
		}
		return true;
	}

	@Override
	public boolean appartenirAuMot(char caractere, String motGagnant) {
		if (motGagnant.contains(String.valueOf(caractere))) {
			return true;
		}
		return false;
	}

	@Override
	public boolean situerCorrectement(char caractere, char caractereGagnant) {
		if (caractere == caractereGagnant) {
			return true;
		}
		return false;
	}

	@Override
	public boolean supprimerDoublon(String motGagnant, String motJoueur, char lettre, int indice) {
		// autant du même caractere dans chaque mot, on les laisse
		if (compterLettre(motGagnant, lettre) == compterLettre(motJoueur, lettre)) {
			return false;
		}
		// plus de cractere dans le mot gagnant on laisse
		else if (compterLettre(motGagnant, lettre) > compterLettre(motJoueur, lettre)) {
			return false;
		}
		// plus de caractere dans le mot du joueur il faut en supprimé
		else {
			int difference = compterLettre(motJoueur, lettre) - compterLettre(motGagnant, lettre);
			while (difference > 0) {
				int positionLettre = motJoueur.indexOf(lettre);
				if (positionLettre == indice) {
					return true;
				}
				if (!situerCorrectement(motGagnant.charAt(positionLettre), motJoueur.charAt(positionLettre))) {
					difference--;
					motJoueur = motJoueur.substring(0, positionLettre) + " " + motJoueur.substring(positionLettre + 1);
					motGagnant = motGagnant.substring(0, positionLettre) + " "
							+ motGagnant.substring(positionLettre + 1);
				}
			}
			return false;
		}
	}

	@Override
	public int compterLettre(String mot, char lettre) {
		int count = 0;
		for (int i = 0; i < mot.length(); i++) {
			if (mot.charAt(i) == lettre) {
				count++;
			}
		}
		return count;
	}

}

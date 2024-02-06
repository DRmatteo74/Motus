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

	/**
	 * Créer les boutons du clavier pour le jeu
	 * 
	 * @param boutons
	 * @param nbEssai
	 * @param grilleJeu
	 * @param buttonVal
	 */
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

	/**
	 * Change le texte du label
	 * 
	 * @param ligne
	 * @param grilleJeu
	 * @param lettre
	 * @param buttonVal
	 */
	@Override
	public void modifierLabelJeu(GridPane grilleJeu, int ligne, String lettre, Button buttonVal) {
		int taille = grilleJeu.getColumnCount() - 1;

		// parcour la grille pour trouver le bon label
		for (javafx.scene.Node node : grilleJeu.getChildren()) {
			Integer rowIndex = GridPane.getRowIndex(node);
			Integer colIndex = GridPane.getColumnIndex(node);

			if (rowIndex != null && colIndex != null && rowIndex == ligne && ((Label) node).getText() == "_") {
				// change le label
				((Label) node).setText(lettre);
				if (colIndex == taille) {
					// active le bouton valider si le mot est à la bonne taille
					buttonVal.setDisable(false);
				}
				break;
			}
		}
	}

	/**
	 * supprime la derniere lettre ecrite dans un label
	 * 
	 * @param ligne
	 * @param grilleJeu
	 * @param buttonVal
	 */
	@Override
	public void supprimerLabelJeu(GridPane grilleJeu, int ligne, Button buttonVal) {
		// j'initialise cette variable pour enlever le dernier element
		int col = grilleJeu.getColumnCount();
		int trouve = 0;
		// je parcours la grille tant qu'il reste des éléments
		while (col > 0) {
			for (javafx.scene.Node node : grilleJeu.getChildren()) {
				Integer rowIndex = GridPane.getRowIndex(node);
				Integer colIndex = GridPane.getColumnIndex(node);

				// je regarde si l'élément est différents de la valeur par défaults
				if (rowIndex != null && colIndex != null && rowIndex == ligne && colIndex > 0
						&& ((Label) node).getText() != "_" && colIndex == col) {
					((Label) node).setText("_");
					// je desactive le bouton validé
					buttonVal.setDisable(true);
					trouve = 1;
					break;
				}
			}
			// si l'élément est trouvé je sors de ma boucle
			if (trouve == 1) {
				break;
			}
			col = col - 1;
		}

	}

	/**
	 * Récupère le mot rentrer par le joueur
	 * 
	 * @param ligne
	 * @param grilleJeu
	 * 
	 * @return String
	 */
	@Override
	public String recupererMot(GridPane grilleJeu, int ligne) {
		String motRentrer = "";
		// je parcours les éléments de ma ligne un par un et je reforme le mot
		for (javafx.scene.Node node : grilleJeu.getChildren()) {
			Integer rowIndex = GridPane.getRowIndex(node);
			Integer colIndex = GridPane.getColumnIndex(node);

			if (rowIndex != null && colIndex != null && rowIndex == ligne) {
				motRentrer = motRentrer + ((Label) node).getText();
			}
		}
		return motRentrer.toLowerCase();
	}

	/**
	 * Change le texte du label
	 * 
	 * @param motTrouver
	 * @param grilleJeu
	 * @param motGagnant
	 * @param nbEssai
	 * 
	 * @return boolean
	 */
	@Override
	public boolean verifierMot(String motTrouver, String motGagnant, GridPane grilleJeu, int nbEssai) {
		int nbLettreJuste = 0;
		// Je parcours chaque lettre de mon mot
		for (int i = 0; i < motGagnant.length(); i++) {
			// je vérifie si la lettre appartient au mot recherché
			if (appartenirAuMot(motTrouver.charAt(i), motGagnant)) {
				// si la lettre est a la bonne place j'incrémente le nombre de lettre juste de 1
				if (situerCorrectement(motTrouver.charAt(i), motGagnant.charAt(i))) {
					// je change le design du label
					affichageService.changerCouleurGrilleInterface(grilleJeu, nbEssai, i, Color.LIGHTGREEN);
					nbLettreJuste = nbLettreJuste + 1;
				} else {
					if (!(supprimerDoublon(motGagnant, motTrouver, motTrouver.charAt(i), i))) {
						affichageService.changerCouleurGrilleInterface(grilleJeu, nbEssai, i, Color.YELLOW);
					}
				}
			}
		}
		if (nbLettreJuste == motGagnant.length()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * je regarde si la lettre appartient au mot a trouver
	 * 
	 * @param caractere
	 * @param motGagnant
	 * @return boolean
	 */
	@Override
	public boolean appartenirAuMot(char caractere, String motGagnant) {
		if (motGagnant.contains(String.valueOf(caractere))) {
			return true;
		}
		return false;
	}

	/**
	 * je regarde si la lettre est à la bonne place
	 * 
	 * @param caractere
	 * @param caractereGagnant
	 * @return boolean
	 */
	@Override
	public boolean situerCorrectement(char caractere, char caractereGagnant) {
		if (caractere == caractereGagnant) {
			return true;
		}
		return false;
	}

	/**
	 * J'affiche correctement les lettres si pour qu'il n'y ai pas de doublons
	 * 
	 * si je rentre deux E et qu'il y en a que un seul dan sle mot à trouver un seul
	 * apparaitra en verre ou en jaune
	 * 
	 * @param motGagnant
	 * @param motJoueur
	 * @param lettre
	 * @param indice
	 * @return boolean
	 */
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

	/**
	 * Compte le nombre d'un caractere dans un mot
	 * 
	 * @param mot
	 * @param lettre
	 * @return int
	 */
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

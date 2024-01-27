package fr.esgi.service;

import java.util.List;

import fr.esgi.business.Difficulte;
import fr.esgi.business.Joueur;
import fr.esgi.business.Partie;
import fr.esgi.business.Question;

/**
 * Service qui concerne toutes fonctions de la class Partie
 */
public interface PartieService {
	void innitialiserPartie(List<Question> listQuestion, Difficulte difficulte, Joueur joueur);

	Partie recupererDernierePartie();

	void changerListQuestion(Partie partie, Question question);
}

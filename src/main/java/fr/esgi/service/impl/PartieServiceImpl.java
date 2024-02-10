package fr.esgi.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.esgi.business.Difficulte;
import fr.esgi.business.Joueur;
import fr.esgi.business.Partie;
import fr.esgi.business.Question;
import fr.esgi.service.PartieService;

public class PartieServiceImpl implements PartieService {
	ArrayList<Partie> parties = new ArrayList<>();

	/**
	 * Je créer une partie et l'ajoute à ma liste de partie
	 *
	 * @param difficulte
	 * @param joueur
	 */
	@Override
	public void innitialiserPartie(Difficulte difficulte, Joueur joueur) {
		Partie partie = new Partie(difficulte, joueur);
		parties.add(partie);

	}

	/**
	 * Recupere la dernière partie créer
	 * 
	 * @return Partie
	 */
	@Override
	public Partie recupererDernierePartie() {
		return parties.get(parties.size() - 1);
	}

	/**
	 * Met à jour la liste des Question de ma partie
	 * 
	 * @param partie
	 * @param question
	 */
	@Override
	public void changerListQuestion(Partie partie, Question question) {
		List<Question> listQuestion = new ArrayList<>();
		// je récupère la, liste déjà présente
		listQuestion = partie.getQuestions();
		// j'ajoute ma question
		listQuestion.add(question);
		// je change la liste de ma partie
		partie.setQuestions(listQuestion);
	}

}

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
		if(parties.isEmpty()) return null;
		return parties.get(parties.size() - 1);
	}

	/**
	 * Met à jour la liste des Question de ma partie
	 * 
	 * @param partie
	 * @param _question
	 */
	@Override
	public void changerListQuestion(Partie partie, Question _question) {
		Question question = _question;
		partie.getQuestions().add(question);
	}

}

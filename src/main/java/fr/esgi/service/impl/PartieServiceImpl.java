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

	@Override
	public void innitialiserPartie(List<Question> listQuestion, Difficulte difficulte, Joueur joueur) {
		Partie partie = new Partie(difficulte, listQuestion, joueur);
		parties.add(partie);

	}

	@Override
	public Partie recupererDernierePartie() {
		return parties.get(parties.size() - 1);
	}

	@Override
	public void changerListQuestion(Partie partie, Question question) {
		List<Question> listQuestion = new ArrayList<>();
		listQuestion = partie.getQuestions();
		listQuestion.add(question);
		partie.setQuestions(listQuestion);
	}

}

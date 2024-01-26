package fr.esgi.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.esgi.business.Mot;
import fr.esgi.business.Partie;
import fr.esgi.business.Question;
import fr.esgi.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {

	private static ArrayList<Question> questions = new ArrayList<>();

	@Override
	public Question creerQuestion(Long tempsReponse, List<String> reponse, Mot mot, Partie partie) {
		Question question = new Question();
		question.setMot(mot);
		question.setPartie(partie);
		question.setReponses(reponse);
		question.setTempsReponse(tempsReponse);

		return question;
	}

	@Override
	public void importerQuestion(Question question) {
		questions.add(question);
	}

	@Override
	public Question recupererQuestionParid(Long id) {
		return questions.stream().filter(mot -> mot.getId().equals(id)).findFirst().orElse(null);
	}

	@Override
	public ArrayList<Question> recupererQuestions() {
		return questions;
	}

}

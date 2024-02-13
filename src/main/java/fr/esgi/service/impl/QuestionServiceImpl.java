package fr.esgi.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.esgi.business.Mot;
import fr.esgi.business.Partie;
import fr.esgi.business.Question;
import fr.esgi.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {

	private static ArrayList<Question> questions = new ArrayList<>();

	/**
	 * Création d'une question
	 * 
	 * @param tempsReponse
	 * @param reponse
	 * @param mot
	 * @param partie
	 * 
	 * @return question
	 */
	@Override
	public Question creerQuestion(Long tempsReponse, List<String> reponse, Mot mot, Partie partie) {
		Question question = new Question();
		question.setMot(mot);
		question.setPartie(partie);
		List<String> nouvellesReponses = new ArrayList<>(reponse);
		question.setReponses(nouvellesReponses);
		question.setTempsReponse(tempsReponse);
		importerQuestion(question);

		return question;
	}

	/**
	 * importe une questions dans la liste de question
	 * 
	 * @param question
	 */
	@Override
	public void importerQuestion(Question question) {
		questions.add(question);
	}

	/**
	 * Recupere une question par son id
	 * 
	 * @param id
	 * @return question
	 */
	@Override
	public Question recupererQuestionParid(Long id) {
		return questions.stream().filter(mot -> mot.getId().equals(id)).findFirst().orElse(null);
	}

	/**
	 * Retourne la liste de questions
	 * 
	 * @return ArrayList<Question>
	 */
	@Override
	public ArrayList<Question> recupererQuestions() {
		return questions;
	}

}

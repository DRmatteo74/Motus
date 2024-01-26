package fr.esgi.service;

import java.util.ArrayList;
import java.util.List;

import fr.esgi.business.Mot;
import fr.esgi.business.Partie;
import fr.esgi.business.Question;

public interface QuestionService {

	Question creerQuestion(Long tempsReponse, List<String> reponse, Mot mot, Partie partie);

	void importerQuestion(Question question);

	Question recupererQuestionParid(Long id);

	ArrayList<Question> recupererQuestions();

}

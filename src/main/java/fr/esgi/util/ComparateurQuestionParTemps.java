package fr.esgi.util;

import fr.esgi.business.Question;

import java.util.Comparator;

public class ComparateurQuestionParTemps implements Comparator<Question> {

    @Override
    public int compare(Question q1, Question q2) {
        return Long.compare(q2.getTempsReponse(), q1.getTempsReponse());
    }
}

package fr.esgi.util;

import fr.esgi.business.Question;

import java.util.Comparator;

public class ComparateurQuestionParMot implements Comparator<Question> {

    @Override
    public int compare(Question q1, Question q2) {
        return q1.getMot().getMot().compareTo(q2.getMot().getMot());
    }
}

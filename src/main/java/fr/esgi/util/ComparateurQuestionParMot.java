package fr.esgi.util;

import fr.esgi.business.Question;

import java.util.Comparator;

/**
 * Permet de trier les questions par ordre alphabétique
 */
public class ComparateurQuestionParMot implements Comparator<Question> {

    /**
     * @param q1 the first object to be compared.
     * @param q2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Question q1, Question q2) {
        return q1.getMot().getMot().compareTo(q2.getMot().getMot());
    }
}

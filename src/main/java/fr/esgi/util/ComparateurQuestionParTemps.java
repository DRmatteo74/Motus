package fr.esgi.util;

import fr.esgi.business.Question;

import java.util.Comparator;

/**
 * Permet de trier les questions par temps dans l'ordre décroissant
 */
public class ComparateurQuestionParTemps implements Comparator<Question> {

    /**
     * @param q1 the first object to be compared.
     * @param q2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Question q1, Question q2) {
        return Long.compare(q2.getTempsReponse(), q1.getTempsReponse());
    }
}

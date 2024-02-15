package fr.esgi.business;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class QuestionTest {
    @Test
    void testGettersSetters() {
        Question question = new Question();
        setupQuestion(question);

        assertNotNull(question.getId());
        assertNotNull(question.getTempsReponse());
        assertNotNull(question.getReponses());
        assertNotNull(question.getMot());
        assertNotNull(question.getPartie());
    }

    @Test
    void testDefaultConstructor(){
        Question question = new Question();
        assertNotNull(question.getId());
    }

    @Test
    void testHashCode(){
        Question question1 = new Question();
        Question question2 = new Question();

        setupQuestion(question1);
        setupQuestion(question2);

        assertNotEquals(question1.hashCode(), question2.hashCode());
    }

    @Test
    void testEquals(){
        Question question1 = new Question();
        Question question2 = new Question();

        setupQuestion(question1);
        setupQuestion(question2);

        assertNotEquals(question1, question2);
    }

    @Test
    void testToString(){
        Question question = new Question();
        setupQuestion(question);

        String expectedString = "Question [id=1, tempsReponse=1000, reponses=[Toto, Toto2], mot=Mot [id=9, mot=Toto, longueurMot=4]]";
        assertEquals(expectedString, question.toString());
    }

    private void setupQuestion(Question question) {
        Long tempsReponse = 1000L;
        List<String> reponses = new ArrayList<>();
        reponses.add("Toto");
        reponses.add("Toto2");
        Mot mot = new Mot("Toto", 4);
        Partie partie = new Partie();

        question.setTempsReponse(tempsReponse);
        question.setReponses(reponses);
        question.setMot(mot);
        question.setPartie(partie);
    }


}

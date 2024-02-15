package fr.esgi.business;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PartieTest {

    @Test
    void testGettersSetters() {
        Partie partie = new Partie();
        Difficulte difficulte = new Difficulte();
        List<Question> questions = new ArrayList<>();
        Joueur joueur = new Joueur();

        partie.setDifficulte(difficulte);
        partie.setQuestions(questions);
        partie.setJoueur(joueur);

        assertNotNull(partie.getId());
        assertNotNull(partie.getDifficulte());
        assertNotNull(partie.getQuestions());
        assertNotNull(partie.getJoueur());
    }

    @Test
    void testDefaultConstructor(){
        Partie partie = new Partie();
        assertNotNull(partie.getId());
    }

    @Test
    void testSecondConstructor(){
        Difficulte difficulte = new Difficulte();
        Joueur joueur = new Joueur();
        Partie partie = new Partie(difficulte,joueur);

        assertNotNull(partie.getDifficulte());
        assertNotNull(partie.getJoueur());
    }
    @Test
    void testThirdConstructor(){
        Difficulte difficulte = new Difficulte();
        List<Question> questions = new ArrayList<>();
        Joueur joueur = new Joueur();
        Partie partie = new Partie(difficulte,questions,joueur);

        assertNotNull(partie.getDifficulte());
        assertNotNull(partie.getJoueur());
    }

    @Test
    void testHashCode(){
        Difficulte difficulte = new Difficulte();
        List<Question> questions = new ArrayList<>();
        Joueur joueur = new Joueur();
        Partie partie1 = new Partie(difficulte,questions,joueur);
        Partie partie2 = new Partie(difficulte,questions,joueur);

        assertNotEquals(partie1.hashCode(), partie2.hashCode());
        assertNotEquals(partie1.hashCode(), partie2.hashCode());
    }

    @Test
    void testEquals(){
        Difficulte difficulte = new Difficulte();
        List<Question> questions = new ArrayList<>();
        Joueur joueur = new Joueur();
        Partie partie1 = new Partie(difficulte,questions,joueur);
        Partie partie2 = new Partie(difficulte,questions,joueur);

        assertNotEquals(partie1, partie2);
    }

    @Test
    void testToString(){
        Difficulte difficulte = new Difficulte();
        List<Question> questions = new ArrayList<>();
        Joueur joueur = new Joueur();
        Partie partie = new Partie(difficulte,questions,joueur);

        String expectedString = "Partie [id=2, difficulte=Difficulte [id=10, labelDifficulte=null], questions=[]]";
        assertEquals(expectedString, partie.toString());
    }

}
